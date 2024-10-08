package app.v0;

import java.awt.event.*;

public class Keys 
implements KeyListener {
    private Bar bar;
    private final int W = KeyEvent.VK_W,
                    S = KeyEvent.VK_S,
                    D = KeyEvent.VK_D,
                    A = KeyEvent.VK_A;

    public Keys(Bar b) {
        this.bar = b;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case A -> {
                bar.x -= bar.vel;
            }
            case D -> {
                bar.x += bar.vel;
            } 
            default -> {}
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
