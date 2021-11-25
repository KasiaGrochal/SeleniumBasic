import java.io.File;

public class FormatTextHelper {
    protected static String formatFilename(File file){
        String formatted=file.toString().replace("src\\test\\downloadedTestFiles\\", "");
        return formatted;
    }
}
