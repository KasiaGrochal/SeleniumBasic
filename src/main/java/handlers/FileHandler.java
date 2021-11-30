package handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Objects;

public class FileHandler {
    private static Logger logger = LoggerFactory.getLogger(FileHandler.class);

    public static File downloadedFilesFolder = new File("src/test/downloadedTestFiles");
    public static File downloadedFile = new File("src/test/downloadedTestFiles/test-file-to-download.xlsx");
    public static File fileToUpload = new File("src/test/testFilesToUpload/test1");


    public static int getCurrentFolderSize(File file) {
        return Objects.requireNonNull(file.list()).length;
    }

    public static boolean didFolderSizeIncreaseByOne(int folderSizeBeforeDownload) {
        int folderSizeAfterDownload = getCurrentFolderSize(downloadedFilesFolder);
        logger.info("Folder size before download: {}",folderSizeBeforeDownload);
        logger.info("Folder size after download: {}",folderSizeAfterDownload);
        return folderSizeBeforeDownload + 1 == folderSizeAfterDownload;
    }

    public static boolean doesFileExistInDownloadFolder(String expectedFileName) {
        File[] listOfFiles = downloadedFilesFolder.listFiles();
        boolean found = false;

        for (File file : Objects.requireNonNull(listOfFiles)) {
            if (FormatTextHandler.formatFilename(file).equals(expectedFileName)) {
                logger.info("Searching for file in folder '{}', by expected File name: {}", downloadedFilesFolder, expectedFileName);
                found = true;
            }
        }
        logger.info("Does file exist in {}, result: {}", downloadedFilesFolder, found);
        return found;
    }

    public static void deleteFile(File file) {
        file.delete();
        logger.info("File: {} was deleted successfully", file);
    }

}
