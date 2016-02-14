import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Created by Nicholas on 2/14/2016.
 */
class DataMatrix {
    private int documentCount = 0;
    static String[] args;
    HashMap<String, Integer[]> dataMatrix = new HashMap<>();

    DataMatrix(String[] args) {
        documentCount = args.length;
        this.args = args;
        scanDocuments();
    }


    public void scanDocuments() {
        String scannedText = "";


        for (int i = 0; i < args.length; i++)
            try {
                scannedText = scannedText + new String(Files.readAllBytes(Paths.get(args[i])), StandardCharsets.UTF_8);
            } catch (Exception ex) {
                System.out.println("File not found.");
            }

        // System.out.print(scannedText);

    }

    public void addWord(String word)
    {
        Integer[] array = new Integer[documentCount];

        for(int i = 0; i < documentCount; i++)
            array[i] = 0;

        dataMatrix.put(word, array);
    }
}