package finalTask.util;

public abstract class FileRecorder <T> {
    public abstract void saveToFile(T value);
    public abstract void saveLog(String action, T val);
}
