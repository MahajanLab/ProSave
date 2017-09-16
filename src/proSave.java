import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class proSave {//8-8 dm10AM
    public static void main(String[] args) {

        //System.out.print("How many columns of data do you have? ");
        //Scanner numOfColsFromUser = new Scanner(System.in);
        //String numOfCols = numOfColsFromUser.nextLine();
        //numOfColsFromUser.close();

        System.out.print("\n\nWhich column of data do you need to compare to(first column is columnn 0)? ");
        Scanner colNumFromUser = new Scanner(System.in);
        int colNumber = Integer.parseInt(colNumFromUser.nextLine());

        System.out.println("Protein Analytics\n------------------");
        ArrayList<Protein> theProteins = new ArrayList<Protein>();

//        Protein testProtein = new Protein("EA909",444);
//        Protein test2Protein = new Protein("DM900", 102);
//        theProteins.add(testProtein);
//        theProteins.add(test2Protein);

        Iterator<Protein> itr = theProteins.iterator();
        while (itr.hasNext()) {
            itr.next().printProtein();
        }

        readProSpec scanner1 = new readProSpec();
        scanner1.openFile();
        ArrayList<Map<String, Protein>> listOfMapsOfProteins = scanner1.readFile();
        scanner1.closeFile();

        readPro scanner2 = new readPro();
        scanner2.openFile();
        scanner2.readFile(listOfMapsOfProteins.get(colNumber));
        scanner2.closeFile();
        //System.out.println(colNumber);

    }
}