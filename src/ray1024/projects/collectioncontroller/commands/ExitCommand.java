package ray1024.projects.collectioncontroller.commands;

/**
 * Завершает программу
 * Не сохраняет коллекцию в файл
 */
public class ExitCommand extends BaseCommand {

    @Override
    public void execute() {
        System.exit(0);
    }
}
