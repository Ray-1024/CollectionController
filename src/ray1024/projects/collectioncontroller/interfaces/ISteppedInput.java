package ray1024.projects.collectioncontroller.interfaces;

public interface ISteppedInput {
    void inputLine(String line) throws IllegalArgumentException;

    boolean isObjectReady();

    String getDescription();


}
