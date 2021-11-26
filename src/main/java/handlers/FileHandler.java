package handlers;

import java.io.File;

public class FileHandler {

    public static final String expectedFileName = "test-file-to-download.xlsx";
    public static File downloadedFilesFolder = new File("src/test/downloadedTestFiles");
    public static File downloadedFile = new File("src/test/downloadedTestFiles/test-file-to-download.xlsx");
    public static File fileToUpload = new File("src/test/testFilesToUpload/test1");


    public static int getCurrentFolderSize(File file) {
        return file.list().length;
    }
}
