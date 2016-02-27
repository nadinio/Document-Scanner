import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

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


    private void scanDocuments() {
        String scannedText;

        for (int i = 0; i < args.length; i++)
            try {
                scannedText = new String(Files.readAllBytes(Paths.get(args[i])), StandardCharsets.UTF_8);
                String[] stringArray = scannedText.replaceAll("[-$\",\\];\\[@).?#:!'%(]", " ").toLowerCase().split("\\s+");
                for(int j = 0; j < stringArray.length; j++)
                {
                    if(!isNumeric(stringArray[j]) && stringArray[j].length() > 1) {
                        addWord(stringArray[j]);
                        incrementWord(stringArray[j], i);
                    }
                }
            } catch (Exception ex) {
                System.out.println("File not found.");
            }


    }

    private void addWord(String word)
    {
        if(!dataMatrix.containsKey(word)) {
            Integer[] array = new Integer[documentCount];

            for (int i = 0; i < documentCount; i++)
                array[i] = 0;

            dataMatrix.put(word, array);
        }
    }

    private void incrementWord(String word, int documentNumber)
    {
        Integer[] array = dataMatrix.get(word);
        array[documentNumber] = array[documentNumber] + 1;
    }

    public void exportToExcel() throws IOException
    {
        Workbook wb = new HSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("workbook.xls");
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Sheet1");
        int rowCount = 0;

        for(Map.Entry<String, Integer[]> entry : dataMatrix.entrySet()) {

            Row row = sheet.createRow(rowCount);
            String key = entry.getKey();
            Integer[] array = entry.getValue();

            row.createCell(0).setCellValue(createHelper.createRichTextString(key));

            for (int i = 0; i < array.length; i++)
            {
                row.createCell(i+1).setCellValue(array[i]);
            }
            rowCount++;
        }



        wb.write(fileOut);
        fileOut.close();
    }

    public boolean isNumeric(String toTest)
    {
        try{
            Integer.parseInt(toTest);
            return true;

        }catch (NumberFormatException ex)
        {
            return false;
        }
    }
}