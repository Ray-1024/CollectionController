package itmo.labs.tools;

/**
 * Класс-Инструмент
 * Содержит все фразы выводимые на обозрение пользователя
 * В будущем с помощью функции setLocale можно будет менять язык используемый в приложении
 */
public class Phrases {
    public static String WrongInput = "Неверный ввод, попробуйте снова:";

    public static String LocationXRequest = "Введите X-координату:";
    public static String LocationYRequest = "Введите Y-координату:";
    public static String LocationZRequest = "Введите Z-координату:";

    public static String PersonNameRequest = "Введите имя персоны:";
    public static String PersonWeightRequest = "Введите ширину персоны(Ширина должна быть более 0):";
    public static String PersonLocationRequest = "Введите позицию персоны:";


    public static String CoordinatesXRequest = "Введите X-координату(не более 948):";
    public static String CoordinatesYRequest = "Введите Y-координату(более -544):";

    public static String StudyGroupNameRequest = "Введите название группы:";
    public static String StudyGroupCoordinatesRequest = "Введите координаты расположения группы:";
    public static String StudyGroupStudentsCountRequest = "Введите колличество студентов в группе:";
    public static String StudyGroupFormOfEducationRequest = "Выберите форму образования(DISTANCE_EDUCATION/FULL_TIME_EDUCATION/EVENING_CLASSES):";
    public static String StudyGroupSemesterRequest = "Выберите семестр(FIRST/FOURTH/FIFTH/SIXTH/EIGHTH):";
    public static String StudyGroupPersonRequest = "Введите данные администратора группы:";

    public static String CantBuildCommand = "Не получилось распознать команду";
    public static String EndOfTerminalWork = "Терминал закончил работу.";

    public static String CollectionText = "Collection:";

    public static String ErrorLoadCollection = "При заполнении коллекции из файла произошла ошибка";
    public static String ErrorSaveCollection = "При сохранении коллекции в файл произошла ошибка";
    public static String CantLoadAndSave = "Не установлено значение переменной окружения 'CCFilename' загрузка коллекции из файла и сохранение будут недоступны";

    public static String TooLongScript = "Скрипт слишком большой для прочтения";
    public static String CantCreateMicroShell = "При создании исполнителя Microshell произошла ошибка";

    void setLocale(String locale) {
        return;
    }
}
