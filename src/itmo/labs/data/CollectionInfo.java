package itmo.labs.data;

import java.time.LocalDateTime;

/**
 * Вспомогательный класс используемый для хранения информации о коллекции
 */
public class CollectionInfo {
    public LocalDateTime initializationDateTime;
    public Class collectionElementType;
    public int elementsCount;

    @Override
    public String toString() {
        return "CollectionInfo{" +
                "\n   initializationDateTime : " + initializationDateTime +
                "\n   collectionElementType : " + collectionElementType +
                "\n   elementsCount : " + elementsCount +
                "\n}";
    }
}
