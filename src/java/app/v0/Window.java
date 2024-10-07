package app.v0;

import java.awt.*;
import javax.swing.*;

public class Window 
extends JPanel {
    private JFrame f = new JFrame();

    public void build(String title) {
        this.setLayout(null);
        initFrame(title);
    }

    public void size(int width, int height) {
        this.setPreferredSize(
            new Dimension(width, height)
        );
    }

    public void winbg(int r, int g, int b) {
        this.setBackground(
            new Color(r, g, b)
        );
    }

    public void initFrame(String title) {
        f.add(this);
        f.pack();
        f.setTitle(title);
        f.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
