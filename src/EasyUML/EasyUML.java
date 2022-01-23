package EasyUML;

import javax.print.attribute.standard.RequestingUserName;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyUML {
    public final String name = "EasyUML";
    public final String version = "0.1";
    public MainWin mainwin;
    EasyUML(){
        mainwin = new MainWin(this);
        mainwin.setVisible(true);
    }
}
