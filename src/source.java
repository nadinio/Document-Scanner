import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Nicholas on 2/13/2016.
 */
public class source {
    public static void main(String[] args)
    {
        scanDocuments(args);
    }

    public static void scanDocuments(String[] args)
    {
        String scannedText = "";

        for(int i = 0; i < args.length; i++)
            try
            {
                scannedText = scannedText + new String(Files.readAllBytes(Paths.get(args[i])), StandardCharsets.UTF_8);
            }catch (Exception ex)
            {
                System.out.println("File not found.");
            }

        // System.out.print(scannedText);
    }
}
