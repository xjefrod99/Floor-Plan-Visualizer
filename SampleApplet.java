import java.applet.Applet;
import java.awt.*;
import java.io.*;

public class SampleApplet extends Applet{

    public void paint(Graphics g){
        g.setColor(Color.red);
        g.drawRect(10,10,100,100); //width 250, height 100
        g.setColor(Color.blue);
        g.drawString("editings",10,50);

    }
}
