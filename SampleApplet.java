import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class SampleApplet extends Applet implements MouseMotionListener, MouseListener {
    boolean clicked_on_bed = false;
    int locationx, locationy, mouseX, mouseY;

    public void init(int locx, int locy) {
        locationx = locx;
        locationy = locy;
        mouseX = 0;
        mouseY = 0;
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        // creating a new TwinXL bed
        Twin Bed = new Twin();
        Bed.init(200, 100);
        init(200, 100);
        // this is the room
        g.setColor(Color.orange);
        g.fillRect(200, 100, 500, 500); // scale: 500 = 10ft; 50 = 1ft

        // drawing the twinXL bed at a specified location
        // Bed.init(200,100);
        Bed.BedPaint(g);

    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        // showStatus("Mouse at (" + mouseX + "," + mouseY + ")");
        clicked_on_bed = mouseX > locationx && mouseX < (locationx + 158) && mouseY > locationy
                && mouseY < (locationy + 333);
        if (clicked_on_bed) {
            System.out.println("on bed");
        }
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
