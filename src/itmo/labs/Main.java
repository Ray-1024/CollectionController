package itmo.labs;

import itmo.labs.terminal.Terminal;

/**
 * Главный красс создающий и запускающий Терминал
 */
public class Main {

    public static void main(String[] args) {

        String filename = null;
        try {
            filename = System.getenv("CCFilename");
        } catch (RuntimeException ignored) {
        }
        Terminal terminal = new Terminal(filename);
        terminal.running();
    }
}
