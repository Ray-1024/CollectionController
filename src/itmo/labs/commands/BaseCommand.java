package itmo.labs.commands;

import itmo.labs.terminal.MicroShell;
import itmo.labs.tools.IExecute;

/**
 * Базовый класс для реализации команд, исполняемых Microshell
 */
public class BaseCommand implements IExecute {

    protected MicroShell parentShell = null;

    public BaseCommand() {
    }

    public BaseCommand(MicroShell _parentShell) {
        this.parentShell = _parentShell;
    }

    @Override
    public void execute() {
    }
}
