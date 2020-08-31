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
    int bedWidth = 158;
    int bedHeight = 333;

    public void init(int locx, int locy) {
        locationx = locx;
        locationy = locy;
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    //this function just paints the normal TwinXL bed at any given coordinates
    public void BedPaint(Graphics g){
        //twin XL are 38in X 80in
        g.setColor(Color.blue);
        g.fillRect(locationx,locationy,bedWidth,bedHeight); //so the w = 158.33 and l = 333.33 but trying to figure out how to pass a double to fillRect
        g.setColor(Color.black);
        g.drawRect(locationx,locationy,bedWidth,bedHeight);
        //drawing pillow
        g.setColor(Color.pink);
        g.fillRect((locationx + 30),locationy + 10,100,64);
        //drawing blanket
        g.setColor(Color.pink);
        g.fillRect(locationx,locationy + 85,bedWidth,bedHeight-85);
    }
    public void rotateBed(Graphics g){
        int temp = bedWidth;
        bedWidth = bedHeight;
        bedHeight = temp;
        this.BedPaint(g);
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

}
