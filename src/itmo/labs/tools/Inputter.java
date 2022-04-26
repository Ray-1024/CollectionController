package itmo.labs.tools;

import itmo.labs.data.FormOfEducation;
import itmo.labs.data.Semester;

import java.io.EOFException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Класс-Инструмент
 * Для ввода некоторых типов данных и повторов запросов в случае неверного пользовательского ввода
 */
public class Inputter {

    public static Integer getInt(Scanner scanner, String requestText) throws EOFException {
        if (scanner == null) throw new EOFException();

        Integer res = null;
        String s = "";

        do {
            System.out.println(requestText);
            try {
                if (!scanner.hasNextLine()) throw new EOFException();
                s = scanner.nextLine();
                if ("".equals(s)) return null;
                res = Integer.parseInt(s);
                break;
            } catch (NumberFormatException ex) {
                System.out.println(Phrases.WrongInput);
            } catch (RuntimeException ex) {
                throw new EOFException();
            }
        } while (true);

        return res.intValue();
    }

    public static Float getFloat(Scanner scanner, String requestText) throws EOFException {
        if (scanner == null) throw new EOFException();

        Float res = null;
        String s = "";

        do {
            System.out.println(requestText);
            try {
                if (!scanner.hasNextLine()) throw new EOFException();
                s = scanner.nextLine();
                if ("".equals(s)) return null;
                res = Float.parseFloat(s);
                break;
            } catch (NumberFormatException ex) {
                System.out.println(Phrases.WrongInput);
            } catch (RuntimeException ex) {
                throw new EOFException();
            }
        } while (true);

        return res.floatValue();
    }

    public static FormOfEducation getFormOfEducation(Scanner scanner, String requestText) throws EOFException {
        if (scanner == null) throw new EOFException();

        FormOfEducation res = null;
        String s = "";

        do {
            System.out.println(requestText);
            try {
                if (!scanner.hasNextLine()) throw new EOFException();
                s = scanner.nextLine();
                if ("".equals(s)) return null;
                res = FormOfEducation.valueOf(s);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(Phrases.WrongInput);
            } catch (RuntimeException ex) {
                throw new EOFException();
            }
        } while (true);

        return res;
    }

    public static Semester getSemester(Scanner scanner, String requestText) throws EOFException {
        if (scanner == null) throw new EOFException();

        Semester res = null;
        String s = "";

        do {
            System.out.println(requestText);
            try {
                if (!scanner.hasNextLine()) throw new EOFException();
                s = scanner.nextLine();
                if ("".equals(s)) return null;
                res = Semester.valueOf(s);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(Phrases.WrongInput);
            } catch (RuntimeException ex) {
                throw new EOFException();
            }
        } while (true);

        return res;
    }

    public static Double getDouble(Scanner scanner, String requestText) throws EOFException {
        if (scanner == null) throw new EOFException();

        Double res = null;
        String s = "";

        do {
            System.out.println(requestText);
            try {
                if (!scanner.hasNextLine()) throw new EOFException();
                s = scanner.nextLine();
                if ("".equals(s)) return null;
                res = Double.parseDouble(s);
                break;
            } catch (NumberFormatException ex) {
                System.out.println(Phrases.WrongInput);
            } catch (RuntimeException ex) {
                throw new EOFException();
            }
        } while (true);

        return res.doubleValue();
    }

    public static String getString(Scanner scanner, String requestText) throws EOFException {
        if (scanner == null) throw new EOFException();

        String s = null;

        do {
            System.out.println(requestText);
            try {
                if (!scanner.hasNextLine()) throw new EOFException();
                s = scanner.nextLine();
                if ("".equals(s)) return null;
                break;
            } catch (RuntimeException ex) {
                throw new EOFException();
            }
        } while (true);

        return new String(s);
    }


}

