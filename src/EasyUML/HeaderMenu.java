package EasyUML;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeaderMenu extends JMenuBar {
    MainWin parent;
    HeaderMenu(MainWin p){
        parent = p;
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        JMenu Filemenu = new JMenu("檔案  ");
        JMenu Editmenu = new JMenu("編輯  ");
        JMenu Viewmenu = new JMenu("檢視  ");
        JMenu Othermenu = new JMenu("其他 ");
        this.add(Filemenu);
        this.add(Editmenu);
        this.add(Viewmenu);
        this.add(Othermenu);
        JMenuItem newfileItem = new JMenuItem("新增檔案");
        JMenuItem storefileItem = new JMenuItem("儲存檔案");
        JMenuItem openfileItem = new JMenuItem("開啟檔案");
        Filemenu.add(newfileItem);
        Filemenu.add(storefileItem);
        Filemenu.add(openfileItem);
        JMenuItem cutItem = new JMenuItem("剪下");
        JMenuItem copyItem = new JMenuItem("複製");
        JMenuItem pasteItem = new JMenuItem("貼上");
        Editmenu.add(cutItem);
        Editmenu.add(copyItem);
        Editmenu.add(pasteItem);
        JMenuItem recentFile = new JMenuItem("最近的檔案");
        Viewmenu.add(recentFile);
        JMenuItem workMember = new JMenuItem("製作人員");
        Othermenu.add(workMember);
        newfileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.pageZone.add(parent.tabbedPane);
                parent.pageZone.updateUI();
            }
        });
        openfileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showFileDialog.showFileOpenDialog();
            }
        });
        storefileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showFileDialog.showFileStoreDialog();
            }
        });
        workMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame WorkMemberList = new JFrame("工作人員名單");
                WorkMemberList.setSize(400,400);
                WorkMemberList.setLocation(300,200);
                WorkMemberList.setVisible(true);
                JLabel text = new JLabel(new ImageIcon("icon/workmemberlist.png"));
                text.setHorizontalAlignment(SwingConstants.CENTER);
                text.setVerticalAlignment(SwingConstants.CENTER);
                WorkMemberList.add(text);
            }
        });
    }

}
