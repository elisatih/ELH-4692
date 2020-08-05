
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDataFromText {

    protected ArrayList<Double> temperatures;
    protected ArrayList<Double> humidities;
    protected ArrayList<Double> pressures;

    private BufferedReader reader;
    protected ArrayList<String> listOfSensors = new ArrayList<>();
    protected Panel[] arrayOfPanel;

    private final String patternTemperature = " [:]...";
    private final String patternHumidity = "..... [R]";
    private final String patternPressure1 = "...... [mbar]";
    private final String patternPressure2 = "...... [bar]";
    private final File inputFile = new File("C:\\Kekresna\\Universitas Katolik Parahyangan\\SKRIPSI FIX\\SKRIPSI SAYA\\Referensi\\Text Input\\inputSensorPanjang.txt");
    private final File inputFile3 = new File("C:\\Kekresna\\Universitas Katolik Parahyangan\\SKRIPSI FIX\\SKRIPSI SAYA\\Referensi\\Text Input\\inputSensor3Sensor.txt");
    private final File inputFile6 = new File("C:\\Kekresna\\Universitas Katolik Parahyangan\\SKRIPSI FIX\\SKRIPSI SAYA\\Referensi\\Text Input\\inputSensor6Sensor.txt");
    private final File inputFile9 = new File("C:\\Kekresna\\Universitas Katolik Parahyangan\\SKRIPSI FIX\\SKRIPSI SAYA\\Referensi\\Text Input\\inputSensor9Sensor.txt");
    private final File inputFilePendek = new File("C:\\Kekresna\\Universitas Katolik Parahyangan\\SKRIPSI FIX\\SKRIPSI SAYA\\Referensi\\Text Input\\inputSensorPendek.txt");
    private final File inputError = new File("C:\\Kekresna\\Universitas Katolik Parahyangan\\SKRIPSI FIX\\SKRIPSI SAYA\\Referensi\\Text Input\\inputSensorExcelated.txt");

    public InputDataFromText() {
        this.temperatures = new ArrayList<>();
        this.humidities = new ArrayList<>();
        this.pressures = new ArrayList<>();
    }

    /**
     * Method yang menampilkan data-data dalam bentuk visualisasi berdasarkan
     * nama sensor yang dipilih
     *
     * @param panelTemperature
     * @param panelHumidity
     * @param panelPressure
     * @param sensor
     */
    public void readDataFromSensorName(Panel panelTemperature,
            Panel panelHumidity, Panel panelPressure, String sensor) {
        try {
            while (true) {
                Pattern detectSensorName = Pattern.compile("].... :");
                Pattern pTemperature = Pattern.compile(patternTemperature);
                Pattern pHumidity = Pattern.compile(patternHumidity);
                Pattern pPressure1 = Pattern.compile(patternPressure1);
                Pattern pPressure2 = Pattern.compile(patternPressure2);
                panelTemperature.setPanelUnit("Celcius");
                panelHumidity.setPanelUnit("% RH");
                panelPressure.setPanelUnit("Bar");

                File input = inputFile;
                reader = new BufferedReader(new FileReader(input));
                String line = "";
                int index = 1;
                while ((line = reader.readLine()) != null) {
                    Matcher sensorName = detectSensorName.matcher(line);
                    Matcher getTemperature = pTemperature.matcher(line);
                    Matcher getHumidity = pHumidity.matcher(line);
                    Matcher getPressure1 = pPressure1.matcher(line);
                    Matcher getPressure2 = pPressure2.matcher(line);
                    //System.out.println(line);
                    if (sensorName.find()) {
                        String res = sensorName.group().substring(1, 5);
                        if (res.equals(sensor)) {
                            if (getTemperature.find()) {
                                Double temp = Double.parseDouble(getTemperature.group().substring(2, 4));
                                temperatures.add(temp);
                                panelTemperature.setPanelCurrentReading(temp + "");
                                panelTemperature.drawDirectlyFromBuffer(temp, "temperature");
                                //System.out.println("Temperature : " + temp + " " + index);
                                index++;
                            }
                            if (getHumidity.find()) {
                                Double temp = Double.parseDouble(getHumidity.group().substring(0, 4));
                                humidities.add(temp);
                                panelHumidity.setPanelCurrentReading(temp + "");
                                panelHumidity.drawDirectlyFromBuffer(temp, "humidity");
                                //System.out.println("Humidity : " + temp);
                            }
                            if (getPressure2.find()) {
                                Double temp = Double.parseDouble(getPressure2.group().substring(0, 4));
                                //temp = temp / 1000;
                                pressures.add(temp);
                                panelPressure.setPanelCurrentReading(temp + "");
                                panelPressure.drawDirectlyFromBuffer(temp, "pressure");
                                //System.out.println("Pressure : " + temp);
                            } else if (getPressure1.find()) {
                                Double temp = Double.parseDouble(getPressure1.group().substring(0, 4));
                                temp = temp / 1000;
                                pressures.add(temp);
                                panelPressure.setPanelCurrentReading(temp + "");
                                panelPressure.drawDirectlyFromBuffer(temp, "pressure");
                                //System.out.println("Pressure : " + temp);
                            }
                        }
                        Thread.sleep(5);
                    }
                }
                Thread.currentThread().interrupt();
            }
        } catch (IOException ex) {
            System.out.println("Error in reading input file");
        } catch (InterruptedException ex) {
            System.err.println("END OF FILE (EOF)");
        }
    }

    public void readDataOnlyTemperature(Panel panel, String sensor, int totalSensor) {
        try {
            while (true) {
                //INPUT PATTERN UNTUK MEMBACA DARI TEXT FILE
                Pattern detectSensorName = Pattern.compile("].... :");
                Pattern pTemperature = Pattern.compile(patternTemperature);
                panel.setPanelUnit("Celcius");
                File input = inputFile;

                switch (totalSensor) {
                    case 3:
                        input = inputFile3;
                        break;
                    case 6:
                        input = inputFile6;
                        break;
                    case 9:
                        input = inputFile;
                        break;
                    default:
                        break;
                }

                reader = new BufferedReader(new FileReader(input));
                String line = "";

                while ((line = reader.readLine()) != null) {
                    Matcher sensorName = detectSensorName.matcher(line);
                    Matcher getTemperature = pTemperature.matcher(line);

                    if (sensorName.find()) {
                        String res = sensorName.group().substring(1, 5);
                        //System.out.println(res);
                        if (res.equals(sensor)) {
                            if (getTemperature.find()) {
                                Double temp = Double.parseDouble(getTemperature.group().substring(2, 4));
                                panel.setPanelCurrentReading(temp + "");
                                panel.drawDirectlyFromBuffer(temp, "temperature");
                                //System.out.println("Temperature : " + temp);
                            }
                        }
                        Thread.sleep(5);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error in reading input file");
        } catch (InterruptedException ex) {
            System.err.println("END OF FILE (EOF)");
        }
    }

    public void readDataOnlyHumidity(Panel panel, String sensor, int totalSensor) {
        try {
            while (true) {
                //INPUT PATTERN UNTUK MEMBACA DARI TEXT FILE
                Pattern detectSensorName = Pattern.compile("].... :");
                Pattern pHumidity = Pattern.compile(patternHumidity);
                panel.setPanelUnit("% RH");
                File input = inputFile;

                switch (totalSensor) {
                    case 3:
                        input = inputFile3;
                        break;
                    case 6:
                        input = inputFile6;
                        break;
                    case 9:
                        input = inputFile;
                        break;
                    default:
                        break;
                }

                reader = new BufferedReader(new FileReader(input));
                String line = "";

                while ((line = reader.readLine()) != null) {
                    Matcher sensorName = detectSensorName.matcher(line);
                    Matcher getHumidity = pHumidity.matcher(line);

                    if (sensorName.find()) {
                        String res = sensorName.group().substring(1, 5);
                        //System.out.println(res);
                        if (res.equals(sensor)) {
                            if (getHumidity.find()) {
                                Double temp = Double.parseDouble(getHumidity.group().substring(0, 4));
                                panel.setPanelCurrentReading(temp + "");
                                panel.drawDirectlyFromBuffer(temp, "humidity");
                                //System.out.println("Temperature : " + temp);
                            }
                        }
                        Thread.sleep(5);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error in reading input file");
        } catch (InterruptedException ex) {
            System.err.println("END OF FILE (EOF)");
        }
    }

    public void readDataOnlyPresure(Panel panel, String sensor, int totalSensor) {
        try {
            while (true) {
                //INPUT PATTERN UNTUK MEMBACA DARI TEXT FILE
                Pattern detectSensorName = Pattern.compile("].... :");
                Pattern pPressure1 = Pattern.compile(patternPressure1);
                Pattern pPressure2 = Pattern.compile(patternPressure2);
                panel.setPanelUnit("Bar");
                File input = inputFile;

                switch (totalSensor) {
                    case 3:
                        input = inputFile3;
                        break;
                    case 6:
                        input = inputFile6;
                        break;
                    case 9:
                        input = inputFile;
                        break;
                    default:
                        break;
                }

                reader = new BufferedReader(new FileReader(input));
                String line = "";

                while ((line = reader.readLine()) != null) {
                    Matcher sensorName = detectSensorName.matcher(line);
                    Matcher getPressure1 = pPressure1.matcher(line);
                    Matcher getPressure2 = pPressure2.matcher(line);

                    if (sensorName.find()) {
                        String res = sensorName.group().substring(1, 5);
                        if (res.equals(sensor)) {
                            if (getPressure2.find()) {
                                Double temp = Double.parseDouble(getPressure2.group().substring(0, 5));
                                panel.setPanelCurrentReading(temp + "");
                                panel.drawDirectlyFromBuffer(temp, "pressure");
                                //System.out.println("Pressure 2 : " + temp);
                            } else if (getPressure1.find()) {
                                Double temp = Double.parseDouble(getPressure1.group().substring(0, 5));
                                temp = temp / 1000;
                                panel.setPanelCurrentReading(temp + "");
                                panel.drawDirectlyFromBuffer(temp, "pressure");
                                //System.out.println("Pressure 1 : " + temp);
                            }

                        }
                        Thread.sleep(5);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error in reading input file");
        } catch (InterruptedException ex) {
            System.err.println("END OF FILE (EOF)");
        }
    }

    /**
     * Method yang mengembalikan nama-nama sensor apa saja yang terdapat pada
     * input file .txt
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void getAllSensorName() throws FileNotFoundException, IOException {
        File input = inputFile;
        reader = new BufferedReader(new FileReader(input));
        String line = "";

        Pattern detectSensorName = Pattern.compile("].... :");
        while ((line = reader.readLine()) != null) {
            Matcher sensorName = detectSensorName.matcher(line);
            if (sensorName.find()) {
                String res = sensorName.group().substring(1, 5);
                if (!this.listOfSensors.contains(res)) {
                    this.listOfSensors.add(res);
                }
            }
        }
    }

    /**
     * Menampilkan visualisasi maksimal 9 sensor untuk masing-masing satuan
     *
     * @param sensorType
     * @throws FileNotFoundException
     */
    public void readDataSpecificSensor(String sensorType) throws FileNotFoundException {
        File input = inputFile;
        reader = new BufferedReader(new FileReader(input));
        String line = "";

        if (sensorType.equals("temperature")) {
            Pattern pTemperature = Pattern.compile(patternTemperature);
        } else if (sensorType.equals("humidity")) {
            Pattern pHumidity = Pattern.compile(patternHumidity);
        } else if (sensorType.equals("pressure")) {
            Pattern pPressure1 = Pattern.compile(patternPressure1);
            Pattern pPressure2 = Pattern.compile(patternPressure2);
        }

    }
}
