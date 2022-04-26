package itmo.labs.tools;

import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Интерфейс используемый классами их пакета itmo.labs.data
 * Используется для опрашивания пользователя в интерактивном режиме
 */
public interface IInput {
    void input(Scanner scanner)throws  EOFException;
}
