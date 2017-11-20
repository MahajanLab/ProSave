import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The ReadProteinData class processes the original data set and saves the proteins' data for future comparison by the
 * ReadProtein class.
 * @author Daniel Machlab
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

    public Map<String, Map<String, Double>> allOriginalData = new HashMap<>();

    /**
     * Method openFile prepares text file OriginalData.txt to be scanned for data.
     */
    public ArrayList<String> listOfColumnNames = new ArrayList<>();


    public ReadProteinData(File originalData){
        this.openFile(originalData);
        this.readFile();
        this.closeFile();
    }



    public void openFile(File file) {
        try {
            String dataToRead = "src\\OriginalData.txt";
            tableReader = new Scanner(file);

        } catch (Exception e) {
            System.out.println("could not find file");
        }
    }


    /**
     * Method readFile reads OriginalData.txt and saves the original data input for future comparison.
     * @return Map object containing Maps of each column of data in OriginalData.txt. File GetOriginalData.txt
     * must be located in the src folder under project ProSave.
     */
    public void readFile() {


        boolean firstRow = true;
        while (tableReader.hasNextLine()) {
            String proteinName = " ";
            String dataRow = tableReader.nextLine();
            rowReader = new Scanner(dataRow);
            int currentColumn = 0;
            if(rowReader.hasNext())
                 proteinName = rowReader.next();
            while (rowReader.hasNext()) {
                if (firstRow) {

//                    Matcher m = Pattern.compile("(\".+?\")").matcher(rowReader.nextLine());
//                    while(m.find())
//                        listOfColumnNames.add(currentColumn, m.group(1).replace("\"", ""));

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

    }


    /**
     * Method closeFile closes the file OriginalData.txt.
     */
    public void closeFile() {
        rowReader.close();
        tableReader.close();
    }

}
