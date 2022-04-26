package itmo.labs.commands;

import itmo.labs.terminal.MicroShell;

/**
 * Команда очищающая коллекцию, делая ее пустой
 */
public class ClearCommand extends BaseCommand {

    public ClearCommand(MicroShell _parentShell) {
        super(_parentShell);
    }

    @Override
    public void execute() {
        if (parentShell != null && parentShell.getManagedCollection() != null)
            parentShell.getManagedCollection().clear();
    }
}
