
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.IOException;
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
public class ShowAllPressure extends ShowFromCategory {

    public static void main(String[] args) throws InterruptedException {
        //MainPanel newpan = new ShowAllTemperature();
        FrameMainMenu main = new FrameMainMenu();
        main.setVisible(true);
    }

    public ShowAllPressure(int totalSensor, int speedSensor) throws InterruptedException {
        JFrame frame = new JFrame("Category : Pressure");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimen = new Dimension((int) screenSize.getWidth(), 350);

        FrameCategory mainMenu = new FrameCategory();
        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.listPanels = new ArrayList<>();
        this.listSensors = new ArrayList<>();
        this.dataInput = new InputDataFromText();
        this.totalSensor = totalSensor;
        this.speedSensor = speedSensor;

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.setVisible(false);
                frame.removeAll();

                mainMenu.setVisible(true);
            }
        });

        if (totalSensor == 3) {
            frame.setPreferredSize(dimen);
            this.panel1 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.RED, this.speedSensor);
            this.panel1.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel2 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.YELLOW, this.speedSensor);
            this.panel2.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel3 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.BLUE, this.speedSensor);
            this.panel3.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.listPanels.add(panel1);
            this.listPanels.add(panel2);
            this.listPanels.add(panel3);

            finalPanel.setLayout(new GridLayout(1, 3));

            finalPanel.add(panel1);
            finalPanel.add(panel2);
            finalPanel.add(panel3);

            frame.add(finalPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } else if (totalSensor == 6) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.panel1 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.RED, this.speedSensor);
            this.panel1.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel2 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.YELLOW, this.speedSensor);
            this.panel2.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel3 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.BLUE, this.speedSensor);
            this.panel3.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel4 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.GREEN, this.speedSensor);
            this.panel4.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel5 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.ORANGE, this.speedSensor);
            this.panel5.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel6 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.CYAN, this.speedSensor);
            this.panel6.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.listPanels.add(panel1);
            this.listPanels.add(panel2);
            this.listPanels.add(panel3);
            this.listPanels.add(panel4);
            this.listPanels.add(panel5);
            this.listPanels.add(panel6);

            finalPanel.setLayout(new GridLayout(3, 2));

            finalPanel.add(panel1);
            finalPanel.add(panel2);
            finalPanel.add(panel3);
            finalPanel.add(panel4);
            finalPanel.add(panel5);
            finalPanel.add(panel6);

            frame.add(finalPanel);
            frame.pack();
            frame.setVisible(true);

        } else {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.panel1 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.RED, this.speedSensor);
            this.panel1.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel2 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.YELLOW, this.speedSensor);
            this.panel2.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel3 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.BLUE, this.speedSensor);
            this.panel3.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel4 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.GREEN, this.speedSensor);
            this.panel4.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel5 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.ORANGE, this.speedSensor);
            this.panel5.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel6 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.CYAN, this.speedSensor);
            this.panel6.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel7 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.PINK, this.speedSensor);
            this.panel7.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel8 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.DARK_GRAY, this.speedSensor);
            this.panel8.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.panel9 = new Panel(Color.white, "0.0", "0.5", "1.0", dataInput, Color.MAGENTA, this.speedSensor);
            this.panel9.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            this.listPanels.add(panel1);
            this.listPanels.add(panel2);
            this.listPanels.add(panel3);
            this.listPanels.add(panel4);
            this.listPanels.add(panel5);
            this.listPanels.add(panel6);
            this.listPanels.add(panel7);
            this.listPanels.add(panel8);
            this.listPanels.add(panel9);

            finalPanel.setLayout(new GridLayout(3, 3));

            finalPanel.add(panel1);
            finalPanel.add(panel2);
            finalPanel.add(panel3);
            finalPanel.add(panel4);
            finalPanel.add(panel5);
            finalPanel.add(panel6);
            finalPanel.add(panel7);
            finalPanel.add(panel8);
            finalPanel.add(panel9);

            frame.add(finalPanel);
            frame.pack();
            frame.setVisible(true);
        }
    }

    @Override
    public void setListOfSensors() throws IOException {
        dataInput.getAllSensorName();
        for (int i = 0; i < dataInput.listOfSensors.size(); i++) {
            this.listSensors.add(dataInput.listOfSensors.get(i));
        }
    }

    @Override
    public void deployPanelInformation() {
        int index = 0;
        for (Panel pan : listPanels) {
            pan.setBackground(Color.BLACK);
            JTextField sensorName = new JTextField("SENSOR : " + this.listSensors.get(index));
            sensorName.setEditable(false);
            sensorName.setBackground(Color.WHITE);
            sensorName.setFont(new Font("Tahoma", Font.BOLD, 14));
            pan.add(sensorName);
            index += 1;
        }
    }

    @Override
    public void runVisualization() {
        if (this.totalSensor == 3) {
            Thread runThread1 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel1, listSensors.get(0), 3);
                }
            };

            Thread runThread2 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel2, listSensors.get(1), 3);
                }
            };

            Thread runThread3 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel3, listSensors.get(2), 3);
                }
            };
            runThread1.start();
            runThread2.start();
            runThread3.start();
        } else if (this.totalSensor == 6) {
            Thread runThread1 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel1, listSensors.get(0), 6);
                }
            };

            Thread runThread2 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel2, listSensors.get(1), 6);
                }
            };

            Thread runThread3 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel3, listSensors.get(2), 6);
                }
            };

            Thread runThread4 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel4, listSensors.get(3), 6);
                }
            };

            Thread runThread5 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel5, listSensors.get(4), 6);
                }
            };

            Thread runThread6 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel6, listSensors.get(5), 6);
                }
            };
            runThread1.start();
            runThread2.start();
            runThread3.start();
            runThread4.start();
            runThread5.start();
            runThread6.start();
        } else if (this.totalSensor == 9) {
            Thread runThread1 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel1, listSensors.get(0), 9);
                }
            };

            Thread runThread2 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel2, listSensors.get(1), 9);
                }
            };

            Thread runThread3 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel3, listSensors.get(2), 9);
                }
            };

            Thread runThread4 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel4, listSensors.get(3), 9);
                }
            };

            Thread runThread5 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel5, listSensors.get(4), 9);
                }
            };

            Thread runThread6 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel6, listSensors.get(5), 9);
                }
            };

            Thread runThread7 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel7, listSensors.get(6), 9);
                }
            };

            Thread runThread8 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel8, listSensors.get(7), 9);
                }
            };

            Thread runThread9 = new Thread() {
                @Override
                public void run() {
                    dataInput.readDataOnlyPresure(panel9, listSensors.get(8), 9);
                }
            };

            runThread1.start();
            runThread2.start();
            runThread3.start();
            runThread4.start();
            runThread5.start();
            runThread6.start();
            runThread7.start();
            runThread8.start();
            runThread9.start();
        }
    }
}
