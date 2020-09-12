import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.awt.event.*;

public class Twin extends Applet implements MouseMotionListener, MouseListener{
    boolean clicked_on_bed = false;
    int locationx, locationy, mouseX, mouseY;
    int rotateBed = 0;
    int bedWidth = 158;
    int bedHeight = 333;
    int pillowL = 100;
    int pillowW = 64;
    int blanket = 85;
    public void init(int locx, int locy) {
        locationx = locx;
        locationy = locy;
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    //this function just paints the normal TwinXL bed at any given coordinates
    public void BedPaint(Graphics g){
        if(rotateBed==1){
            g.setColor(Color.blue);
            g.fillRect(locationx,locationy, bedHeight, bedWidth); //so the w = 158.33 and l = 333.33 but trying to figure out how to pass a double to fillRect
            g.setColor(Color.black);
            g.drawRect(locationx,locationy,bedHeight,bedWidth);
            //drawing pillow
            g.setColor(Color.pink);
            g.fillRect((locationx + 10),locationy + 30, pillowW ,pillowL);
            //drawing blanket
            g.setColor(Color.pink);
            g.fillRect(locationx+blanket,locationy,bedHeight-blanket, bedWidth);
            //System.out.println(rotateBed);
        }
        if(rotateBed==2){
          //twin XL are 38in X 80in
            g.setColor(Color.blue);
            g.fillRect(locationx,locationy,bedWidth,bedHeight); //so the w = 158.33 and l = 333.33 but trying to figure out how to pass a double to fillRect
            g.setColor(Color.black);
            g.drawRect(locationx,locationy,bedWidth,bedHeight);
            //drawing pillow
            g.setColor(Color.pink);
            g.fillRect((locationx + 30),locationy + bedHeight - pillowW - 10, pillowL ,pillowW);
            //drawing blanket
            g.setColor(Color.pink);
            g.fillRect(locationx,locationy,bedWidth,bedHeight- blanket);
        }
        if(rotateBed==3){
            g.setColor(Color.blue);
            g.fillRect(locationx,locationy, bedHeight, bedWidth); //so the w = 158.33 and l = 333.33 but trying to figure out how to pass a double to fillRect
            g.setColor(Color.black);
            g.drawRect(locationx,locationy,bedHeight,bedWidth);
            //drawing pillow
            g.setColor(Color.pink);
            g.fillRect((locationx + bedHeight - pillowW -10),locationy + 30, pillowW ,pillowL);
            //drawing blanket
            g.setColor(Color.pink);
            g.fillRect(locationx,locationy,bedHeight-blanket, bedWidth);
            //System.out.println(rotateBed);
        }
        else if(rotateBed==0){
            //twin XL are 38in X 80in
            g.setColor(Color.blue);
            g.fillRect(locationx,locationy,bedWidth,bedHeight); //so the w = 158.33 and l = 333.33 but trying to figure out how to pass a double to fillRect
            g.setColor(Color.black);
            g.drawRect(locationx,locationy,bedWidth,bedHeight);
            //drawing pillow
            g.setColor(Color.pink);
            g.fillRect((locationx + 30),locationy + 10, pillowL ,pillowW);
            //drawing blanket
            g.setColor(Color.pink);
            g.fillRect(locationx,locationy +blanket,bedWidth,bedHeight- blanket);
            //System.out.println(rotateBed);
        }

    }
    public void rotate_Bed(Graphics g, int count){
        rotateBed = count;
    }

    public void mouseMoved(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {/*
        mouseX = e.getX();
        mouseY = e.getY();
        clicked_on_bed = mouseX > locationx && mouseX < (locationx + 158) &&
                            mouseY > locationy && mouseY < (locationy + 333);
        if (clicked_on_bed){
            System.out.println("on bed");
        }*/
    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(final MouseEvent e) {
    }
    public void mousePressed(final MouseEvent e) {
    }
    public void keyPressed( KeyEvent e ) {
        //perhaps use this part to make it rotate, but the console did not register whena key was pressed
        //call this.rotateBed() if 'B' is pressed
        int ch = e.getKeyCode();

        System.out.println(ch);
        repaint();

    }
    public void keyReleased( KeyEvent e ) { }
    public void keyTyped( KeyEvent e ) {  }

}
