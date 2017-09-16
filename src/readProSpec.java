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

    public Map<String, Map<String, Integer>> readFile() {
//        Map<String, Double> proSpecMap = new HashMap<String, Double>();

//        ArrayList<Map<String, Protein>> listOfMapsOfProteins = new ArrayList<>();
//        Map<String,ArrayList<Protein>> mapOfProteinLists = new HashMap<>();
        Map<String, Map<String, Integer>> allOriginalData = new HashMap<>();
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
                } else {
                    int proteinSpectralCount = Integer.parseInt(rowReader.next());
//                    Protein newProtein = new Protein(proteinName, proteinSpectralCount);
//                    listOfMapsOfProteins.get(currentColumn).put(, newProtein);
                    String columnNameKey = listOfColumnNames.get(currentColumn);
                    Map<String, Integer> columnOfProteinsOriginal = new HashMap<>();
                    if (allOriginalData.containsKey(columnNameKey)) {
                        columnOfProteinsOriginal = allOriginalData.get(columnNameKey);
                        columnOfProteinsOriginal.put(proteinName, proteinSpectralCount);
//                        mapOfProteinLists.get(columnNameKey).add(newProtein);
                    } else {
                        Map<String, Integer> columnOfProteinsOriginalInit = new HashMap<>();
                        columnOfProteinsOriginalInit.put(proteinName, proteinSpectralCount);
//                        mapOfProteinLists.put(columnNameKey,columnOfProteinsInit)
                    }
//                    Map<String, Protein> columnOfData = mapOfProteinLists.get(currentColumn);
//                    Check if column actually exists
//                    if(columnOfData.containsKey(columnNameKey))
//                        columnOfData.put(columnNameKey, newProtein);
//                    else
                }
                currentColumn++;
            }
            if (firstRow)
                firstRow = false;
        }
        return allOriginalData;
    }

    public void closeFile() {
        rowReader.close();
        tableReader.close();
    }

}
