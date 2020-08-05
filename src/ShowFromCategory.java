
import java.util.ArrayList;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kresn
 */
public abstract class ShowFromCategory {

    protected Panel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
    protected JPanel finalPanel = new JPanel();
    protected ArrayList<Panel> listPanels;
    protected ArrayList<String> listSensors;
    protected InputDataFromText dataInput;
    protected int totalSensor = 0;
    protected int speedSensor = 2;
    
    public ShowFromCategory(){
        
    } 
    public abstract void deployPanelInformation();
    
    public abstract void setListOfSensors() throws Exception;
    
    public abstract void runVisualization();
}
