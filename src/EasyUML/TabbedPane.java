package EasyUML;

import javax.swing.*;
import java.awt.*;

public class TabbedPane extends JTabbedPane {
    MainWin parent;
    int x=0;int y=0;
    Page page;
    TabbedPane(MainWin p) {
        super();
        parent = p;
        this.setBounds(this.getX(), this.getY() , 425, parent.pageZone.getHeight()-35);
        //this.setSize(425, parent.pageZone.getHeight());
        this.setBackground(Color.WHITE);
        this.setTabLayoutPolicy(SCROLL_TAB_LAYOUT);
    }

    /*public static JComponent createTextPanel(String text) {
        // 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
        //JPanel panel = new JPanel(new GridLayout(1, 1));
        JPanel panel = new JPanel();
        Graphics g;
        // 创建标签
        JLabel label = new JLabel(text);
        label.setFont(new Font(null, Font.PLAIN, 75));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        // 添加标签到面板
        //panel.add(label);
        return panel;
    }*/
}
