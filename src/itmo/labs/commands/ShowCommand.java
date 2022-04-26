package itmo.labs.commands;

import itmo.labs.terminal.MicroShell;

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
