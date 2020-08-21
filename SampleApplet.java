import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class SampleApplet extends Applet implements MouseMotionListener, MouseListener {
    boolean clicked_on_bed = false;
    int bedx, bedy, mouseX, mouseY;

    public void init() {
        bedx = 200;
        bedy = 100;
        mouseX = 0;
        mouseY = 0;
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        // init();
        // creating a new TwinXL bed
        Twin Bed = new Twin();
        Bed.init(bedx, bedy);
        // init();
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
        clicked_on_bed = mouseX > bedx && mouseX < (bedx + 158) && mouseY > bedy && mouseY < (bedy + 333);
        if (clicked_on_bed) {
            System.out.println("on bed");
            if (mouseX > 200 && mouseX < 542 && mouseY < 267 && mouseY > 100) {
                bedx = mouseX;
                bedy = mouseY;
            }
            repaint();
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
