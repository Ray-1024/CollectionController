package itmo.labs.commands;

import itmo.labs.data.StudyGroup;
import itmo.labs.data.StudyGroupCollection;
import itmo.labs.terminal.MicroShell;

/**
 * Команда добавляет в коллекция элемент если он меньше всех элементов коллекции
 * Т.к сортировка по умолчанию сравнивает группы по названию, то добавляет элемент если название его группы лексикографически меньше любого другого названия групп из коллекции
 */
public class AddIfMinCommand extends BaseCommand {
    StudyGroup elem = null;

    public AddIfMinCommand(MicroShell _parentShell, StudyGroup elem) {
        super(_parentShell);
        this.elem = elem;
    }

    @Override
    public void execute() {
        if (elem != null && parentShell != null && parentShell.getManagedCollection() != null) {
            StudyGroupCollection coll = parentShell.getManagedCollection();
            for (int i = 0; i < coll.size(); ++i) {
                if (coll.get(i).compareTo(elem) <= 0) return;
            }
            coll.add(elem);
        }
    }
}
