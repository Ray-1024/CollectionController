package itmo.labs.commands;

import itmo.labs.terminal.MicroShell;

/**
 * Завершает программу
 * Не сохраняет коллекцию в файл
 */
public class ExitCommand extends BaseCommand {

    @Override
    public void execute() {
        System.exit(0);
    }
}
