import java.io.*;
import java.util.*;


public class readProSpec {
    private Scanner reader;

    public void openFile(String columnName){
        try{
            String dataToRead = "C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\"+columnName+"_E2_M.txt";
            //String dataToRead = "C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\exceldata.txt";
            reader = new Scanner(new File(dataToRead));//"C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\241_E2_M.txt"

        }
        catch(Exception e){
            System.out.println("could not find file");
        }
    }

    public ArrayList<Map<String, Double>> readFile(int numberOfCols){
        //Map<String, Double> proSpecMap = new HashMap<String, Double>();

        ArrayList<Map<String,Double>> listOfMaps = new ArrayList<>();


        while(reader.hasNextLine()){
            String proteinName = reader.next();

            for(int i = 0; i<numberOfCols; i++){
                double spectralCount = Double.parseDouble(reader.next());
                listOfMaps.get(i).put(proteinName, spectralCount);
            }


            //proSpecMap.put(proteinName,spectralCount);

            //System.out.printf("%s %s \n", proteinName, spectralCount);
        }
        //listOfMaps.add(proSpecMap);
        return listOfMaps;
    }

    public void closeFile(){
        reader.close();
    }

}
