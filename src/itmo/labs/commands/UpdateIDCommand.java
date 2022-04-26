package itmo.labs.commands;

import itmo.labs.data.StudyGroup;
import itmo.labs.terminal.MicroShell;

/**
 * Перезаписывает элемент коллекции с ID равным аргументу
 */
public class UpdateIDCommand extends BaseCommand {
    int id = -1;
    StudyGroup elem = null;

    public UpdateIDCommand(MicroShell _parentShell, StudyGroup element, int intID) {
        super(_parentShell);
        elem = element;
        id = intID;
    }

    @Override
    public void execute() {
        if (parentShell != null && parentShell.getManagedCollection() != null)
            parentShell.getManagedCollection().updateById(id, elem);
    }
}
