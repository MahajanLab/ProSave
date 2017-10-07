/**
 * The Protein class stores all information needed to represent a protein with original data.
 * @author Daniel Machlab
 */
public class Protein {

    /**
     * String object proteinName stores the name of the Protein object.
     */
    private final String proteinName;

    /**
     * Integer object data stores the original Protein object data.
     */
    private final int data;


    /**
     * Protien class constructor.
     * @param proName Name of the protein.
     * @param originalData Original data corresponding to specific Protein object.
     */
    public Protein(String proName, int originalData){
        this.proteinName = proName;
        this.data = originalData;
    }

    /**
     * Returns name of a Protein object.
     * @return String object proteinName which stores the name of the Protein object.
     */
    public String getProteinName() {
        return proteinName;
    }


    /**
     * Returns the original data of a Protein object.
     * @return Integer object data which stores the original Protein object data.
     */
    public int getData() {
        return data;
    }


    /**
     * Print the Protein object's name and original data.
     */
    public void printProtein(){
        System.out.println("Name: " + this.proteinName + ", Spectral Count: " + this.data);

    }


}
