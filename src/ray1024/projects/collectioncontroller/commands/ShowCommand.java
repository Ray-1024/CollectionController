package ray1024.projects.collectioncontroller.commands;

import ray1024.projects.collectioncontroller.terminal.MicroShell;

/**
 * Показывает все элементы коллекции
 */
public class ShowCommand extends BaseCommand {

    public ShowCommand(MicroShell _parentShell) {
        super(_parentShell);
    }

    @Override
    public void execute() {
        if (parentShell != null && parentShell.getManagedCollection() != null)
            System.out.println(parentShell.getManagedCollection());
    }
}
