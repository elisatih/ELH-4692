
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kresn
 */
public class Panel extends JPanel implements ActionListener {

    protected int WIDTH, HEIGHT;
    protected Color colors;
    protected String batasBawah, batasTengah, batasAtas;
    protected String sensorName = "";
    protected String currentReading = "";
    protected String unit = "";
    protected ArrayList<Points> listInput;
    private int spacing = 0;
    protected InputDataFromText dataInput;
    protected int speedSensor;

    /**
     * Constructor kelas Panel
     *
     * @param c
     * @param batasBawah
     * @param batasTengah
     * @param batasAtas
     * @param data
     * @param chartColor
     * @param speed
     */
    public Panel(Color c, String batasBawah, String batasTengah, String batasAtas, InputDataFromText data, Color chartColor, int speed) {
        this.setBackground(c);
        this.batasBawah = batasBawah;
        this.batasTengah = batasTengah;
        this.batasAtas = batasAtas;
        this.dataInput = data;
        this.colors = chartColor;
        this.speedSensor = speed;
        this.dataInput = new InputDataFromText();

        this.listInput = new ArrayList<>();
        Timer timer = new Timer(20, this);
        timer.start();
    }

    /**
     * Merupakan metode untuk menggambar indikator garis dan batas atas bawah
     * grafik pada line chart yang akan dibuat
     *
     * @param g
     */
    protected void paintLineIndie(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //g2.setStroke(new BasicStroke(0.5));
        g2.setColor(Color.WHITE);
        g.drawLine(30, 50, 650, 50);
        g.drawLine(30, 120, 650, 120);
        g.drawLine(30, 190, 650, 190);
        g.drawLine(30, 50, 30, 190);
        g2.drawString(this.batasAtas, 7, 55);
        g2.drawString(this.batasTengah, 7, 125);
        g2.drawString(this.batasBawah, 7, 195);
    }

    /**
     * Merupakan metode untuk menggambar pada chart, input didapatkan dari hasil
     * pembacaan pada file text
     *
     * @param input
     * @param sensor
     */
    public void drawDirectlyFromBuffer(double input, String sensor) {
        int newinput = 0;
        switch (sensor) {
            case "temperature":
                if (input == 30) {
                    newinput = 120;
                } else if (input < 30 && input > 20) {
                    newinput = (int) (120 + ((30 - input) * 7));
                } else if (input > 30 && input < 40) {
                    newinput = (int) (120 - ((input - 30) * 7));
                }
                break;
            case "humidity":
                if (input == 50) {
                    newinput = 120;
                } else if (input < 50 && input > 0) {
                    newinput = (int) (120 + (((50 - input) * 1.4)));
                } else if (input > 50 && input < 100) {
                    newinput = (int) (120 - (((input - 50) * 1.4)));
                }
                break;
            case "pressure":
                if (input == 0.5) {
                    newinput = 120;
                } else if (input < 0.5 && input > 0) {
                    newinput = (int) (120 + (((0.5 - input) * 140)));
                } else if (input > 0.5 && input <= 1) {
                    newinput = (int) (120 - (((input - 0.5) * 140)));
                }
                break;
            default:
                break;
        }
        Points p = new Points(30 + spacing, newinput);
        p.setSpeed(this.speedSensor);
        listInput.add(p);
        spacing += 5;
    }

    /**
     * Merupakan metode untuk menampilkan nama sensor pada panel
     *
     * @param name
     */
    public void setPanelInformation(String name) {
        this.sensorName = name;
    }

    /**
     * Merupakan metode untuk menampilkan satuan pembacaan pada sensor
     *
     * @param cur
     */
    public void setPanelCurrentReading(String cur) {
        this.currentReading = cur;
    }

    /**
     * Merupakan metode untuk menampilkan ukuran atau satuan untuk sensor
     *
     * @param unit
     */
    public void setPanelUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Merupakan metode untuk menampilkan informasi-informasi pada panel
     *
     * @param g
     */
    public void drawPanelInformation(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("Sensor Name : " + this.sensorName, 20, 250);
        if (this.listInput.isEmpty()) {
            g2.drawString("Current reading : null", 20, 270);
        } else {
            g2.drawString("Current reading : " + this.currentReading + " " + this.unit, 20, 270);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintLineIndie(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < this.listInput.size(); i++) {
            Points p = this.listInput.get(i);
            p.checkDataBelowOrBeyond();
            if (this.listInput.size() > 75) {
                if (p.getVisible()) {
                    p.displayData();
                } else {
                    listInput.remove(p);
                }
            }
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        drawPanelInformation(g);
        g2d.setColor(colors);
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0; i < listInput.size() - 1; i++) {
            g.drawLine(listInput.get(i).getX(),
                    listInput.get(i).getY(),
                    listInput.get(i + 1).getX(),
                    listInput.get(i + 1).getY());
        }
    }
}
