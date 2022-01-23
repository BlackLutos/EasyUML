package EasyUML;

import java.awt.*;

public class Line extends Component {
    Page parent;
    private int getx,gety,getx2,gety2;
    public Line(Page p, int x, int y, int x2, int y2){
        parent = p;
        parent.add(this);
        this.getx = x;
        this.gety = y;
        this.getx2 = x2;
        this.gety2 = y2;
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        g.setPaintMode();
        g.drawLine(10,10,10,50);
    }
    public int getX() {
        return getx;
    }
    public int getY() {
        return gety;
    }
    public int getX2() {
        return getx2;
    }
    public int getY2() {
        return gety2;
    }

}
