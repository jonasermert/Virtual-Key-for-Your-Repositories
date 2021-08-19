public class FileNameNotFoundException extends RuntimeException{

    public FileNameNotFoundException() {
        super();
    }

    public FileNameNotFoundException(String message) {
        super(message + " not found");
    }

}