package ray1024.projects.collectioncontroller.terminal;

import org.xml.sax.InputSource;
import ray1024.projects.collectioncontroller.commands.BaseCommand;
import ray1024.projects.collectioncontroller.commands.CommandBuilder;
import ray1024.projects.collectioncontroller.data.StudyGroup;
import ray1024.projects.collectioncontroller.data.StudyGroupCollection;
import ray1024.projects.collectioncontroller.tools.Phrases;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс хранящий коллекцию и управляющий дочерними MicroShell'ами
 * Так же занимается загрузкой и сохранением коллекции
 * Максимальное колличество исполняющихся Microshell'ов : 10
 */
public class Terminal {
    private static final int microShellsLimit = 10;
    private ArrayList<MicroShell> microShells = new ArrayList<MicroShell>();
    private StudyGroupCollection managedCollection = null;
    private Scanner scanner = new Scanner(System.in);
    private String collectionFilename = null;

    public Terminal(String CollectionFilename) {
        if (CollectionFilename == null) System.out.println(Phrases.CantLoadAndSave);
        collectionFilename = CollectionFilename;
        loadCollection(CollectionFilename);
        microShells.add(new MicroShell(this, managedCollection));
    }

    private void loadCollection(String filename) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(Paths.get(filename)));
            XMLDecoder xmlDecoder = new XMLDecoder(new InputSource(inputStreamReader));
            managedCollection = (StudyGroupCollection) xmlDecoder.readObject();
            xmlDecoder.close();
            inputStreamReader.close();
            for (int i = 0; i < managedCollection.size(); ++i)
                if (StudyGroup.getNextID() <= managedCollection.get(i).getId())
                    StudyGroup.setNextID(managedCollection.get(i).getId());
            return;
        } catch (Exception ex) {

        }
        managedCollection = new StudyGroupCollection();
        System.out.println(Phrases.ErrorLoadCollection);
    }

    public void saveCollection() {
        if (collectionFilename == null) return;
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(collectionFilename)));
            xmlEncoder.writeObject(managedCollection);
            xmlEncoder.close();
            return;
        } catch (FileNotFoundException ignored) {
        }
        System.out.println(Phrases.ErrorSaveCollection);
    }

    public void running() {
        String line = "";
        try {
            while (true) {
                line = scanner.nextLine();
                BaseCommand baseCommand = CommandBuilder.parseInteractiveCommand(line, microShells.get(0));
                microShells.get(0).addCommandInQueue(baseCommand);
                microShells.get(0).execute();
            }
        } catch (Exception ex) {
            System.out.println(Phrases.EndOfTerminalWork);
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void addAndStartMicroShell(ArrayList<BaseCommand> forExecute) {
        try {
            if (microShells.size() == microShellsLimit) throw new Exception();
            microShells.add(new MicroShell(this, managedCollection));
            microShells.get(microShells.size() - 1).addCommandsInQueue(forExecute);
            microShells.get(microShells.size() - 1).execute();
            microShells.remove(microShells.size() - 1);
        } catch (Exception e) {
            System.out.println(Phrases.CantCreateMicroShell);
        }
    }

}
