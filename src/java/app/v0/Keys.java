package app.v0;

import java.awt.event.*;

public class Keys 
implements KeyListener {
    private final int W = KeyEvent.VK_W,
                    S = KeyEvent.VK_S,
                    D = KeyEvent.VK_D,
                    A = KeyEvent.VK_A;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case W -> {
            }
            case S -> {
            }
            case A -> {
            }
            case D -> {
            } 
            default -> {}
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
