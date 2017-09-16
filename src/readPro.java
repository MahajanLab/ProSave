import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class readPro {

    private Scanner reader;

    public void openFile(){
        try{
            reader = new Scanner(new File("C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\getSpectralCounts.txt"));

        }
        catch(Exception e){
            System.out.println("could not find file");
        }
    }

    public void readFile(Map<String,Integer> keyMap){
        //map that will have spectral counts added to it
        //Map<String, Double> updatedMap = new HashMap<String, Double>();
        while(reader.hasNext()){
            String proteinName = reader.next();
            int spectralCount = keyMap.get(proteinName);
            //updatedMap.put(proteinName, spectralCount);

//            System.out.println(proteinName +"\t" +spectralCount);
            System.out.println(spectralCount);
        }

    }

//    String words = "word word2 word3 word4";
//    StringTokenizer st = new Tokenizer(words);
//st.countTokens();

    public void closeFile(){
        reader.close();
    }

}
