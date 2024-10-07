package app.v0;

import app.v0.*;

public class Game {
    private Bar bar;
    private Window win;

    public static final int WIDTH = 800, HEIGHT = 600,
                        PLAYER_SIZE = 50;

    public Game() {
        launch();
    }

    public void launch() {
        win = new Window();
        bar = new Bar(
            (int)((WIDTH/2.00)-(PLAYER_SIZE/2.00)),
            (int)((HEIGHT*0.75)-(PLAYER_SIZE/2.00)),
            PLAYER_SIZE, PLAYER_SIZE
        );
        win.bar(bar);
        win.barfg(255,0,0);
        win.winbg(0,0,0);
        win.size(WIDTH, HEIGHT);
        win.keyboard( new Keys(bar) );
        win.build("Balz");
    }

    public void loop() {
        // TODO: build loop.
    }
}
