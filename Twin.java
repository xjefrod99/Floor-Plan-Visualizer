import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Twin extends Applet implements MouseMotionListener, MouseListener{
    int locationx, locationy, mouseX, mouseY;

    public void init(int locx, int locy) {
        locationx = locx;
        locationy = locy;
        mouseX = 0;
        mouseY = 0;
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    //this function just paints the normal TwinXL bed at any given coordinates
    public void BedPaint(Graphics g){
        //twin XL are 38in X 80in
        g.setColor(Color.blue);
        g.fillRect(locationx,locationy,158,333); //so the w = 158.33 and l = 333.33 but trying to figure out how to pass a double to fillRect
        g.setColor(Color.black);
        g.drawRect(locationx,locationy,158,333);
        //drawing pillow
        g.setColor(Color.pink);
        g.fillRect((locationx + 30),locationy + 10,100,64);
        //drawing blanket
        g.setColor(Color.pink);
        g.fillRect(locationx,locationy + 85,158,248);
    }

    public void mouseMoved(MouseEvent e) {

    }
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
    public void mouseClicked(MouseEvent e) {
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }
}