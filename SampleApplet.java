import java.applet.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class SampleApplet extends Applet implements MouseMotionListener, MouseListener, KeyListener {
    boolean clicked_on_bed = false;
    boolean clicked_on_desk = false;
    boolean clicked_in_room = false;
    boolean clicked_on_dresser = false;
    int bedx, bedy, mouseX, mouseY, drex, drey, deskx, desky;
    int height = 400;
    int width = 500;
    int originX = 100;
    int originY = 100;
    int dresserWidth = 149;
    int dresserHeight = 95;
    int bedWidth = 158;
    int bedHeight = 333;
    int deskWidth = 198;
    int deskHeight = 105;
    boolean rotateDesk = false;
    boolean rotateDresser = false;
    int bedCount = 0;

    public void init() {
        bedx = originX+bedWidth/2;
        bedy = originY+bedHeight/2;
        drex = originX+width-dresserWidth/2;
        drey = originY+height-dresserHeight/2;
        deskx = originX+width-deskWidth/2;
        desky = originY+deskHeight/2;
        mouseX = 0;
        mouseY = 0;
        addMouseMotionListener(this);
        addMouseListener(this);
        setSize((originX*2)+width, (originY*2)+height);
        setVisible( true );
    }


    public void paint(Graphics g) {
        // init();
        // creating a new TwinXL bed
        Twin Bed = new Twin();
        Bed.init(bedx-bedWidth/2, bedy-bedHeight/2);
        //System.out.println("input: " + bedCount);
        Bed.rotate_Bed(g, bedCount);
        // init();
        // creating a new TwinXL bed
        Desk desk = new Desk();
        desk.init(deskx-deskWidth/2, desky-deskHeight/2);
        if(rotateDesk){
            desk.rotate_Desk(g);
        }

        Dresser drawers = new Dresser();
        drawers.init(drex-dresserWidth/2, drey-dresserHeight/2);
        if(rotateDresser){
            drawers.rotate_Dresser(g);
        }
        // init();
        // this is the room
        g.setColor(Color.orange);
        //created roomD to reference room dimensions
        g.fillRect(originX, originY, width, height); // scale: 500 = 10ft; 50 = 1ft

        // drawing the twinXL bed at a specified location
        // Bed.init(200,100);
        Bed.BedPaint(g);
        desk.DeskPaint(g);
        drawers.DresserPaint(g);

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


        if(!clicked_on_desk && !clicked_on_dresser){
          clicked_on_bed = (mouseX >= (bedx-bedWidth/2) && mouseX <= (bedx + bedWidth/2)) && (mouseY >= (bedy-bedHeight/2) && mouseY <= (bedy + bedHeight/2));
          System.out.println("checking bed");
        }

        if(!clicked_on_bed && !clicked_on_dresser){
          clicked_on_desk = (mouseX >= (deskx-deskWidth/2) && mouseX <= (deskx + deskWidth/2)) && (mouseY >= (desky-deskHeight/2) && mouseY <= (desky + deskHeight/2));
          System.out.println("checking desk");
        }
        if(!clicked_on_desk && !clicked_on_bed){
          clicked_on_dresser = (mouseX >= (drex-dresserWidth/2) && mouseX <= (drex + dresserWidth/2)) && (mouseY >= (drey-dresserHeight/2) && mouseY <= (drey + dresserHeight/2));
          System.out.println("checking dresser");
        }
        clicked_in_room = (mouseX >= originX && mouseX < originX+width) && (mouseY < originY+height && mouseY >= originY);

        System.out.println("clicked_on_bed:"+clicked_on_bed);
        System.out.println("clicked_in_room:"+clicked_in_room);
        System.out.println("clicked_on_desk:"+clicked_on_desk);
        System.out.println("clicked_on_dresser:"+clicked_on_dresser);

        //((mouseX>=bedWidth/2)||(mouseX<width-bedWidth/2)||(mouseY>bedHeight/2)||(mouseY<bedHeight/2))
        if (clicked_in_room) {
            if(clicked_on_bed){
              System.out.println("on bed main");
              if(mouseX>=originX+bedWidth/2 && mouseX<=originX+width-bedWidth/2){
                bedx = mouseX;
              }
              if(mouseY<=originY+height-bedHeight/2 && mouseY>=originY+bedHeight/2){
                bedy = mouseY;
              }
            }
            if(clicked_on_desk){
                System.out.println("on desk main");
                if(mouseX>=originX+deskWidth/2 && mouseX<=originX+width-deskWidth/2){
                  deskx = mouseX;
                }
                if(mouseY<=originY+height-deskHeight/2 && mouseY>=originY+deskHeight/2){
                  desky = mouseY;
                }
            }
            if(clicked_on_dresser){
              System.out.println("on dresser main");
              if(mouseX>=originX+dresserWidth/2 && mouseX<=originX+width-dresserWidth/2){
                drex = mouseX;
              }
              if(mouseY<=originY+height-dresserHeight/2 && mouseY>=originY+dresserHeight/2){
                drey = mouseY;
              }
            }
            repaint();
        }
    }

    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        clicked_on_bed = (mouseX >= (bedx-bedWidth/2) && mouseX <= (bedx + bedWidth/2)) && (mouseY >= (bedy-bedHeight/2) && mouseY <= (bedy + bedHeight/2));
        clicked_on_desk = (mouseX >= (deskx-deskWidth/2) && mouseX <= (deskx + deskWidth/2)) && (mouseY >= (desky-deskHeight/2) && mouseY <= (desky + deskHeight/2));
        clicked_on_dresser = (mouseX >= (drex-dresserWidth/2) && mouseX <= (drex + dresserWidth/2)) && (mouseY >= (drey-dresserHeight/2) && mouseY <= (drey + dresserHeight/2));
        clicked_in_room = (mouseX >= originX && mouseX < originX+width) && (mouseY < originY+height && mouseY >= originY);
        System.out.println("Bedx:"+bedx+", Bedy:"+bedy );
        System.out.println("clicked_on_bed:"+clicked_on_bed);
        System.out.println("clicked_on_desk:"+clicked_on_desk);
        System.out.println("clicked_on_dresser:"+clicked_on_dresser);
        if(clicked_on_bed){
            bedCount += 1;
            if(bedCount==4){
              bedCount=0;
            }
            System.out.println(bedCount);
            int temp = bedWidth;
            bedWidth = bedHeight;
            bedHeight = temp;
            System.out.println("TRIED TO ROTATE");
        }
        if(clicked_on_dresser){
            rotateDresser = !rotateDresser;
            int temp = dresserWidth;
            dresserWidth = dresserHeight;
            dresserHeight = temp;
        }
        if(clicked_on_desk){
            rotateDesk = !rotateDesk;
            int temp = deskWidth;
            deskWidth = deskHeight;
            deskHeight = temp;
        }
        clicked_on_desk = false;
        clicked_on_dresser = false;
        clicked_on_bed = false;
        clicked_in_room = false;
        repaint();
    }
    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
      /*
        mouseX = e.getX();
        mouseY = e.getY();
        clicked_on_bed = (mouseX >= bedx && mouseX <= (bedx + bedWidth)) && (mouseY >= bedy && mouseY <= (bedy + bedHeight));
        clicked_in_room = (mouseX >= 0 && mouseX < width) && (mouseY < height && mouseY >= 0);

        if (clicked_on_bed && clicked_in_room){
            clicked_on_bed = false;
            clicked_in_room = false;
            System.out.println("released: should draw");
            bedx = mouseX;
            bedy = mouseY;
            repaint();
        }
        */
    }

    public void mouseReleased(MouseEvent e) {
        ///need both mouserelesed and exited bc they are called at diff time, the transitions
        //are not great
        mouseX = e.getX();
        mouseY = e.getY();
        clicked_on_bed = false;
        clicked_in_room = false;
        clicked_on_desk = false;
        clicked_on_dresser = false;
        repaint();
    }

    public void mousePressed(MouseEvent e) {
    }
}
