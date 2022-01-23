package EasyUML;

import javax.swing.*;
import java.awt.*;

public class ElementAttribute extends JPanel {
    MainWin parent;
    int hx=0;
    String text="yolo87";
    ElementAttribute(MainWin p){
        super();
        parent = p;
        this.setLayout(null);
        this.setBounds(parent.tabbedPane.getWidth(),parent.tabbedPane.getY()+20,parent.pageZone.getWidth()-parent.tabbedPane.getWidth(),parent.pageZone.getHeight());
        //this.add(rectangleAttribute);
        //this.setSize(parent.pageZone.getWidth()-parent.drawPage.getWidth(),parent.pageZone.getHeight());
        this.setBackground(Color.lightGray);
        /*JLabel text = new JLabel("元件");
        text.setBounds(30,-80,200,200);
        text.setFont(new Font(null,Font.BOLD,25));
        this.add(text);*/
        /*JLabel size = new JLabel("大小：");
        size.setBounds(5,52,100,100);
        size.setFont(new Font(null,Font.BOLD,15));
        JTextField size_w = new JTextField();
        JTextField size_h = new JTextField();
        JLabel w_label = new JLabel("寬");
        JLabel h_label = new JLabel("高");
        size_w.setBounds(55,95,40,20);
        size_h.setBounds(110,95,40,20);
        w_label.setBounds(65,100,50,50);
        h_label.setBounds(125,100,50,50);
        JLabel location = new JLabel("位置：");
        location.setBounds(5,132,100,100);
        location.setFont(new Font(null,Font.BOLD,15));
        JLabel label_x = new JLabel("X");
        JLabel label_y = new JLabel("Y");
        label_x.setBounds(65,180,50,50);
        label_y.setBounds(125,180,50,50);
        JTextField location_x = new JTextField();
        JTextField location_y = new JTextField();
        location_x.setBounds(55,175,40,20);
        location_y.setBounds(110,175,40,20);
        JLabel textcontent = new JLabel("文字內容：");
        textcontent.setBounds(5,232,100,100);
        textcontent.setFont(new Font(null,Font.BOLD,15));
        JTextField textcontentfield = new JTextField();
        textcontentfield.setBounds(80,275,80,20);
        JLabel textsize = new JLabel("文字大小：");
        textsize.setBounds(5,332,100,100);
        textsize.setFont(new Font(null,Font.BOLD,15));
        JTextField textsizefield = new JTextField();
        textsizefield.setBounds(80,375,80,20);
        this.add(text);
        this.add(size);
        this.add(size_w);
        this.add(size_h);
        this.add(w_label);
        this.add(h_label);
        this.add(location);
        this.add(label_x);
        this.add(label_y);
        this.add(location_x);
        this.add(location_y);
        this.add(textcontent);
        this.add(textcontentfield);
        this.add(textsize);
        this.add(textsizefield);*/

    }
}
