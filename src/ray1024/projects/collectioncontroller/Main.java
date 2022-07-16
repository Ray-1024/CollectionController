package ray1024.projects.collectioncontroller;

import ray1024.projects.collectioncontroller.data.Coordinates;
import ray1024.projects.collectioncontroller.data.Location;
import ray1024.projects.collectioncontroller.tools.Phrases;

import java.util.Scanner;

/**
 * Главный красс создающий и запускающий Терминал
 *
 * @MyTag aloha
 */
public class Main {

    public static void main(String[] args) {

//        String filename = null;
//        try {
//            filename = System.getenv("CCFilename");
//        } catch (RuntimeException ignored) {
//        }
//        Terminal terminal = new Terminal(filename);
//        terminal.running();
        Scanner scanner = new Scanner(System.in);
        Phrases.setLocale("Russian");
        Coordinates coordinates = new Coordinates();
        while (!coordinates.isObjectReady()) {
            System.out.println(coordinates.getDescription());
            try {
                coordinates.inputLine(scanner.nextLine());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
