package EasyUML;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shape extends Component {
    Page parent;
    String textcontent="";
    String word="Text";
    String size_text="15";
    //Shape_State state = Shape_State.notselect;
    State state;
    boolean isOutlineVisible=false;
    private int getx,gety,getw,geth,click=0,rx,ry,px,py,dx,dy,resize_px,resize_py,resize_rx,resize_ry,resize_dx,resize_dy;
    ShapeAttribute shapeAttribute;
    int hidex,hidey,hidew,hideh;
    JPanel n,e,s,we,ne,se,sw,nw;
    public Shape(Page p,int x,int y,int w,int h){
        super();
        parent = p;
        parent.add(this);
        this.setLocation(x,y);
        this.setSize(w, h);
        //this.setBounds(x,y,w,h);
        this.getx = x;
        this.gety = y;
        this.dx = x;
        this.dy = y;
        this.getw = w;
        this.geth = h;
        resize_dx = resize_rx   - resize_px;
        resize_dy = resize_ry   - resize_py;
        //紅點
        se = new JPanel();
        se.setSize(5,5);
        se.setBackground(Color.red);
        se.setVisible(false);
        parent.add(se);
        //se.setVisible(false);
        se.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(state == State.SelectGraph){
                    state = State.ready2Resize;
                    resize_px = e.getLocationOnScreen().x;
                    resize_py = e.getLocationOnScreen().y;
                    hideoutline();
                }
            }
        });
        se.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(state==State.resizing)
                {
                    state=State.SelectGraph;
                    showoutline();
                }
                else if(state==State.ready2Resize)
                {
                    state=State.SelectGraph;
                    resize_px = 0;
                    resize_py = 0;
                    showoutline();
                }
            }
        });
        se.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(state == State.ready2Resize){
                    state = State.resizing;
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width+(resize_rx-resize_px),s.height+(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,dx,dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
                else if(state == State.resizing){
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width+(resize_rx-resize_px),s.height+(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,dx,dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
            }
        });
        e = new JPanel();
        e.setSize(5,5);
        e.setBackground(Color.red);
        e.setVisible(false);
        parent.add(e);
        //se.setVisible(false);
        e.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(state == State.SelectGraph){
                    state = State.ready2Resize;
                    resize_px = e.getLocationOnScreen().x;
                    resize_py = e.getLocationOnScreen().y;
                    hideoutline();
                }
            }
        });
        e.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(state==State.resizing)
                {
                    state=State.SelectGraph;
                    showoutline();
                }
                else if(state==State.ready2Resize)
                {
                    state=State.SelectGraph;
                    resize_px = 0;
                    resize_py = 0;
                    showoutline();
                }
            }
        });
        e.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(state == State.ready2Resize){
                    state = State.resizing;
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width+(resize_rx-resize_px),s.height);
                    resize_px = resize_rx;

                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,dx,dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
                else if(state == State.resizing){
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width+(resize_rx-resize_px),s.height);
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,dx,dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
            }
        });
        s = new JPanel();
        s.setSize(5,5);
        s.setBackground(Color.red);
        s.setVisible(false);
        parent.add(s);
        //se.setVisible(false);
        s.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(state == State.SelectGraph){
                    state = State.ready2Resize;
                    resize_px = e.getLocationOnScreen().x;
                    resize_py = e.getLocationOnScreen().y;
                    hideoutline();
                }
            }
        });
        s.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(state==State.resizing)
                {
                    state=State.SelectGraph;
                    showoutline();
                }
                else if(state==State.ready2Resize)
                {
                    state=State.SelectGraph;
                    resize_px = 0;
                    resize_py = 0;
                    showoutline();
                }
            }
        });
        s.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(state == State.ready2Resize){
                    state = State.resizing;
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width,s.height+(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,dx,dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
                else if(state == State.resizing){
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width,s.height+(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,dx,dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
            }
        });
        ne = new JPanel();
        ne.setSize(5,5);
        ne.setBackground(Color.red);
        ne.setVisible(false);
        parent.add(ne);
        //se.setVisible(false);
        ne.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(state == State.SelectGraph){
                    state = State.ready2Resize;
                    resize_px = e.getLocationOnScreen().x;
                    resize_py = e.getLocationOnScreen().y;
                    hideoutline();
                }
            }
        });
        ne.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(state==State.resizing)
                {
                    state=State.SelectGraph;
                    showoutline();
                }
                else if(state==State.ready2Resize)
                {
                    state=State.SelectGraph;
                    resize_px = 0;
                    resize_py = 0;
                    showoutline();
                }
            }
        });
        ne.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(state == State.ready2Resize){
                    state = State.resizing;
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width+(resize_rx-resize_px),s.height-(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,resize_dx,resize_dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
                else if(state == State.resizing){
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width+(resize_rx-resize_px),s.height-(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,resize_dx,resize_dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
            }
        });
        nw = new JPanel();
        nw.setSize(5,5);
        nw.setBackground(Color.red);
        nw.setVisible(false);
        parent.add(nw);
        //se.setVisible(false);
        nw.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(state == State.SelectGraph){
                    state = State.ready2Resize;
                    resize_px = e.getLocationOnScreen().x;
                    resize_py = e.getLocationOnScreen().y;
                    hideoutline();
                }
            }
        });
        nw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(state==State.resizing)
                {
                    state=State.SelectGraph;
                    showoutline();
                }
                else if(state==State.ready2Resize)
                {
                    state=State.SelectGraph;
                    resize_px = 0;
                    resize_py = 0;
                    showoutline();
                }
            }
        });
        nw.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(state == State.ready2Resize){
                    state = State.resizing;
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width-(resize_rx-resize_px),s.height-(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,resize_dx,resize_dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
                else if(state == State.resizing){
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width-(resize_rx-resize_px),s.height-(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,resize_dx,resize_dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
            }
        });

        we= new JPanel();
        we.setSize(5,5);
        we.setBackground(Color.red);
        we.setVisible(false);
        parent.add(we);
        //se.setVisible(false);
        we.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(state == State.SelectGraph){
                    state = State.ready2Resize;
                    resize_px = e.getLocationOnScreen().x;
                    resize_py = e.getLocationOnScreen().y;
                    hideoutline();
                }
            }
        });
        we.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(state==State.resizing)
                {
                    state=State.SelectGraph;
                    showoutline();
                }
                else if(state==State.ready2Resize)
                {
                    state=State.SelectGraph;
                    resize_px = 0;
                    resize_py = 0;
                    showoutline();
                }
            }
        });
        we.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(state == State.ready2Resize){
                    state = State.resizing;
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width-(resize_rx-resize_px),s.height-(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,resize_dx,resize_dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
                else if(state == State.resizing){
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width-(resize_rx-resize_px),s.height-(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,resize_dx,resize_dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
            }
        });


        sw = new JPanel();
        sw.setSize(5,5);
        sw.setBackground(Color.red);
        sw.setVisible(false);
        parent.add(sw);
        //se.setVisible(false);
        sw.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(state == State.SelectGraph){
                    state = State.ready2Resize;
                    resize_px = e.getLocationOnScreen().x;
                    resize_py = e.getLocationOnScreen().y;
                    hideoutline();
                }
            }
        });
        sw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(state==State.resizing)
                {
                    state=State.SelectGraph;
                    showoutline();
                }
                else if(state==State.ready2Resize)
                {
                    state=State.SelectGraph;
                    resize_px = 0;
                    resize_py = 0;
                    showoutline();
                }
            }
        });
        sw.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(state == State.ready2Resize){
                    state = State.resizing;
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width-(resize_rx-resize_px),s.height+(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,resize_dx,resize_dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
                else if(state == State.resizing){
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width-(resize_rx-resize_px),s.height+(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,resize_dx,resize_dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
            }
        });


        n = new JPanel();
        n.setSize(5,5);
        n.setBackground(Color.red);
        n.setVisible(false);
        parent.add(n);
        //se.setVisible(false);
        n.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(state == State.SelectGraph){
                    state = State.ready2Resize;
                    resize_px = e.getLocationOnScreen().x;
                    resize_py = e.getLocationOnScreen().y;
                    hideoutline();
                }
            }
        });
        n.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(state==State.resizing)
                {
                    state=State.SelectGraph;
                    showoutline();
                }
                else if(state==State.ready2Resize)
                {
                    state=State.SelectGraph;
                    resize_px = 0;
                    resize_py = 0;
                    showoutline();
                }
            }
        });
        n.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(state == State.ready2Resize){
                    state = State.resizing;
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width+(resize_rx-resize_px),s.height-(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,resize_dx,resize_dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
                else if(state == State.resizing){
                    resize_rx = e.getLocationOnScreen().x;
                    resize_ry = e.getLocationOnScreen().y;
                    Dimension s = Shape.this.getSize();
                    Shape.this.setSize(s.width+(resize_rx-resize_px),s.height-(resize_ry-resize_py));
                    resize_px = resize_rx;
                    resize_py = resize_ry;
                    shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,resize_dx,resize_dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                    parent.parent.parent.elementAttribute.updateUI();
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_DELETE){
                    if(Shape.this.isOutlineVisible)
                    {
                        System.out.println("delete myself!");
                        Shape.this.hideoutline();
                        Shape.this.setVisible(false);
                        parent.remove(Shape.this);
                    }
                }
            }
        });
        shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,dx,dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
        parent.parent.parent.elementAttribute.updateUI();
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    //super.mousePressed(e);
                    System.out.println("Pressed");
                    if((Shape.this.parent.actshape!=Shape.this)&&(Shape.this.parent.actshape!=null)){
                        parent.actshape.hideoutline();
                        parent.actshape.state=State.ready2Select;
                        parent.actshape=null;
                        System.out.println("mouseListener hidelastoutline");
                    }
                    if (parent.parent.parent.elementZone.state == State.ready2Select) {
                        state = State.SelectGraph;
                        showoutline();
                        // parent.updateUI();
                        hidex=getLocation().x;
                        hidey=getLocation().y;
                        hideh=getSize().height;
                        hidew=getSize().width;
                        Shape.this.parent.actshape=Shape.this;
                        System.out.println("ready2select to actived");

                            //state = State.ready2mvoe;
                            shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,dx,dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                            parent.parent.parent.elementAttribute.updateUI();
                            //System.out.println("actived to ready2move");
                    }
                    /*px = e.getX()-Shape.this.getx;
                    py = e.getY()-Shape.this.gety;*/
                    px = e.getLocationOnScreen().x-Shape.this.getx;
                    py = e.getLocationOnScreen().y-Shape.this.gety;
                }
            });
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    if(state==State.SelectGraph)
                    {
                        Shape.this.setFocusable(true);
                        Shape.this.requestFocusInWindow();
                    }
                    else if(state == State.SelectGraph){
                        //hideoutline();
                        state = State.SelectGraph;
                        //parent.updateUI();
                        //parent.updateUI();
                    }
                    if(state == State.moving){
                        hideoutline();
                        state=State.ready2Select;
                        System.out.println("moving to idle");
                        //parent.updateUI();
                        //parent.updateUI();
                    }
                /*click =1;
                if (click==1){
                    state=Shape_State.select;
                }*/
                }
            });
            this.addMouseMotionListener(new MouseAdapter() {
                //  this.addMouseListener(new MouseAdapter() 你打ㄉ
                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                    System.out.println("Dragged");
                    //hideoutline();
                    //parent.updateUI();
                    //rx = e.getX();
                    // ry = e.getY();
                    if(state == State.SelectGraph){
                        //state = State.ready2mvoe;
                        hideoutline();
                        parent.updateUI();
                        state = State.moving;
                        rx = e.getLocationOnScreen().x;
                        ry = e.getLocationOnScreen().y;
                        dx = rx - px;
                        dy = ry - py;
                        System.out.println(rx+","+ry);
                        Shape.this.setLocation(dx,dy);
                        Shape.this.getx =  dx; Shape.this.gety =  dy;
                        shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,dx,dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                        parent.parent.parent.elementAttribute.updateUI();
                    }
                    else if(state == State.moving){
                        hideoutline();
                        parent.updateUI();
                        rx = e.getLocationOnScreen().x;
                        ry = e.getLocationOnScreen().y;
                        dx = rx - px;
                        dy = ry - py;
                        System.out.println(rx+","+ry);
                        Shape.this.setLocation(dx,dy);
                        Shape.this.getx =  dx; Shape.this.gety =  dy;
                        shapeAttribute = new ShapeAttribute(parent.parent.parent.elementAttribute,dx,dy,Shape.this.getSize().width,Shape.this.getSize().height,word,size_text);
                        parent.parent.parent.elementAttribute.updateUI();
                    }
                    //Shape.this.setLocation(dx,dy);
                    //Shape.this.getx =  dx; Shape.this.gety =  dy;
                }
            });
            //state = State.notactived;
            //System.out.println("state:notactived");
            //hideoutline();


    }
    /*
    public void paint(Graphics g){


        g.setColor(Color.BLACK);
        //textcontent=parent.parent.parent.elementAttribute.text;
        //parent.updateUI();
        if(state==State.ready2drawActor){
            g.drawString(textcontent,getX()+25,getY()+71);
        }
        else{
            g.drawString(textcontent,getX()+20,getY()+30);
        }
        //g.drawString(parent.parent.parent.elementAttribute.textcontent_s,getX()+20,getY()+30);
    }
    */

    public void showControlPoint(){
        se.setLocation(getLocation().x+ getSize().width,getLocation().y+getSize().height-5);
        se.setVisible(true);
        e.setLocation(getLocation().x+ getSize().width,getLocation().y+getSize().height/2-5);
        e.setVisible(true);
        ne.setLocation(getLocation().x+ getSize().width,getLocation().y);
        ne.setVisible(true);
        nw.setLocation(getLocation().x-5,getLocation().y);
        nw.setVisible(true);
        we.setLocation(getLocation().x-5,getLocation().y+getSize().height/2-5);
        we.setVisible(true);
        sw.setLocation(getLocation().x-5,getLocation().y+getSize().height-5);
        sw.setVisible(true);
        n.setLocation(getLocation().x+getSize().width/2-2,getLocation().y-5);
        n.setVisible(true);
        s.setLocation(getLocation().x+getSize().width/2,getLocation().y+getSize().height-1);
        s.setVisible(true);

    }
    public void hideControlPoint(){
        se.setVisible(false);
        e.setVisible(false);
        ne.setVisible(false);
        nw.setVisible(false);
        we.setVisible(false);
        sw.setVisible(false);
        n.setVisible(false);
        s.setVisible(false);
    }
    public void showoutline(){
        if(!this.isOutlineVisible){
            Graphics g= this.parent.getGraphics();
            //g.setXORMode(new Color(0,255,255));
            g.setColor(Color.CYAN);
            g.drawRect(getLocation().x,getLocation().y,getSize().width,getSize().height);
            //g.drawRect(getLocation().x-10,getLocation().y-10,getSize().width-20,getSize().height-20);
            hidex=getX();
            hidey=getY();
            this.isOutlineVisible=true;
            showControlPoint();
        }
    }
    public void hideoutline(){
        if(this.isOutlineVisible){
            Graphics g= this.parent.getGraphics();
            //g.setXORMode(new Color(0,255,255));
            g.setColor(Color.CYAN);
            g.drawRect(getLocation().x,getLocation().y,getSize().width,getSize().height);
            //g.drawRect(getLocation().x-10,getLocation().y-10,getSize().width-20,getSize().height-20);
            this.isOutlineVisible=false;
            System.out.println("hindingcontrolpoint");
            hideControlPoint();
        }
    }
    public void hidelastoutline(){
        if(this.isOutlineVisible){
            Graphics g= this.parent.getGraphics();
            //g.setXORMode(new Color(0,255,255));
            g.setColor(Color.CYAN);
            g.drawRect(hidex,hidey,hidew,hideh);
            this.isOutlineVisible=false;
            System.out.println("hidelastoutline");

        }
    }

    public int getX() {
        return getx;
    }
    public int getY() {
        return gety;
    }
    public int getW() {
        return getw;
    }
    public int getH() {
        return geth;
    }

}
