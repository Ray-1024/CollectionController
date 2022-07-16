package ray1024.projects.collectioncontroller.commands;

import ray1024.projects.collectioncontroller.data.StudyGroup;
import ray1024.projects.collectioncontroller.terminal.MicroShell;

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
