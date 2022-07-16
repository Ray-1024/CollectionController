package ray1024.projects.collectioncontroller.interfaces;

import java.io.EOFException;
import java.util.Scanner;

/**
 * Интерфейс используемый классами их пакета itmo.labs.data
 * Используется для опрашивания пользователя в интерактивном режиме
 */
public interface IInput {
    void input(Scanner scanner)throws  EOFException;
}
