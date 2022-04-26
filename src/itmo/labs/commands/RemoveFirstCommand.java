package itmo.labs.commands;

import itmo.labs.terminal.MicroShell;

/**
 * Удаляет из коллекции первый элемент
 */
public class RemoveFirstCommand extends BaseCommand {
    public RemoveFirstCommand() {
    }

    public RemoveFirstCommand(MicroShell _parentShell) {
        super(_parentShell);
    }

    @Override
    public void execute() {
        if (parentShell != null && parentShell.getManagedCollection() != null)
            parentShell.getManagedCollection().removeAtIndex(0);
    }
}
