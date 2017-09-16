import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class readPro {

    private Scanner reader;

    public void openFile() {
        try {
            reader = new Scanner(new File("C:\\Users\\danie\\IdeaProjects\\ProSave\\src\\getSpectralCounts.txt"));

        } catch (Exception e) {
            System.out.println("could not find file");
        }
    }

    public void readFile(Map<String, Integer> keyMap) {
        while (reader.hasNext()) {
            String proteinName = reader.next();
            int spectralCount = 0;
            if (keyMap.containsKey(proteinName))
                spectralCount = keyMap.get(proteinName);
            else
                System.out.println("ERROR");
            System.out.println(spectralCount);
        }

    }

    public void closeFile() {
        reader.close();
    }

}
