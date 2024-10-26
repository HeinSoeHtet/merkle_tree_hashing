package src;

public class TableData {
    private String version;
    private String threadCount;
    private String fileCount;
    private String timeTaken;

    public TableData(String version, String threadCount, String fileCount, String timeTaken) {
        this.version = version;
        this.threadCount = threadCount;
        this.fileCount = fileCount;
        this.timeTaken = timeTaken;
    }

    public String getVersion() {
        return version;
    }

    public String getThreadCount() {
        return threadCount;
    }

    public String getFileCount() {
        return fileCount;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

}
