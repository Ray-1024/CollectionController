package itmo.labs.commands;

import itmo.labs.data.StudyGroup;
import itmo.labs.terminal.MicroShell;

/**
 * Команда добавляет в коллекцию элемент
 */
public class AddCommand extends BaseCommand {
    StudyGroup studyGroup = null;

    public AddCommand(MicroShell _parentShell, StudyGroup _studyGroup) {
        super(_parentShell);
        studyGroup = _studyGroup;
    }


    @Override
    public void execute() {
        if (parentShell != null && parentShell.getManagedCollection() != null) {
            try {
                parentShell.getManagedCollection().add(studyGroup);
            } catch (Exception e) {
                return;
            }
        }
    }
}
