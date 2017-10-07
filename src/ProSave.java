import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Daniel Machlab
 * The ProSave class is the ProSave program driver class. ProSave returns protein data lost from original data set. Inputs an bare subset of proteins derived from the origina
 * data and returns the subset of proteins with all data points. Intended use as a tool to determine the spectral count
 * of each individual protein unique to a tissue region.
 */
public class ProSave {

    /**
     * ProSave class main method.
     * @param args None.
     */
    public static void main(String[] args) {
        System.out.print("\n\nEnter the name of the column for comparison:   ");
        Scanner colNumFromUser = new Scanner(System.in);
        String colName = colNumFromUser.nextLine();

        System.out.println("Protein Analytics\n------------------");
        ArrayList<Protein> theProteins = new ArrayList<Protein>();

        Iterator<Protein> itr = theProteins.iterator();
        while (itr.hasNext()) {
            itr.next().printProtein();
        }

        ReadProteinData scanner1 = new ReadProteinData();
        scanner1.openFile();
        Map<String, Map<String, Double>> allOriginalData = scanner1.readFile();
        scanner1.closeFile();

        ReadProtein scanner2 = new ReadProtein();
        scanner2.openFile();
        scanner2.readFile(allOriginalData.get(colName));
        scanner2.closeFile();

    }
}