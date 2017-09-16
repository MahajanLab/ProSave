import java.io.*;
import java.util.*;


public class readProSpec {
    private Scanner tableReader;
    private Scanner rowReader;
    private ArrayList<String> listOfColumnNames = new ArrayList<>();
    public void openFile() {
        try {
            //String dataToRead = "C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\"+columnName+"_E2_M.txt";
            String dataToRead = "C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\exceldata.txt";
            tableReader = new Scanner(new File(dataToRead));//"C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\241_E2_M.txt"

        } catch (Exception e) {
            System.out.println("could not find file");
        }
    }

    public void printEverything(Map<String, Map<String, Integer>> fullDataToPrint){
        Map<String, Integer> columnOfProteins = new HashMap<>();
        for(int i = 0; i< fullDataToPrint.size(); i++)

            columnOfProteins = fullDataToPrint.get(listOfColumnNames.get(i));//.values().toArray();
            System.out.println("----------------NEW COLUMN___________________");
            Object[] x = columnOfProteins.values().toArray();
            for(int j =0; j < columnOfProteins.size(); j++){
                System.out.println(x[j]);
            }

    }

    public Map<String, Map<String, Integer>> readFile() {
        Map<String, Map<String, Integer>> allOriginalData = new HashMap<>();

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
                    String columnNameKey = listOfColumnNames.get(currentColumn);
                    Map<String, Integer> columnOfProteinsOriginal = new HashMap<>();
                    if (allOriginalData.containsKey(columnNameKey)) {
//                        columnOfProteinsOriginal = allOriginalData.get(columnNameKey);
//                        columnOfProteinsOriginal.put(proteinName, proteinSpectralCount);
//                        allOriginalData.replace(columnNameKey, columnOfProteinsOriginal);
                        allOriginalData.get(columnNameKey).put(proteinName, proteinSpectralCount);
                    } else {
                        Map<String, Integer> columnOfProteinsOriginalInit = new HashMap<>();
                        columnOfProteinsOriginalInit.put(proteinName, proteinSpectralCount);
                        allOriginalData.put(columnNameKey, columnOfProteinsOriginalInit);
                    }
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
