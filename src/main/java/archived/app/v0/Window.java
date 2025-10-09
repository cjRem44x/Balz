package app.v0;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window 
extends JPanel {
    private JFrame f = new JFrame();
    private Bar bar = null;
    private Color bar_clr;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.bar != null) {
            g.setColor(bar_clr);
            g.fillRect(bar.x, bar.y, bar.width, bar.height);
        }
    }

    public void build(String title) {
        this.setLayout(null);
        initFrame(title);
    }

    public void size(int width, int height) {
        this.setPreferredSize(
            new Dimension(width, height)
        );
    }

    public void bar(Bar b) {
        this.bar = b;
    }

    public void barfg(int r, int b, int g) {
        bar_clr = new Color(r, g, b);
    }

    public void winbg(int r, int g, int b) {
        this.setBackground(
            new Color(r, g, b)
        );
    }

    public void keyboard(KeyListener k) {
        f.addKeyListener(k);
    }

    public void initFrame(String title) {
        f.add(this);
        f.pack();
        f.setTitle(title);
        f.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );
        f.setResizable(false);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
