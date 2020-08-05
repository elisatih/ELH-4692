
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kresn
 */
public class ShowFromSensor {

    protected Panel panel1, panel2, panel3;
    protected JPanel finalPanel = new JPanel();
    protected ArrayList<Panel> listPanels;
    protected InputDataFromText dataInput;
    protected JFrame frame;
    protected String sensorNa = "";
    protected int speedSensor = 2;

    public static void main(String[] args) throws InterruptedException {
        //MainPanel newpan = new ShowAllCategory();
        FrameMainMenu main = new FrameMainMenu();
        main.setVisible(true);
    }

    public void setTitleOnFrame(String title) {
        this.frame.setTitle(title);
    }

    public void setTitle(String title) {
        this.sensorNa = title;
    }

    public ShowFromSensor() throws InterruptedException {
        this.frame = new JFrame("");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimen = new Dimension((int) screenSize.getWidth(), 350);
        frame.setPreferredSize(dimen);
        FrameSetFromSensorName mainMenu = new FrameSetFromSensorName();
        this.listPanels = new ArrayList<>();
        this.dataInput = new InputDataFromText();

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.setVisible(false);
                frame.removeAll();

                mainMenu.setVisible(true);
            }
        });

        /**
         * ASSIGN NEW PANEL - MAX 3 PANEL
         */
        this.panel1 = new Panel(Color.white, "20", "30", "40", dataInput, Color.RED, this.speedSensor);
        this.panel1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        
        this.panel2 = new Panel(Color.white, "0", "50", "100", dataInput, Color.YELLOW, this.speedSensor);
        this.panel2.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        this.panel3 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.BLUE, this.speedSensor);
        this.panel3.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        this.listPanels.add(panel1);
        this.listPanels.add(panel2);
        this.listPanels.add(panel3);
        
        for (Panel pan : listPanels) {
            pan.setBackground(Color.BLACK);
        }
        
        finalPanel.setLayout(new GridLayout(1, 3));

        finalPanel.add(panel1);
        finalPanel.add(panel2);
        finalPanel.add(panel3);

        frame.add(finalPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
    }

    public void runVisualization() {
        Thread dummyThread = new Thread() {
            @Override
            public void run() {
                for(Panel pan : listPanels){
                    pan.setPanelInformation(sensorNa);
                }
                dataInput.readDataFromSensorName(panel1, panel2, panel3, sensorNa);
            }
        };
        dummyThread.start();
    }
}
