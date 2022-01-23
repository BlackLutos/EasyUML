package EasyUML;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ShapeAttribute extends JPanel {
    ElementAttribute parent;
    String word="Text";
    String text_size="15";
    Boolean enter=false;
    Boolean size_enter=false;
    ShapeAttribute(ElementAttribute p,int x,int y,int w,int h,String text_word,String textSize){
        parent =p;
        this.setLayout(null);
        parent.removeAll();
        String lx = Integer.toString(x);
        String ly = Integer.toString(y);
        String sw = Integer.toString(w);
        String sh = Integer.toString(h);
        //this.setBounds(parent.getX(),parent.getY(),parent.getWidth(),parent.getHeight());
        /*JLabel type = new JLabel("類型:正方形");
        type.setBounds(30,-80,200,200);
        type.setFont(new Font(null,Font.BOLD,15));*/
        JLabel text = new JLabel("元件屬性");
        text.setBounds(30,-80,200,200);
        text.setFont(new Font(null,Font.BOLD,25));
        JLabel size = new JLabel("大小：");
        size.setBounds(5,52,100,100);
        size.setFont(new Font(null,Font.BOLD,15));
        JTextField size_w = new JTextField(sw);
        size_w.setEditable(false);
        JTextField size_h = new JTextField(sh);
        size_h.setEditable(false);
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
        JTextField location_x = new JTextField(lx);
        location_x.setEditable(false);
        JTextField location_y = new JTextField(ly);
        location_y.setEditable(false);
        location_x.setBounds(55,175,40,20);
        location_y.setBounds(110,175,40,20);
        JLabel textcontent = new JLabel("文字內容：");
        textcontent.setBounds(5,232,100,100);
        textcontent.setFont(new Font(null,Font.BOLD,15));
        JTextField textcontentfield = new JTextField(text_word);
        textcontentfield.setFocusable(true);
        textcontentfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    word = textcontentfield.getText();
                    enter = true;
                }
            }
        });
        textcontentfield.setBounds(80,275,80,20);
        JLabel textsize = new JLabel("文字大小：");
        textsize.setBounds(5,332,100,100);
        textsize.setFont(new Font(null,Font.BOLD,15));
        JTextField textsizefield = new JTextField(textSize);
        textsizefield.setFocusable(true);
        textsizefield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    text_size = textsizefield.getText();
                    size_enter = true;
                }
            }
        });
        textsizefield.setBounds(80,375,80,20);
        //parent.add(type);
        parent.add(text);
        parent.add(size);
        parent.add(size_w);
        parent.add(size_h);
        parent.add(w_label);
        parent.add(h_label);
        parent.add(location);
        parent.add(label_x);
        parent.add(label_y);
        parent.add(location_x);
        parent.add(location_y);
        parent.add(textcontent);
        parent.add(textcontentfield);
        parent.add(textsize);
        parent.add(textsizefield);;
    }
}
