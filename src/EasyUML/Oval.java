package EasyUML;

import java.awt.*;

public  class Oval extends Shape {
    Oval(Page p, int x, int y, int w, int h){
        super(p,x,y,w,h);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        g.setPaintMode();
        Point p=this.getLocation();
        Dimension s=this.getSize();
        g.drawOval(10, 10, s.width-20, s.height-20);
        if(super.shapeAttribute.enter){
            word = super.shapeAttribute.word;
        }
        if(super.shapeAttribute.size_enter){
            size_text = super.shapeAttribute.text_size;
        }
        int textsize = Integer.valueOf(size_text);
        g.setFont(new Font(null,Font.BOLD,textsize));
        g.drawString(word,30,30);
    }
}
