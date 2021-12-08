package handlers;

import java.io.File;
import java.util.List;

public class FormatTextHandler {
    public static String formatFilename(File file) {
        return file.toString().replace("src\\test\\downloadedTestFiles\\", "");
    }

    public static String changeDotToSpace(String string){
        return string.replace("."," ");
    }

}