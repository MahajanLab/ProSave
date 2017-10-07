import java.io.*;
import java.util.*;


/**
 * The ReadProteinData class processes the original data set and saves the proteins' data for future comparison by the
 * ReadProtein class.
 */
public class ReadProteinData {
    /**
     * Scanner object tableReader iterates through input data text file. Returns data line-by-line.
     */
    private Scanner tableReader;

    /**
     * Scanner object rowReader iterates through lines of data return by Scanner object tableReader.
     */
    private Scanner rowReader;


    /**
     * Method openFile prepares text file OriginalData.txt to be scanned for data.
     */
    private ArrayList<String> listOfColumnNames = new ArrayList<>();
    public void openFile(/*String fileName*/) {
        try {
            String dataToRead = "src\\OriginalData.txt";
            tableReader = new Scanner(new File(dataToRead));

        } catch (Exception e) {
            System.out.println("could not find file");
        }
    }


    /**
     * Method readFile reads OriginalData.txt and saves the original data input for future comparison.
     * @return Map object containing Maps of each column of data in OriginalData.txt. File GetOriginalData.txt
     * must be located in the src folder under project ProSave.
     */
    public Map<String, Map<String, Double>> readFile() {
        Map<String, Map<String, Double>> allOriginalData = new HashMap<>();

        boolean firstRow = true;
        while (tableReader.hasNextLine()) {
            String dataRow = tableReader.nextLine();
            rowReader = new Scanner(dataRow);
            int currentColumn = 0;
            String proteinName = rowReader.next();
            while (rowReader.hasNext()) {
                if (firstRow) {
                    String columnName = rowReader.next();
                    listOfColumnNames.add(currentColumn, columnName);
                } else {
                    double proteinSpectralCount = Double.parseDouble(rowReader.next());
                    String columnNameKey = listOfColumnNames.get(currentColumn);
                    if (allOriginalData.containsKey(columnNameKey)) {
                        allOriginalData.get(columnNameKey).put(proteinName, proteinSpectralCount);
                    } else {
                        Map<String, Double> columnOfProteinsOriginalInit = new HashMap<>();
                        columnOfProteinsOriginalInit.put(proteinName, proteinSpectralCount);
                        allOriginalData.put(columnNameKey, columnOfProteinsOriginalInit);
                    }
                }
                currentColumn++;
            }
            if (firstRow)
                firstRow = false;
        }
        for(int i = 0; i < listOfColumnNames.size(); i++)
            System.out.println(listOfColumnNames.get(i));

        return allOriginalData;
    }


    /**
     * Method closeFile closes the file OriginalData.txt.
     */
    public void closeFile() {
        rowReader.close();
        tableReader.close();
    }

}
