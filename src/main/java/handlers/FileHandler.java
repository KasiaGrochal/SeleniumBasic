package handlers;

import basePage.BasePage;

import java.io.File;

public class FileHandler {

    public static final String expectedFileName = "test-file-to-download.xlsx";
    public static File downloadedFilesFolder = new File("src/test/downloadedTestFiles");
    public static File downloadedFile = new File("src/test/downloadedTestFiles/test-file-to-download.xlsx");
    public static File fileToUpload = new File("src/test/testFilesToUpload/test1");


    public static int getCurrentFolderSize(File file) {
        return file.list().length;
    }
    public static boolean verifyIfFileIsDownloadedByFolderSize(int folderSizeBeforeDownload) {
        int folderSizeAfterDownload = FileHandler.getCurrentFolderSize(FileHandler.downloadedFilesFolder);
        if (folderSizeBeforeDownload + 1 == folderSizeAfterDownload) {
            return true;
        }
        return false;
    }

    public static boolean verifyIfFileIsDownloadedByFileName(String expectedFileName) {
        File[] listOfFiles = FileHandler.downloadedFilesFolder.listFiles();
        boolean found = false;
        for (File file : listOfFiles) {
            if (FormatTextHandler.formatFilename(file).equals(expectedFileName)) {
                found = true;
            }
        }
        if (found) {
            return true;
        }
        return false;
    }
    public static void deleteFile(File file){
        file.delete();
    }


}
