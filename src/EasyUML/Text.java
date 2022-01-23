package EasyUML;

import java.awt.*;

public class Text extends Shape {
    Text(Page p, int x, int y, int w, int h) {
        super(p, x, y, w, h);
        //JLabel jTextField = new JLabel("請輸入文字");
    }
    public void paint(Graphics g){
        if(super.shapeAttribute.enter){
            word = super.shapeAttribute.word;
        }
        if(super.shapeAttribute.size_enter){
            size_text = super.shapeAttribute.text_size;
        }
        int textsize = Integer.valueOf(size_text);
        g.setFont(new Font(null,Font.BOLD,textsize));
        g.drawString(word,10,30);
        parent.updateUI();
    }
}
