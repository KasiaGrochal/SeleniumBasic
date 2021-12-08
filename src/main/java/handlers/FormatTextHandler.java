package handlers;

import java.io.File;


public class FormatTextHandler {
    public static String formatFilename(File file) {
        return file.toString().replace("src\\test\\downloadedTestFiles\\", "");
    }

}