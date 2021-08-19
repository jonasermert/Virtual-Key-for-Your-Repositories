public class FileDetail implements Comparable<FileDetail> {
    private String fileName;
    private String parent;
    private long fileLength;
    private String path;

    public FileDetail(String fileName, String parent, long fileLength, String path) {
        this.fileName = fileName;
        this.parent = parent;
        this.fileLength = fileLength;
        this.path = path;
    }

    public FileDetail() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public long getFileLength() {
        return fileLength;
    }

    public void setFileLength(long fileLength) {
        this.fileLength = fileLength;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return String.format("%-50s | %-10d | %-50s | %s", fileName, fileLength, parent, path);
    }

    @Override
    public int compareTo(FileDetail f1) {
        return this.fileName.compareTo(f1.fileName);
    }
}
