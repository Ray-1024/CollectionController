package ray1024.projects.collectioncontroller.tools;

import ray1024.projects.collectioncontroller.interfaces.ISteppedInput;

public abstract class SteppedInputObject implements ISteppedInput {
    protected int readyLines = 0;
    protected int maxLines = 0;


    public int getMaxLines() {
        return maxLines;
    }

    @Override
    public boolean isObjectReady() {
        return readyLines == maxLines;
    }
}
