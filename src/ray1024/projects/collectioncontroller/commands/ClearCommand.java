package ray1024.projects.collectioncontroller.commands;

import ray1024.projects.collectioncontroller.terminal.MicroShell;

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
