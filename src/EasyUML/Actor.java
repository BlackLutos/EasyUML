package EasyUML;

import java.awt.*;
import java.io.File;
import javax.imageio.*;

public class Actor extends Shape{
    Image image;
    Actor(Page p, int x, int y, int w, int h) {
        super(p, x, y, w, h);
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.setPaintMode();
        Point p=this.getLocation();
        Dimension s=this.getSize();
        try {
            //image = ImageIO.read(new File("C:\\Users\\BlackLutos\\Desktop\\軟體工程\\EasyUML\\icon\\actor.png"));
            //image = ImageIO.read(new File("actor.png"));
            //File file = new File(url.getPath());
            image = ImageIO.read(new File("icon/actor.png"));
        }
        catch (Exception ex) {
            System.out.println("No example.jpg!!");
        }
        g.drawImage(image, 0, 0,s.width,s.height-30, null);
        if(super.shapeAttribute.enter){
            word = super.shapeAttribute.word;
        }
        if(super.shapeAttribute.size_enter){
            size_text = super.shapeAttribute.text_size;
        }
        int textsize = Integer.valueOf(size_text);
        g.setFont(new Font(null,Font.BOLD,textsize));
        g.drawString(word,10,75);
    }
}
