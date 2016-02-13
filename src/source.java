import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Created by Nicholas on 2/13/2016.
 */
public class source {



    public static void main(String[] args)
    {
        HashMap<String, Integer[]> dataMatrix = new HashMap<>();
        scanDocuments(args);

        dataMatrix.put("TestWord", new Integer[args.length]);
        //incrementDataMatrix("TestWord", 2, dataMatrix);


        System.out.println();
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

    public static HashMap incrementDataMatrix(String word,Integer docNumber, HashMap<String, Integer[]> dataMatrix)
    {
        Integer[] array = dataMatrix.get(word);

        array[docNumber -1] = array[docNumber-1] + 1;

        System.out.println();

        return dataMatrix;
    }
}
