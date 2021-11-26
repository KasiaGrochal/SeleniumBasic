import java.io.File;

public class FileHandler {

    protected static final String expectedFileName = "test-file-to-download.xlsx";
    protected static File downloadedFilesFolder = new File("src/test/downloadedTestFiles");
    protected static File downloadedFile = new File("src/test/downloadedTestFiles/test-file-to-download.xlsx");
    protected static File fileToUpload = new File("src/test/testFilesToUpload/test1");


    public static int getCurrentFolderSize(File file){
        return file.list().length;
    }
}
