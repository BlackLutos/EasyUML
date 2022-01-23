package EasyUML;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class ShowFileDialog {
    MainWin parent;
    ShowFileDialog(MainWin p){
        parent = p;
    }
    public static void showFileOpenDialog(){
        JFrame OpenFileWin = new JFrame("開啟檔案");
        OpenFileWin.setSize(600,400);
        OpenFileWin.setLocationRelativeTo(null);
        JPanel OpenFilePane = new JPanel();
        final JTextArea msgTextArea = new JTextArea(10,30);
        msgTextArea.setLineWrap(true);
        OpenFilePane.add(msgTextArea);

        JFileChooser OpenFileChooser = new JFileChooser();
        OpenFileChooser.setCurrentDirectory(new File("."));
        OpenFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        OpenFileChooser.setMultiSelectionEnabled(true);
        OpenFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("zip(*.zip,*.rar)","zip","rar"));
        OpenFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
        OpenFileChooser.setFileFilter(new FileNameExtensionFilter("UML(*.uml)", "uml"));
        int result = OpenFileChooser.showOpenDialog(OpenFileWin);
        if (result == OpenFileChooser.APPROVE_OPTION){
            File file = OpenFileChooser.getSelectedFile();
            msgTextArea.append("打開文件：" + file.getAbsolutePath() + "\n\n");
        }
        OpenFileWin.setContentPane(OpenFilePane);
    }
    public static void showFileStoreDialog(){
        JFrame StoreFileWin = new JFrame("開啟檔案");
        StoreFileWin.setSize(600,400);
        StoreFileWin.setLocationRelativeTo(null);
        JPanel StoreFilePane = new JPanel();
        final JTextArea msgTextArea = new JTextArea(10,30);
        msgTextArea.setLineWrap(true);
        StoreFilePane.add(msgTextArea);
        JFileChooser StoreFileChosser = new JFileChooser();
        StoreFileChosser.setSelectedFile(new File("NewPage" + ".jpg"));
        int result = StoreFileChosser.showSaveDialog(StoreFileWin);
        if(result == StoreFileChosser.APPROVE_OPTION) {
            File file = StoreFileChosser.getSelectedFile();
            msgTextArea.append("保存到文件：" + file.getAbsolutePath() + "\n\n");
        }
        StoreFileWin.setContentPane(StoreFilePane);
    }

    public void savePic(JFrame jf){
        //得到窗口内容面板
        Container content=jf.getContentPane();
        //创建缓冲图片对象
        BufferedImage img=new BufferedImage(
                jf.getWidth()-20,jf.getHeight()-40,BufferedImage.TYPE_INT_RGB);
        //得到图形对象
        Graphics2D g2d = img.createGraphics();
        //将窗口内容面板输出到图形对象中
        content.print(g2d);
        //保存为图片
        File f=new File("saveScreen.jpg");
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //释放图形对象
        g2d.dispose();
    }
}