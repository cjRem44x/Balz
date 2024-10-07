package app.v0;

import java.awt.event.*;
import javax.swing.Timer;
import app.v0.*;

public class Game {
    private Bar bar;
    private Window win;

    public static final int WIDTH = 800, HEIGHT = 600,
                        BAR_WIDTH = 100, BAR_HEIGHT = 20, BAR_SPEED = 90,
                        FPS = 120;
    public Game() {
        launch();
        loop();
    }

    public void launch() {
        win = new Window();
        bar = new Bar(
            (int)((WIDTH/2.00)-(BAR_WIDTH/2.00)),
            (int)((HEIGHT*0.90)-(BAR_HEIGHT/2.00)),
            BAR_WIDTH, BAR_HEIGHT
        );
        bar.vel(BAR_SPEED);
        win.bar(bar);
        win.barfg(255,0,0);
        win.winbg(0,0,0);
        win.size(WIDTH, HEIGHT);
        win.keyboard( new Keys(bar) );
        win.build("Balz");
    }

    public void loop() {
        Timer timer = new Timer((int)(1000/FPS), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        timer.start();
    }

    public void update() {
        if (bar.x >= (WIDTH - BAR_WIDTH)) bar.x = (WIDTH - BAR_WIDTH);
        if (bar.x <= 0) bar.x = 0;
        win.repaint();
    }
}
