import java.awt.AlphaComposite;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Jonas Ermert
 * @since: 1.0
 * @version: 1.0
 * @return: Implementation für FileManager Interface
 */

public class FileManagerBOImpl implements FileManagerBO {
    private File root;

    public FileManagerBOImpl(String root) {
        this.root = new File(root);
        try {
            this.root.mkdirs();
        } catch (SecurityException e) {
            System.out.println("Please provide access to C:\\");
            System.exit(0);
        }
    }

    @Override
    public FileDetail createFile(String name) throws IOException, SecurityException, AlphaNumericOnly {
        if(name.contains(".")) {
            if(!name.substring(0,name.lastIndexOf(".")).toLowerCase().matches("^[A-Za-z0-9\\s]+$")) {
                throw new AlphaNumericOnly("Only alphanumeric allowed");
            }
        }else {
            if(!name.toLowerCase().matches("^[A-Za-z0-9\\s]+$")) {
                throw new AlphaNumericOnly("Only alphanumeric allowed");
            }
        }
        String path = root.getAbsolutePath();
        File newFile = new File(path + "\\" + name);
        newFile.createNewFile();
        return new FileDetail(newFIle.getName(), newFIle.getParent(), newFIle.length(), newFIle.getPath());

    }

    @Override
    public boolean deleteFile(String name) throws FileNameNotFoundException {
        String path = root.getAbsolutePath();
        File fileToDelete = new File(path + "\\" + name);
        if(!fileToDelete.exists()) {
            throw new FileNameNotFoundException(name);
        }
        if (fileToDelete.exists()) {
            return fileToDelete.delete();
        } else {
            throw new FileNameNotFoundException(name);
        }

    }

    @Override
    public List<FileDetail> getAllFiles() {
        File Files[] = this.root.listFiles();
        List<FileDetail> ListFiieDetail = new LinkedList<>();
        for (File file : Files) {
            ListFiieDetail.add(new FileDetail(file.getName(), file.getParent(), file.length(), file.getPath()));
        }

        return ListFiieDetail;
    }

    @Override
    public boolean searchFile(String name) {
        String path = root.getAbsolutePath();
        File fileToSearch = new File(path + "\\" + name);
        return fileToSearch.exists();
    }

}
