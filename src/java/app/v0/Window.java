package app.v0;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Window 
extends JPanel {
    private JFrame f = new JFrame();
    private Bar bar = null;
    private List<Ball> balls = null;

    private int rmin = 25, rmax = 254, 
                gmin = 25, gmax = 254, 
                bmin = 25, bmax = 254;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.balls != null) {
            for (int i=0; i<this.balls.size(); i++) {
                Ball b = this.balls.get(i);
                g.setColor( new Color(
                    rand(this.rmin, this.rmax), 
                    rand(this.gmin, this.gmax), 
                    rand(this.bmin, this.bmax)
                ) );
                g.fillOval(b.x, b.y, b.width, b.height);

                if ( (b.y+b.height) >= this.getHeight() ) {
                    g.setColor(Color.red);
                    g.fillRect(0, this.getHeight()-10, this.getWidth(), 10);
                }
            }
        }
        if (this.bar != null) {
            g.setColor( 
                new Color(0, rand(50, 255), 0) 
            );
            g.fillRect(bar.x-3, bar.y-3, bar.width+3, bar.height+3);
            g.setColor( 
                new Color( rand(50, 255), 0, rand(50, 155) ) 
            );
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

    public void comp(Bar bar, List<Ball> balls) {
        this.bar = bar;
        this.balls = balls;
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

    private int rand(int min, int max) {
        final var RANDOM = new java.util.Random();
        return RANDOM.nextInt((max - min) + 1) + min;
    }
}
