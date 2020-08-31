import java.applet.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class SampleApplet extends Applet implements MouseMotionListener, MouseListener, KeyListener {
    boolean clicked_on_bed = false;
    boolean clicked_in_room = false;
    int bedx, bedy, mouseX, mouseY;

    public void init() {
        bedx = 200;
        bedy = 100;
        mouseX = 0;
        mouseY = 0;
        addMouseMotionListener(this);
        addMouseListener(this);
        setSize( 800, 600 );
        setVisible( true );
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
        repaint();

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
    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        System.out.println("Main: Mouse at (" + mouseX + "," + mouseY + ")" );
        clicked_on_bed = (mouseX > bedx && mouseX < (bedx + 158)) && mouseY > bedy && mouseY < (bedy + 333);
        clicked_in_room = mouseX > 200 && mouseX < 542 && mouseY < 500 && mouseY > 100;
        if (clicked_on_bed && clicked_in_room) {
            System.out.println("on bed main");
            // this if statement has to be changed bc it's currently hardcoded to the room's
            // specs
            // if (mouseX > 200 && mouseX < 542 && mouseY < 267 && mouseY > 100) {
            bedx = mouseX;
            bedy = mouseY;
            // }
            repaint();
        }
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Bedx:"+bedx+", Bedy:"+bedy );
        System.out.println("clicked_on_bed:"+clicked_on_bed);
        System.out.println("clicked_in_room:"+clicked_in_room);
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {

        if (clicked_on_bed | clicked_in_room){
            clicked_on_bed = false;
            clicked_in_room = false;
            System.out.println("released: should draw");
            bedx = mouseX;
            bedy = mouseY;
            repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {
        ///need both mouserelesed and exited bc they are called at diff time, the transitions
        //are not great
        if (clicked_on_bed | clicked_in_room){
            clicked_on_bed = false;
            clicked_in_room = false;
            System.out.println("released: should draw");
            bedx = mouseX;
            bedy = mouseY;
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {
    }
}
