package EasyUML;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Page extends JScrollPane   {
    int x,y,x2,y2;
    Point lp;
    TabbedPane parent;
    State state = State.idle;
    Shape actshape;
    ArrayList<Shape> list = new ArrayList<Shape>();
    ArrayList<Line> Linelist = new ArrayList<Line>();
    //
    Image bufferImage;
    Graphics bufferGraphics;
    ///
    int notselect = 0;
    Page(TabbedPane p){
        //shape=null;
        parent =p;
        actshape=null;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(10000,10000));
        this.setBounds(this.getX(),this.getY(),parent.getWidth(),parent.getHeight());
        parent.parent.elementAttribute.removeAll();
        JTextArea introduce = new JTextArea();
        introduce.setText("歡迎使用"+"\n"+"EasyUML"+"\n"+"粉紅色區域"+"\n"+"從左至右為"+"\n"+"新增、儲存"+"\n"+"開啟、刪除"
                +"\n"+"中間區域"+"\n"+"為繪製區"+"\n"+"繪製元件後"+"\n"+"點擊選取按鈕"+"\n"+"並點擊元件"+"\n"+"即可對圖形"+"\n"+"進行操控");
        introduce.setBackground(Color.lightGray);
        introduce.setEditable(false);
        introduce.setFont(new Font(null,Font.BOLD,25));
        introduce.setBounds(0,0,parent.parent.elementAttribute.getWidth(),parent.parent.elementAttribute.getHeight());
        //text.setFont(new Font(null,Font.BOLD,25));
        parent.parent.elementAttribute.add(introduce);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                x2 = e.getX();
                y2 = e.getY();
                //System.out.println(x2+","+y2);
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                /*JTextArea introduce = new JTextArea();
                introduce.setText("測試");
                JLabel text = new JLabel("元件屬性");
                text.setBounds(30,-80,200,200);
                text.setFont(new Font(null,Font.BOLD,25));
                parent.parent.elementAttribute.add(text);
                parent.parent.elementAttribute.updateUI();*/
                /*
                bufferImage = createImage(500,500);
                bufferGraphics = bufferImage.getGraphics();
                */
                x = e.getX();
                y = e.getY();
                lp = e.getPoint();
                //JLabel label=""
                Graphics g = Page.this.getGraphics();
                g.setColor(Color.black);
                switch(parent.parent.elementZone.state){
                    case ready2Select:
                        parent.parent.elementZone.state = State.ready2Select;
                        break;
                    case idle:
                        //if(parent.parent.elementZone.state = State.idle;)
                        break;
                    case ready2drawRect:
                        //bufferGraphics.drawRect(x,y,100,100);
                        //g.drawString("正方形",x-20,y);
                        //g.drawRect(x-25,y-25,50,50);
                        Rectangle r = new Rectangle(Page.this,x,y,100,50);
                      //  repaint();
                      //  list.add(rect);
                        actshape=r;
                        break;
                    case ready2drawOval:
                        //g.drawString("圓形",x-15,y);
                        //g.drawOval(x-25,y-25,50,50);
                        Oval oval = new Oval(Page.this,x-50,y-50,100,50);
                        //repaint();
                        list.add(oval);
                        actshape=oval;
                        break;
                    case ready2drawActor:
                        Actor actor = new Actor(Page.this,x-50,y-50,50,80);
                        //repaint();
                        list.add(actor);
                        //shape=actor;
                        break;
                    case ready2drawLine:
                        //g.drawLine(x,y,x2,y2);
                        Line line = new Line(Page.this,x,y,x,y+100);
                        repaint();
                        Linelist.add(line);
                        break;
                    case ready2drawText:
                        Text text = new Text(Page.this,x-50,y-50,50,50);
                        //repaint();
                        list.add(text);
                        break;
                }
                System.out.println("ElementZone State:"+parent.parent.elementZone.state);
                if(parent.parent.elementZone.state==State.ready2Select){
                    //shape.state=State.ready2Select;
                    parent.parent.elementZone.state=State.ready2Select;
                    actshape.hideoutline();
                    System.out.println("hideoutline");
                    updateUI();
                };
                //parent.parent.elementZone.state=State.idle;0
            }
        });


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println(e.toString());
            }
        });


    /*    new Rectangle(this, 100, 200, 100,100);
        Button b=new Button("OK");
        b.setLocation(200,200);
        b.setSize(200,200);
        this.add(b);
*/


    }
    public void paint(Graphics g)
    {
        /*bufferGraphics.drawRect(x-50,y-50,100,100);
        paint(g);*/
        super.paint(g);//因为重写方法默认不会调用父类的方法，所以我们得手动调用

        //g.drawString("test", 100,100);

        /*g.drawImage(bufferImage,x,y,this);
        updateUI();*/
   /*     for(int i=0; i<list.size(); i++)
        {
            if(list.get(i)!=null)
            {//因为不画图形时队列为空，所以要加此判断
                Shape now = list.get(i);//得到图形
                now.draw(g);//绘制图形
            }
        }
        for(int i=0; i<Linelist.size(); i++)
        {
            if(Linelist.get(i)!=null)
            {//因为不画图形时队列为空，所以要加此判断
                Line now = Linelist.get(i);//得到图形
                now.draw(g);//绘制图形
            }
        }
*/
    }
}
