import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * The ProSave class is the ProSave program driver class. ProSave returns protein data lost from original data set. Inputs an bare subset of proteins derived from the origina
 * data and returns the subset of proteins with all data points. Intended use as a tool to determine the spectral count
 * of each individual protein unique to a tissue region.
 * @author Daniel Machlab
 */
public class ProSave extends JFrame{
    private JPanel controlPanelLeft;
    private JTextArea outputProteinDataPair;
    private JTextField subsetProteinFileName;
    private JTextField originalDataFileName;
    private JTextField columnComparisonInput;


    public ProSave(){

        Color textBoxColor = new Color(65,65,66);
        Color backgroundJFColor = new Color(102,102,102);
        Color bodyTextColor = new Color(237, 237,237);
        Color titleTextColor = new Color(146, 203, 239);

        JPanel originalDataPanel =  new JPanel();
        //originalDataPanel.setBackground(new Color(65,65,66));
        JPanel subsetDataPanel =    new JPanel();
        JPanel outputPanel =        new JPanel();

//        JPanel controlPanel =       new JPanel();
        JPanel columnComparisonPanel = new JPanel();

        JPanel controlPanelRight =  new JPanel();
        controlPanelLeft =          new JPanel();
        //controlPanelLeft.setBackground(new Color(65,65,66));
        JLabel addOriginal = new JLabel("Enter file name of original data: ");
        JLabel addSubset = new JLabel("Enter file name of protein list: ");
        JLabel output = new JLabel("Restored protein-data pairs: ");
        JLabel columnComparison = new JLabel("Enter column to compare: ");

        originalDataFileName =              new JTextField(16);
        outputProteinDataPair =             new JTextArea(8,16);
        subsetProteinFileName =             new JTextField(16);
        columnComparisonInput =             new JTextField(16);

        columnComparisonPanel.setBackground(backgroundJFColor);
        outputPanel.setBackground(backgroundJFColor);
        columnComparison.setForeground(titleTextColor);
        output.setForeground(titleTextColor);
        output.setBackground(textBoxColor);
        columnComparisonInput.setBackground(textBoxColor);
        columnComparisonInput.setForeground(bodyTextColor);
        outputProteinDataPair.setBackground(textBoxColor);
        outputProteinDataPair.setForeground(bodyTextColor);

        originalDataPanel.setVisible(false);
        subsetDataPanel.setVisible(false);




        Font font = new Font("", Font.PLAIN, 32);
        addOriginal.setFont(font);
        addSubset.setFont(font);
        output.setFont(font);

        columnComparison.setFont(font);
        subsetProteinFileName.setFont(font);
        originalDataFileName.setFont(font);
        outputProteinDataPair.setFont(font);
        columnComparisonInput.setFont(font);

//        originalDataPanel.setLayout(new GridLayout(2,1));
//        subsetDataPanel.setLayout(new GridLayout(2,1));
//        outputPanel.setLayout(new GridLayout(2,1));
        controlPanelRight.setLayout(new BoxLayout(controlPanelRight, BoxLayout.Y_AXIS));
        controlPanelLeft.setLayout(new BoxLayout(controlPanelLeft, BoxLayout.Y_AXIS));
        //controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        this.setLayout(new GridLayout(1,2));
        //this.add(controlPanel);

        this.add(controlPanelLeft);
        this.add(controlPanelRight);

        originalDataPanel.add(addOriginal);
        subsetDataPanel.add(addSubset);
        outputPanel.add(output);

        subsetDataPanel.add(subsetProteinFileName);
        originalDataPanel.add(originalDataFileName);
        controlPanelLeft.add(originalDataPanel);
        controlPanelLeft.add(subsetDataPanel);
        controlPanelRight.add(outputPanel);
        JScrollPane scrollPane = new JScrollPane(outputProteinDataPair);
        outputPanel.add(scrollPane);
        columnComparisonPanel.add(columnComparison);
        columnComparisonPanel.add(columnComparisonInput);
        controlPanelLeft.add(columnComparisonPanel);

        TheHandler handler = new TheHandler();
        columnComparisonInput.addActionListener(handler);
    }

    public void doWork(String colName) {
        System.out.print("\n\nEnter the name of the column for comparison:   ");

        System.out.println("Protein Analytics\n------------------");
        ArrayList<Protein> theProteins = new ArrayList<Protein>();

        Iterator<Protein> itr = theProteins.iterator();
        while (itr.hasNext()) {
            itr.next().printProtein();
        }
        //Control90Vitreous

        ReadProteinData scanner1 = new ReadProteinData();
        scanner1.openFile();
        Map<String, Map<String, Double>> allOriginalData = scanner1.readFile();
        scanner1.closeFile();

        ReadProtein scanner2 = new ReadProtein();
        scanner2.openFile();
        scanner2.readFile(allOriginalData.get(colName), outputProteinDataPair);
        scanner2.closeFile();
    }

    public void printTest(){
        System.out.println("Use GUI interface");
    }

    private class TheHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == columnComparisonInput){
                /*ProSave y = new ProSave();
                y.*/
                doWork(e.getActionCommand());
            }
        }
    }

}