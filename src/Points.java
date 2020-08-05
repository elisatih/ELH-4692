 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kresn
 */
public class Points {

    private int x, y;
    protected int speed = 3;
    private boolean visible;
    //private InputDataFromText datas;

    /**
     * Constructor Points
     *
     * @param startX
     * @param startY
     */
    public Points(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.speed = 2;
        visible = true;
    }

    /**
     * Method DisplayData Menampilkan points-points yang merepresentasikan
     * temperatur, humidity, dan pressure if posisi x nya sudah lebih kecil dari
     * 20, maka akan hidden pada posX tsb
     */
    public synchronized void displayData() {
        if(x < 35){
            visible = false;
        }        
        else{
            x = x - speed;
        }
        //DRAW RECT
//        if (x > 800){
//            visible = false;
//        }
    }
    
    public void checkDataBelowOrBeyond(){
        if(y < 50 || y > 190){
            visible = false;
        }
    }

    public int getX() {
        return x;
    }
    
    public void setX(int newx){
        this.x = newx;
    }

    public int getY() {
        return y;
    }

    public boolean getVisible() {
        return visible;
    }
    
    public void setSpeed(int x){
        this.speed = x;
    }
}
