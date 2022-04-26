package itmo.labs.commands;

import itmo.labs.terminal.MicroShell;

/**
 * Случайным образом перемешивает элементы коллекции
 */
public class ShuffleCommand extends BaseCommand {

    public ShuffleCommand(MicroShell _parentShell) {
        super(_parentShell);
    }

    @Override
    public void execute() {
        if (parentShell != null && parentShell.getManagedCollection() != null)
            parentShell.getManagedCollection().randomShuffle();
    }
}
