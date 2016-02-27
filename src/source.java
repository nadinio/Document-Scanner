

/**
 * Created by Nicholas on 2/13/2016.
 */
public class source {



    public static void main(String[] args)
    {
        DataMatrix dataMatrix = new DataMatrix(args);

        try
        {
            dataMatrix.exportToExcel();
        }catch(Exception ex)
        {
            System.out.println("Could not export the data matrix. Make sure workbook.xls is closed.");
        }



        System.out.println();
    }
}
