import java.applet.Applet;
import java.awt.*;
import java.io.*;

public class Twin extends Applet{
    public void BedPaint(Graphics g, int x, int y){
        //twin XL are 38in X 80in
        g.setColor(Color.blue);
        g.fillRect(x,y,158,333); //so the w = 158.33 and l = 333.33 but trying to figure out how to pass a double to fillRect
        g.setColor(Color.black);
        g.drawRect(x,y,158,333);
        //pillow
        g.setColor(Color.pink);
        g.fillRect((x + 30),y + 10,100,64);
        //blanket
        g.setColor(Color.pink);
        g.fillRect(x,y + 85,158,248);
    }
}