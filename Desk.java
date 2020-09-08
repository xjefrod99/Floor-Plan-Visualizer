import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.awt.event.*;

public class Desk extends Applet implements MouseMotionListener, MouseListener{
    boolean clicked_on_desk = false;
    int locationx, locationy, mouseX, mouseY;
    int deskWidth = 198;
    int deskHeight = 105;

    public void init(int locx, int locy) {
        locationx = locx;
        locationy = locy;
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    //this function just paints the normal TwinXL bed at any given coordinates
    public void DeskPaint(Graphics g){
        //twin XL are 38in X 80in
        g.setColor(Color.blue);
        g.fillRect(locationx,locationy,deskWidth,deskHeight); //so the w = 158.33 and l = 333.33 but trying to figure out how to pass a double to fillRect
        g.setColor(Color.black);
        g.drawRect(locationx,locationy,deskWidth,deskHeight);
    }
    public void rotateDesk(Graphics g){
        int temp = deskWidth;
        deskWidth = deskHeight;
        deskHeight = temp;
        this.DeskPaint(g);
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
