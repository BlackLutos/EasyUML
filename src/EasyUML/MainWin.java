package EasyUML;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWin extends JFrame {
    EasyUML parent;
    HeaderMenu headermenu;
    Toolbars toolbars;
    ElementZone elementZone;
    PageZone pageZone;
    ShowFileDialog showFileDialog;
    TabbedPane tabbedPane;
    ElementAttribute elementAttribute;
    int x; int y;
    State state = State.idle;
    MainWin(EasyUML p){
        parent = p;
        init();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = { "確定","取消" };
                int result = JOptionPane.showOptionDialog(null,
                        "確定要結束程式嗎?",
                        "EasyUML",
                        JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[0]);
                if(result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });


    }
    void init(){
        this.setLocation(200,50);
        this.setSize(800,600);
        this.setTitle(parent.name + " " + parent.version);
        //this.setResizable(false);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                //MainWin.this.getHeight();
                //System.out.println(MainWin.this.getHeight());
                headermenu.setBounds(0,0,MainWin.this.getWidth(),30);
                toolbars.setBounds(0,headermenu.getHeight(),MainWin.this.getWidth(),50);
                pageZone.setBounds(elementZone.getWidth(),elementZone.getY(),MainWin.this.getWidth()-elementZone.getWidth(),elementZone.getHeight()+(MainWin.this.getHeight()-600));
                tabbedPane.setBounds(tabbedPane.getX(), tabbedPane.getY() , 425+(getWidth()-800), pageZone.getHeight()-35);
                elementAttribute.setBounds(tabbedPane.getWidth(), tabbedPane.getY()+20,pageZone.getWidth()- tabbedPane.getWidth(),pageZone.getHeight()+(MainWin.this.getHeight()-600));
                elementZone.setBounds(0,toolbars.getHeight()+headermenu.getHeight(),200,MainWin.this.getHeight()-(toolbars.getHeight()+headermenu.getHeight())+(MainWin.this.getHeight()-600));
                System.out.println('/'+pageZone.getHeight()+',');
                System.out.println((pageZone.getHeight()+MainWin.this.getHeight()-600)-35);
            }


        });
        this.setDefaultCloseOperation(0);
        this.setLayout(null);
        headermenu = new HeaderMenu(this);
        headermenu.setBounds(0,0,this.getWidth(),30);
        this.add(headermenu);
        toolbars = new Toolbars(this);
        toolbars.setBackground(Color.pink);
        toolbars.setBounds(0,headermenu.getHeight(),this.getWidth(),50);
        this.add(toolbars);
        elementZone = new ElementZone(this);
        elementZone.setBackground(Color.CYAN);
        elementZone.setBounds(0,toolbars.getHeight()+headermenu.getHeight(),200,this.getHeight()-(toolbars.getHeight()+headermenu.getHeight()));
        this.add(elementZone);
        pageZone = new PageZone(this);
        pageZone.setBackground(Color.WHITE);
        pageZone.setBounds(elementZone.getWidth(),elementZone.getY(),this.getWidth()-elementZone.getWidth(),elementZone.getHeight());
        this.add(pageZone);
        tabbedPane = new TabbedPane(this);
        elementAttribute = new ElementAttribute(this);
    }
}

