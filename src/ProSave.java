import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.border.Border;
import javax.swing.BorderFactory;


/**
 * The ProSave class is the ProSave program driver class. ProSave returns protein data lost from original data set. Inputs an bare subset of proteins derived from the origina
 * data and returns the subset of proteins with all data points. Intended use as a tool to determine the spectral count
 * of each individual protein unique to a tissue region.
 * @author Daniel Machlab
 */
public class ProSave extends JFrame{
    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel controlPanelLeft;
    private JTextArea outputProteinDataPair;
    private JTextField subsetProteinFileName;
    private JTextField originalDataFileName;
    private JPanel columnComparisonPanel;
    private JButton getOriginalDateButton;
    private JButton continueButton;
    private JFileChooser openOriginalFile;
    ArrayList<JButton> buttonArrayList;

    TheHandler handler;
    ReadProteinData proteinData;

    Color borderColor = new Color (51,51,51);
    Color textBoxColor = new Color(65,65,66);
    Color backgroundJFColor = new Color(102,102,102);
    Color bodyTextColor = new Color(237, 237,237);
    Color titleTextColor = new Color(146, 203, 239);
    public ProSave(){
        openOriginalFile = new JFileChooser();
        Border border = BorderFactory.createLineBorder(borderColor,3);
        Font bFont = new Font("", Font.PLAIN, 28);
        ImageIcon img = new ImageIcon("img/Prosave logo@4x.png");

        this.setIconImage(img.getImage());

        JPanel originalDataPanel =  new JPanel();
        //originalDataPanel.setBackground(new Color(65,65,66));
        JPanel subsetDataPanel =    new JPanel();
        JPanel outputPanel =        new JPanel();
        JPanel firstPanelLeft = new JPanel();
        JPanel firstPanelRight = new JPanel();
        getOriginalDateButton = new JButton();
        continueButton = new JButton();
        firstPanelLeft.setBackground(backgroundJFColor);
        firstPanelRight.setBackground(backgroundJFColor);

        getOriginalDateButton.setBackground(textBoxColor);
        getOriginalDateButton.setForeground(bodyTextColor);
        getOriginalDateButton.setFont(bFont);
        getOriginalDateButton.setPreferredSize(new Dimension(300, 50));

        continueButton.setBackground(textBoxColor);
        continueButton.setForeground(bodyTextColor);
        continueButton.setFont(bFont);
        continueButton.setPreferredSize(new Dimension(300, 50));


        firstPanelLeft.add(getOriginalDateButton);
        firstPanelRight.add(continueButton);




        getOriginalDateButton.setText("Load .txt File");
        continueButton.setText("Continue");

        secondPanel = new JPanel();
        firstPanel = new JPanel();

        secondPanel.setVisible(false);
        firstPanel.add(firstPanelLeft);
        firstPanel.add(firstPanelRight);

//        JPanel controlPanel =       new JPanel();
        columnComparisonPanel = new JPanel();

        JPanel controlPanelRight =  new JPanel();
        controlPanelLeft =          new JPanel();
        //controlPanelLeft.setBackground(new Color(65,65,66));
        JLabel addOriginal = new JLabel("Enter file name of original data: ");
        JLabel addSubset = new JLabel("Enter file name of protein list: ");
        JLabel output = new JLabel("Restored protein-data pairs: ");
        JLabel columnComparison = new JLabel("Select column to compare: ");

        originalDataFileName =              new JTextField(16);
        outputProteinDataPair =             new JTextArea(10,10);
        subsetProteinFileName =             new JTextField(16);



        //columnComparisonInput.setBorder(border);
        outputProteinDataPair.setBorder(border);
        columnComparisonPanel.setBackground(backgroundJFColor);
        outputPanel.setBackground(backgroundJFColor);
        columnComparison.setForeground(titleTextColor);
        output.setForeground(titleTextColor);
        output.setBackground(textBoxColor);
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


//        originalDataPanel.setLayout(new GridLayout(2,1));
//        subsetDataPanel.setLayout(new GridLayout(2,1));
//        outputPanel.setLayout(new GridLayout(2,1));
        controlPanelRight.setLayout(new BoxLayout(controlPanelRight, BoxLayout.Y_AXIS));
        controlPanelLeft.setLayout(new BoxLayout(controlPanelLeft, BoxLayout.Y_AXIS));
        //controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        secondPanel.setLayout(new GridLayout(1,2));
        firstPanel.setLayout(new GridLayout(1,2));
        //this.add(controlPanel);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        secondPanel.add(controlPanelLeft);
        secondPanel.add(controlPanelRight);
        this.add(secondPanel);
        this.add(firstPanel);


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

        controlPanelLeft.add(columnComparisonPanel);

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(true);

        handler = new TheHandler();

        getOriginalDateButton.addActionListener(handler);
        continueButton.addActionListener(handler);

//        proteinData = pullWork();
//        initButtons(proteinData.listOfColumnNames);

    }

    public void initButtons(ArrayList<String> buttonNameList){
        Font font = new Font("", Font.PLAIN, 28);
        buttonArrayList = new ArrayList<>();
        for(int i = 0; i < buttonNameList.size(); i++) {
            JButton b = new JButton(buttonNameList.get(i));
            columnComparisonPanel.add(b);
            b.addActionListener(handler);
            System.out.println(buttonNameList.get(i));
            b.setBackground(textBoxColor);
            b.setForeground(bodyTextColor);
            b.setFont(font);
            b.setPreferredSize(new Dimension(300, 50));
            buttonArrayList.add(b);



        }
    }

    public ReadProteinData pullWork(File originalData) {
        System.out.print("\n\nEnter the name of the column for comparison:   ");

        System.out.println("Protein Analytics\n------------------");
        ArrayList<Protein> theProteins = new ArrayList<Protein>();

        Iterator<Protein> itr = theProteins.iterator();
        while (itr.hasNext()) {
            itr.next().printProtein();
        }
        ReadProteinData proteinData = new ReadProteinData(originalData);
//        Map<String, Map<String, Double>> allOriginalData = proteinData.allOriginalData;
        return proteinData;
    }

    public void doWork(String colName){
        outputProteinDataPair.setText("");
        ReadProtein scanner2 = new ReadProtein();
        scanner2.openFile();
        scanner2.readFile(proteinData.allOriginalData.get(colName), outputProteinDataPair);
        scanner2.closeFile();
    }



    public void printTest(){
        System.out.println("Use GUI interface");
    }

    private class TheHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == getOriginalDateButton){
                int returnVal = openOriginalFile.showOpenDialog(ProSave.this);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    File file = openOriginalFile.getSelectedFile();
                    proteinData = pullWork(file);
                    initButtons(proteinData.listOfColumnNames);
                }
            }
            if(e.getSource() == continueButton){
                firstPanel.setVisible(false);
                secondPanel.setVisible(true);
            }
            for(int i = 0; i < buttonArrayList.size(); i++){
                if(e.getSource() == buttonArrayList.get(i))
                    doWork(e.getActionCommand());
            }


        }
    }

}