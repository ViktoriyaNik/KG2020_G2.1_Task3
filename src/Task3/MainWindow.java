package Task3;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    DrawPanel dp;

    public MainWindow() throws HeadlessException {
        dp = new DrawPanel();
        this.add(dp);

    }
}
