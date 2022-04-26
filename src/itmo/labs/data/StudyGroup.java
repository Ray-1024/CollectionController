package itmo.labs.data;

import itmo.labs.tools.IInput;
import itmo.labs.tools.IParse;
import itmo.labs.tools.Inputter;
import itmo.labs.tools.Phrases;

import java.io.EOFException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс представляющий учебную группу
 * Элементы коллекции являются представителями данного класса
 * Сортировка по-умолчанию : по лексикографическому неубыванию названий групп
 */
public class StudyGroup implements IInput, Comparable<StudyGroup>, IParse {
    private static int NextID = 1;

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int studentsCount; //Значение поля должно быть больше 0
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле может быть null

    @Override
    public boolean parse(ArrayList<String> lines, int offset) {
        try {
            int cntCoordinates = coordinates.countLinesForParse();
            name = lines.get(offset);
            if (name == null || "".equals(name)) return false;
            boolean coordinatesResult = coordinates.parse(lines, offset + 1);
            studentsCount = Integer.parseInt(lines.get(offset + 1 + cntCoordinates));
            formOfEducation = FormOfEducation.valueOf(lines.get(offset + 2 + cntCoordinates));
            semesterEnum = Semester.valueOf(lines.get(offset + 3 + cntCoordinates));
            return coordinatesResult && groupAdmin.parse(lines, offset + 4 + cntCoordinates);
        } catch (RuntimeException ex) {
            return false;
        }
    }

    @Override
    public int countLinesForParse() {
        return 0;
    }

    public StudyGroup() {
        id = (NextID++);
        creationDate = LocalDateTime.now();
        name = "";
        coordinates = new Coordinates();
        studentsCount = 0;
        groupAdmin = new Person();
    }

    @Override
    public void input(Scanner scanner) throws EOFException {
        if (scanner == null) throw new EOFException();
        Integer ii = null;
        try {
            while (true) {
                name = Inputter.getString(scanner, Phrases.StudyGroupNameRequest);
                if (name == null || "".equals(name)) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                break;
            }
            System.out.println(Phrases.StudyGroupCoordinatesRequest);
            coordinates.input(scanner);
            while (true) {
                ii = Inputter.getInt(scanner, Phrases.StudyGroupStudentsCountRequest);
                if (ii == null || ii < 1) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                studentsCount = ii;
                break;
            }
            while (true) {
                formOfEducation = Inputter.getFormOfEducation(scanner, Phrases.StudyGroupFormOfEducationRequest);
                if (formOfEducation == null) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                break;
            }
            while (true) {
                semesterEnum = Inputter.getSemester(scanner, Phrases.StudyGroupSemesterRequest);
                if (semesterEnum == null) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                break;
            }
            System.out.println(Phrases.StudyGroupPersonRequest);
            groupAdmin.input(scanner);
        } catch (EOFException ex) {
            throw new EOFException();
        }

    }

    @Override
    public int compareTo(StudyGroup o) {
        if (this.equals(o)) return 0;
        return this.name.compareTo(o.name);
    }

    public static int getNextID() {
        return NextID;
    }

    public static void setNextID(int nextID) {
        NextID = nextID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public String getName() {
        return name;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", studentsCount=" + studentsCount +
                ", formOfEducation=" + formOfEducation +
                ", semesterEnum=" + semesterEnum +
                ", groupAdmin=" + groupAdmin +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) return false;
        StudyGroup gr = (StudyGroup) obj;
        return name.equals(gr.name) && coordinates.equals(gr.coordinates) && studentsCount == gr.studentsCount && formOfEducation.equals(gr.formOfEducation) && semesterEnum.equals(gr.semesterEnum) && groupAdmin.equals(gr.groupAdmin);
    }
}