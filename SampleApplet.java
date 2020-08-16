import java.applet.Applet;
import java.awt.*;
import java.io.*;


public class SampleApplet extends Applet{

    public void paint(Graphics g){
        //creating a new TwinXL bed
        Twin Bed = new Twin();
        //this is the room
        g.setColor(Color.orange);
        g.fillRect(200,100,500,500); //scale: 500 = 10ft; 50 = 1ft
        
        //drawing the twinXL bed at a specified location
        Bed.BedPaint(g, 200, 100);

    }
}
