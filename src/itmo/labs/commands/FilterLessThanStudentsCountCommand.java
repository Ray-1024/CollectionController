package itmo.labs.commands;

import itmo.labs.data.StudyGroupCollection;
import itmo.labs.terminal.MicroShell;

/**
 * Выводит те элементы коллекции, которые имеют меньшее колличество студентов в группе чем задано в параметре
 */
public class FilterLessThanStudentsCountCommand extends BaseCommand {
    int studentsCount = 0;

    public FilterLessThanStudentsCountCommand(MicroShell _parentShell, int studentsCount) {
        super(_parentShell);
        this.studentsCount = studentsCount;
    }

    @Override
    public void execute() {
        if (parentShell != null && parentShell.getManagedCollection() != null) {
            StudyGroupCollection coll = parentShell.getManagedCollection();
            int ind = 1;
            for (int i = 0; i < coll.size(); ++i) {
                if (coll.get(i).getStudentsCount() < studentsCount) {
                    System.out.print("    " + ind + ". ");
                    System.out.println(coll.get(i));
                }
            }
        }
    }
}
