import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.filechooser.FileNameExtensionFilter;


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
    private JTextArea subsetProteinInput;
    private JTextField subsetProteinFileName;
    private JTextField originalDataFileName;
    private JPanel columnComparisonPanel;
    private JButton getOriginalDataButton;
    private JButton continueButton;
    private JFileChooser openOriginalFile;
    private JLabel fileLoadSuccessLabel;
    private JTextArea fileLoadLabel;
    private JTextArea enterProteinLabel;
    ArrayList<JButton> buttonArrayList;

    TheHandler handler;
    ReadProteinData proteinData;

    Color borderColor = new Color (51,51,51);
    Color textBoxColor = new Color(65,65,66);
    Color backgroundJFColor = new Color(102,102,102);
    Color bodyTextColor = new Color(237, 237,237);
    Color titleTextColor = new Color(146, 203, 239);
    public ProSave(){

        Border border = BorderFactory.createLineBorder(borderColor,3);
        Font bFont = new Font("", Font.PLAIN, 28);
        Font instructionFont = new Font("", Font.BOLD, 28);
        ImageIcon img = new ImageIcon("img/Prosave logo@4x.png");
        fileLoadLabel = new JTextArea(1,14);
        enterProteinLabel = new JTextArea(1, 14);


        fileLoadLabel.setText("Load a .txt file containing your original data:");
        fileLoadLabel.setFont(instructionFont);
        fileLoadLabel.setLineWrap(true);
        fileLoadLabel.setWrapStyleWord(true);
        fileLoadLabel.setForeground(titleTextColor);
        fileLoadLabel.setBackground(backgroundJFColor);

        enterProteinLabel.setText("Enter protein IDs:");
        enterProteinLabel.setFont(instructionFont);
        enterProteinLabel.setLineWrap(true);
        enterProteinLabel.setWrapStyleWord(true);
        enterProteinLabel.setForeground(titleTextColor);
        enterProteinLabel.setBackground(backgroundJFColor);
        enterProteinLabel.setMargin(new Insets(0,0,0,0));

        fileLoadSuccessLabel = new JLabel("");
        fileLoadSuccessLabel.setForeground(bodyTextColor);
        fileLoadSuccessLabel.setFont(bFont);
        this.setIconImage(img.getImage());

        JPanel originalDataPanel =  new JPanel();
        JPanel subsetDataPanel =    new JPanel();
        JPanel outputPanel =        new JPanel();
        JPanel firstPanelLeft = new JPanel();
        JPanel firstPanelRight = new JPanel();
        getOriginalDataButton = new JButton();
        continueButton = new JButton();
        firstPanelLeft.setBackground(backgroundJFColor);
        firstPanelRight.setBackground(backgroundJFColor);


        getOriginalDataButton.setBackground(textBoxColor);
        getOriginalDataButton.setForeground(bodyTextColor);
        getOriginalDataButton.setFont(bFont);
        getOriginalDataButton.setPreferredSize(new Dimension(300, 50));
        getOriginalDataButton.setText("Choose File");
        continueButton.setBackground(textBoxColor);
        continueButton.setForeground(bodyTextColor);
        continueButton.setFont(bFont);
        continueButton.setPreferredSize(new Dimension(300, 50));
        continueButton.setText("Continue");
        continueButton.setVisible(false);
        openOriginalFile = new JFileChooser();
        openOriginalFile.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files","txt");
        openOriginalFile.setFileFilter(filter);











        secondPanel = new JPanel();
        firstPanel = new JPanel();

        secondPanel.setVisible(false);


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
        subsetProteinInput =                new JTextArea(10,12);




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

        subsetProteinInput.setBorder(border);
        subsetProteinInput.setBackground(textBoxColor);
        subsetProteinInput.setForeground(bodyTextColor);
        subsetProteinInput.setMargin(new Insets(0,0,30,0));



        Font font = new Font("", Font.PLAIN, 32);
        addOriginal.setFont(font);
        addSubset.setFont(font);
        output.setFont(font);

        columnComparison.setFont(font);
        subsetProteinFileName.setFont(font);
        originalDataFileName.setFont(font);
        outputProteinDataPair.setFont(font);
        subsetProteinInput.setFont(bFont);



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
//        firstPanelLeft.setLayout(new BoxLayossssut(firstPanelLeft, BoxLayout.Y_AXIS));
//        firstPanelRight.setLayout(new BoxLayout(firstPanelRight,BoxLayout.Y_AXIS));


        firstPanelLeft.add(fileLoadLabel);
        firstPanelLeft.add(getOriginalDataButton);
        firstPanelLeft.add(fileLoadSuccessLabel);
        firstPanelRight.add(enterProteinLabel);
        firstPanel.add(firstPanelLeft);
        firstPanel.add(firstPanelRight);

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
        JScrollPane scrollPaneOut = new JScrollPane(outputProteinDataPair);
        outputPanel.add(scrollPaneOut);
        columnComparisonPanel.add(columnComparison);
        JScrollPane scrollPaneIn = new JScrollPane(subsetProteinInput);
        firstPanelRight.add(scrollPaneIn);

        firstPanelRight.add(continueButton);
        controlPanelLeft.add(columnComparisonPanel);
        scrollPaneIn.setBorder(null);
        scrollPaneIn.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneIn.setOpaque(true);
        scrollPaneOut.setBorder(null);
        scrollPaneOut.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneOut.setOpaque(true);

        handler = new TheHandler();

        getOriginalDataButton.addActionListener(handler);
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

    public void doWork(String colName, String proteinsIn){
        outputProteinDataPair.setText("");
        ReadProtein scanner2 = new ReadProtein();
        scanner2.openFile(proteinsIn);
        scanner2.readFile(proteinData.allOriginalData.get(colName), outputProteinDataPair);
        scanner2.closeFile();
    }



    public void printTest(){
        System.out.println("Use GUI interface");
    }

    private class TheHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == getOriginalDataButton){
                int returnVal = openOriginalFile.showOpenDialog(ProSave.this);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    File file = openOriginalFile.getSelectedFile();
                    proteinData = pullWork(file);
                    System.out.println(file.getName());
                    initButtons(proteinData.listOfColumnNames);
                    fileLoadSuccessLabel.setText(file.getName());
                    continueButton.setVisible(true);
                }


            }
            if(e.getSource() == continueButton){
                firstPanel.setVisible(false);
                secondPanel.setVisible(true);
                System.out.println(subsetProteinInput.getText());
            }
            for(int i = 0; i < buttonArrayList.size(); i++){
                if(e.getSource() == buttonArrayList.get(i))
                    doWork(e.getActionCommand(), subsetProteinInput.getText());
            }


        }
    }

}