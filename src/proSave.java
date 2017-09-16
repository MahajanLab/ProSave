import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class proSave {//9-16 dm6PM
    public static void main(String[] args) {

        System.out.print("\n\nWhich column of data do you need to compare to(first column is columnn 0)? ");
        Scanner colNumFromUser = new Scanner(System.in);
        String colName = colNumFromUser.nextLine();

        System.out.println("Protein Analytics\n------------------");
        ArrayList<Protein> theProteins = new ArrayList<Protein>();

        Iterator<Protein> itr = theProteins.iterator();
        while (itr.hasNext()) {
            itr.next().printProtein();
        }

        readProSpec scanner1 = new readProSpec();
        scanner1.openFile();
        Map<String, Map<String, Integer>> allOriginalData = scanner1.readFile();
        scanner1.closeFile();

        readPro scanner2 = new readPro();
        scanner2.openFile();
        scanner2.readFile(allOriginalData.get(colName));
        scanner2.closeFile();

    }
}