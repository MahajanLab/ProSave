import java.io.*;
import java.util.*;


public class readProSpec {
    private Scanner tableReader;
    private Scanner rowReader;

    public void openFile() {
        try {
            //String dataToRead = "C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\"+columnName+"_E2_M.txt";
            String dataToRead = "C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\exceldata.txt";
            tableReader = new Scanner(new File(dataToRead));//"C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\241_E2_M.txt"

        } catch (Exception e) {
            System.out.println("could not find file");
        }
    }

    public ArrayList<Map<String, Protein>> readFile() {
        //Map<String, Double> proSpecMap = new HashMap<String, Double>();

        ArrayList<Map<String, Protein>> listOfMapsOfProteins = new ArrayList<>();
        ArrayList<String> listOfColumnNames = new ArrayList<>();

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
                }
                else {
                    int proteinSpectralCount = Integer.parseInt(rowReader.next());
                    Protein newProtein = new Protein(proteinName, proteinSpectralCount);
                    //listOfMapsOfProteins.get(currentColumn).put(, newProtein);
                    String columnNameKey = listOfColumnNames.get(currentColumn);
                    Map<String, Protein> columnOfData = listOfMapsOfProteins.get(currentColumn);
                    //Check if column actually exists
                    if(columnOfData.containsKey(columnNameKey))
                        columnOfData.put(columnNameKey, newProtein);
                    else


                }
                currentColumn++;
            }
            if (firstRow)
                firstRow = false;
        }
        return listOfMapsOfProteins;
    }

    public void closeFile() {
        rowReader.close();
        tableReader.close();
    }

}
