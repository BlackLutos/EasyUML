package EasyUML;

import java.awt.*;

public  class Rectangle extends Shape {
    Rectangle(Page p, int x, int y, int w, int h) {
        super(p, x, y, w, h);

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.setPaintMode();
        Point p=this.getLocation();
        Dimension s=this.getSize();
        g.drawRect(10, 10, s.width-20, s.height-20);
        if(super.shapeAttribute.enter){
            word = super.shapeAttribute.word;
        }
        if(super.shapeAttribute.size_enter){
            size_text = super.shapeAttribute.text_size;
        }
        int textsize = Integer.valueOf(size_text);
        g.setFont(new Font(null,Font.BOLD,textsize));
        g.drawString(word,30,30);
        parent.updateUI();
        //System.out.println("x,y,w,h" + p.x + " " + p.y + " " + s.width +" " + s.height);
        //g.drawRect(getX() + 10, getY() + 10, getW() - 20, getH() - 20);
        //g.drawString("rect created!", 50, 50);

}
}
