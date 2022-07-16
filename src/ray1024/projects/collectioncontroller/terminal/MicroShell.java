package ray1024.projects.collectioncontroller.terminal;

import ray1024.projects.collectioncontroller.commands.BaseCommand;
import ray1024.projects.collectioncontroller.data.StudyGroupCollection;
import ray1024.projects.collectioncontroller.interfaces.IExecute;

import java.util.ArrayList;

/**
 * Класс предназначенный для исполнения команд из очереди, пока та не закончится
 */
public class MicroShell implements IExecute {
    private StudyGroupCollection managedCollection = new StudyGroupCollection();
    private Terminal parentTerminal = null;
    private ArrayList<BaseCommand> commandsQueue = new ArrayList<BaseCommand>();

    public Terminal getParentTerminal() {
        return parentTerminal;
    }

    public MicroShell(Terminal parentTerminal, StudyGroupCollection managedCollection) {
        this.managedCollection = managedCollection;
        this.parentTerminal = parentTerminal;
    }

    @Override
    public void execute() {
        for (BaseCommand baseCommand : commandsQueue) {
            baseCommand.execute();
        }
        commandsQueue.clear();
    }

    public StudyGroupCollection getManagedCollection() {
        return managedCollection;
    }

    public void addCommandInQueue(BaseCommand command) {
        if (command != null) commandsQueue.add(command);
    }

    public void addCommandsInQueue(ArrayList<BaseCommand> commandsDump) {
        if (commandsDump != null) commandsQueue.addAll(commandsDump);
    }


}
