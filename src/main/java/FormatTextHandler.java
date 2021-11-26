import java.io.File;

public class FormatTextHandler {
    protected static String formatFilename(File file){
        String formatted=file.toString().replace("src\\test\\downloadedTestFiles\\", "");
        return formatted;
    }
}