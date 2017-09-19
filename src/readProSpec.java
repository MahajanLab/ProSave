import java.io.*;
import java.util.*;


public class readProSpec {
    private Scanner tableReader;
    private Scanner rowReader;
    private ArrayList<String> listOfColumnNames = new ArrayList<>();
    public void openFile() {
        try {
            String dataToRead = "C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\Mouse_RV_Data.txt";
            tableReader = new Scanner(new File(dataToRead));

        } catch (Exception e) {
            System.out.println("could not find file");
        }
    }



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

    public void closeFile() {
        rowReader.close();
        tableReader.close();
    }

}
