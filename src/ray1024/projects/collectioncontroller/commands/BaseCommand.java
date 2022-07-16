package ray1024.projects.collectioncontroller.commands;

import ray1024.projects.collectioncontroller.interfaces.IExecute;
import ray1024.projects.collectioncontroller.terminal.MicroShell;

import java.io.Serializable;

/**
 * Базовый класс для реализации команд, исполняемых Microshell
 */
public class BaseCommand implements IExecute, Serializable, Cloneable {

    private String name = "BaseCommand";
    private String description = "Base command";
    private MicroShell parentShell = null;

    public BaseCommand() {
    }

    public String getName() {
        return name;
    }

    public BaseCommand setName(String name) {
        this.name = name;
        return this;
    }

    public BaseCommand setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MicroShell getParentShell() {
        return parentShell;
    }

    public BaseCommand setParentShell(MicroShell parentShell) {
        this.parentShell = parentShell;
        return this;
    }

    public boolean parseCommand(String[] args) {
        return false;
    }

    public int parseCommandFromText(String[] args, String[] lines, int offset) {
        return -1;
    }

    @Override
    protected Object clone() {
        return new BaseCommand().setName(this.name).setDescription(this.description).setParentShell(parentShell);
    }

    @Override
    public void execute() {

    }
}
