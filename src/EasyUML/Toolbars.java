package EasyUML;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbars extends JToolBar {
    MainWin parent;
    int tabindex = 1;
    int getTabindex=0;
    int getTabCount=0;
    int getx = 0;
    int gety = 0;
    Toolbars(MainWin p){
        parent = p;
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton newfileBtn = new JButton();
        JButton storefileBtn = new JButton();
        JButton openfileBtn = new JButton();
        JButton deletefileBtn = new JButton();
        newfileBtn.setIcon(new ImageIcon("icon/newfileBtn.png"));
        storefileBtn.setIcon(new ImageIcon("icon/storefileBtn.png"));
        openfileBtn.setIcon(new ImageIcon("icon/openfileBtn.png"));
        deletefileBtn.setIcon(new ImageIcon("icon/deletefileBtn.png"));

        newfileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.pageZone.add(parent.tabbedPane);
                parent.pageZone.add(parent.elementAttribute);
                parent.add(parent.elementZone);
                String tabtitle = "NewPage" + tabindex;
                JScrollPane scrollPane = new JScrollPane(new Page(parent.tabbedPane));
                scrollPane.setBounds(scrollPane.getX(),scrollPane.getY(),100,100);
                //JPanel PaintPanel = new JPanel();
                //parent.drawPage.createPage.NewPage(tabtitle,parent.drawPage,parent.drawPage.x,parent.drawPage.y);
                parent.tabbedPane.addTab(tabtitle,scrollPane);
                parent.tabbedPane.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        //System.out.println(parent.drawPage.getSelectedIndex());
                        getTabindex = parent.tabbedPane.getSelectedIndex();
                        getTabCount = parent.tabbedPane.getTabCount();
                    }
                });
                tabindex++;
                System.out.println(getTabCount);
                if (tabindex==3){
                    parent.tabbedPane.setSelectedIndex(getTabindex+1);
                }
                else if(tabindex>3){
                    parent.tabbedPane.setSelectedIndex(getTabCount);
                }
                    //parent.drawPage.setSelectedIndex(getTabindex+1);
                parent.pageZone.updateUI();
                scrollPane.setFocusable(true);
                scrollPane.requestFocus();
            }
        });
        deletefileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.tabbedPane.remove(parent.tabbedPane.getSelectedIndex());
                //parent.drawPage.getSelectedComponent();
                if(parent.tabbedPane.getSelectedIndex()==-1){
                    parent.pageZone.removeAll();
                    tabindex = 1;
                }
                parent.pageZone.updateUI();
            }
        });
        openfileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showFileDialog.showFileOpenDialog();
            }
        });
        storefileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showFileDialog.showFileStoreDialog();
            }
        });
        this.add(newfileBtn);
        this.add(storefileBtn);
        this.add(openfileBtn);
        this.add(deletefileBtn);
        this.setFloatable(false);
    }

}
