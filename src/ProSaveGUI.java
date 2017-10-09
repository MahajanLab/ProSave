import javax.swing.JFrame;

public class ProSaveGUI {

    public static void main(String[] args) {

        ProSave x = new ProSave();
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setSize(1000,800);
        x.setVisible(true);
        x.printTest();

    }


}
