package handlers;

import java.io.File;
import java.util.Objects;

public class FileHandler {


    public static File downloadedFilesFolder = new File("src/test/downloadedTestFiles");
    public static File downloadedFile = new File("src/test/downloadedTestFiles/test-file-to-download.xlsx");
    public static File fileToUpload = new File("src/test/testFilesToUpload/test1");


    public static int getCurrentFolderSize(File file) {
        return Objects.requireNonNull(file.list()).length;
    }
    public static boolean verifyIfFileIsDownloadedByFolderSize(int folderSizeBeforeDownload) {
        int folderSizeAfterDownload = getCurrentFolderSize(downloadedFilesFolder);
        return folderSizeBeforeDownload + 1 == folderSizeAfterDownload;
    }

    public static boolean verifyIfFileIsDownloadedByFileName(String expectedFileName) {
        File[] listOfFiles = downloadedFilesFolder.listFiles();
        boolean found = false;

        for (File file : Objects.requireNonNull(listOfFiles)) {
            if (FormatTextHandler.formatFilename(file).equals(expectedFileName)) {
                found = true;
            }
        }
        return found;
    }
    public static void deleteFile(File file){
        file.delete();
    }

}
