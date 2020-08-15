import java.applet.Applet;
import java.awt.*;
import java.io.*;

public class SampleApplet extends Applet{

    public void paint(Graphics g){
        g.setColor(Color.red);
        g.drawRect(200,100,500,500); //500 = 10ft; 50 = 1ft
        g.setColor(Color.blue);
        g.drawString("editings",10,50);

    }
}
