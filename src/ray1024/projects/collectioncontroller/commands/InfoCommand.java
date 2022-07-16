package ray1024.projects.collectioncontroller.commands;

import ray1024.projects.collectioncontroller.terminal.MicroShell;

/**
 * Выводит служебную информация о коллекции
 * Например: дата создания, колличество элементов
 */
public class InfoCommand extends BaseCommand {
    public InfoCommand(MicroShell _parentShell) {
        super(_parentShell);
    }

    @Override
    public void execute() {
        if (parentShell != null && parentShell.getManagedCollection() != null)
            System.out.println(parentShell.getManagedCollection().getCollectionInfo());
    }
}
