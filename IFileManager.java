public interface IFileManager {

    public FileDetail createFile(String name) throws IOException;
    public boolean deleteFile(String name) throws FileNameNotFoundException;
    public List<FileDetail> getAllFiles();
    public boolean searchFile(String name);

}