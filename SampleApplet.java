import java.applet.Applet;
import java.awt.*;
import java.io.*;


public class SampleApplet extends Applet{

    public void paint(Graphics g){
        //setForeground(Color.red);
        Twin Bed = new Twin();
        g.setColor(Color.orange);
        g.fillRect(200,100,500,500); //scale: 500 = 10ft; 50 = 1ft
        //g.setColor(Color.blue);
        //g.drawString("editings",10,50);
        Bed.BedPaint(g);

    }
}
