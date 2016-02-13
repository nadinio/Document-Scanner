import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Nicholas on 2/13/2016.
 */
public class source {
    public static void main(String[] args)
    {
        String scannedText = "";

        try
        {
            scannedText = new String(Files.readAllBytes(Paths.get("article1.txt")), StandardCharsets.UTF_8);
        }catch (Exception ex)
        {
            System.out.println("File not found.");
        }

        System.out.print(scannedText);
    }
}
