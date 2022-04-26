package itmo.labs.data;

import itmo.labs.tools.Phrases;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Класс управляющий коллекцией учебных групп
 */
public class StudyGroupCollection {
    private Vector<StudyGroup> arr = new Vector<StudyGroup>();
    private CollectionInfo collectionInfo = new CollectionInfo();

    public StudyGroupCollection() {
        collectionInfo.initializationDateTime = LocalDateTime.now();
        collectionInfo.collectionElementType = StudyGroup.class;
    }

    public Vector<StudyGroup> getArr() {
        return arr;
    }

    public void setArr(Vector<StudyGroup> arr) {
        this.arr = arr;
    }

    public void setCollectionInfo(CollectionInfo collectionInfo) {
        this.collectionInfo = collectionInfo;
    }

    public void clear() {
        arr.clear();
    }

    public CollectionInfo getCollectionInfo() {
        collectionInfo.elementsCount = arr.size();
        return collectionInfo;
    }

    public void updateById(int ID, StudyGroup elem) {
        if (elem == null) return;
        elem.setId(ID);
        for (int i = 0; i < arr.size(); ++i) {
            if (arr.get(i).getId() == ID) {
                arr.set(i, elem);
                return;
            }
        }
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= arr.size()) return;
        arr.remove(index);
    }

    public void removeByID(int _ID) {
        try {
            arr.removeIf(studyGroup -> studyGroup.getId() == _ID);
        } catch (UnsupportedOperationException ex) {
            ex.printStackTrace();
        }
    }

    public void randomShuffle() {
        Collections.shuffle(arr);
    }

    public void add(StudyGroup studyGroup) {
        arr.add(studyGroup);
    }

    public StudyGroup get(int index) {
        if (index < 0 || index >= arr.size()) return null;
        return arr.get(index);
    }

    public int size() {
        return arr.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Phrases.CollectionText);
        for (int i = 0; i < arr.size(); ++i) {
            stringBuilder.append("\n    " + (i + 1) + ". ");
            stringBuilder.append(arr.get(i).toString());
        }
        return stringBuilder.toString();
    }
}
