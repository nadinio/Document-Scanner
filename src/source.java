

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

        dataMatrix.calcEuclidDistance();
        try
        {
            dataMatrix.exportToExcel();
            dataMatrix.exportDistanceArray("euclidean-distance.xls");
        }catch(Exception ex)
        {
            System.out.println("Could not export the distance matrix. Make sure euclidean-distance.xls is closed.");
        }


        dataMatrix.calcCosineDistance();
        try
        {
            dataMatrix.exportDistanceArray("cosine-distance.xls");
        }catch(Exception ex)
        {
            System.out.println("Could not export the distance matrix. Make sure cosine-distance.xls is closed.");
        }

        dataMatrix.calcJaccardDistance();
        try
        {
            dataMatrix.exportDistanceArray("jaccard-distance.xls");
        }catch(Exception ex)
        {
            System.out.println("Could not export the distance matrix. Make sure jaccard-distance.xls is closed.");
        }




        System.out.println();
    }
}
