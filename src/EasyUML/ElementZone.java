package EasyUML;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.channels.FileLock;

public class ElementZone extends JPanel {
    MainWin parent;
    int element=0;
    State state = State.idle;
    ElementZone(MainWin p){
        super();
        parent = p;
        this.setLayout(new GridLayout(9,1));
        JLabel name = new JLabel("     元件區域");
        name.setFont(new Font(null, Font.BOLD, 25));
        this.add(name);
        JButton oval = new JButton();
        JButton rect = new JButton();
        JButton line = new JButton();
        JButton select = new JButton();
        JButton actor = new JButton();
        JButton text = new JButton("Text");
        select.setIcon(new ImageIcon("icon/selectBtn.png"));
        rect.setIcon(new ImageIcon("icon/rectBtn.png"));
        oval.setIcon(new ImageIcon("icon/ovalBtn.png"));
        line.setIcon(new ImageIcon("icon/lineBtn.png"));
        actor.setIcon(new ImageIcon("icon/actorBtn.png"));
        this.add(select);
        this.add(rect);
        this.add(oval);
        this.add(actor);
        this.add(line);
        this.add(text);

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = State.ready2Select;
            }
        });
        rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = State.ready2drawRect;
            }
        });
        oval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = State.ready2drawOval;
            }
        });
        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = State.ready2drawLine;
            }
        });
        actor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { state = State.ready2drawActor;}
        });
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = State.ready2drawText;
            }
        });


    }
    /*public enum State {
        idle,ready2drawRect,ready2drawOval,ready2drawLine;
    }*/
}
