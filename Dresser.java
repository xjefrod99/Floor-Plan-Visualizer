import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Dresser extends Applet implements MouseMotionListener, MouseListener{
    boolean clicked_on_dresser = false;
    int locationx, locationy, mouseX, mouseY;
    int dresserWidth = 149;
    int dresserHeight = 95;
    boolean rotateDresser = false;

    public void init(int locx, int locy) {
        locationx = locx;
        locationy = locy;
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    //this function paints the dresser
    public void DresserPaint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(locationx,locationy,dresserWidth,dresserHeight);
        g.setColor(Color.black);
        g.drawRect(locationx,locationy,dresserWidth,dresserHeight);
    }

    public void rotate_Dresser(Graphics g){
        rotateDresser = !rotateDresser;
        int temp = dresserWidth;
        dresserWidth = dresserHeight;
        dresserHeight = temp;
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
