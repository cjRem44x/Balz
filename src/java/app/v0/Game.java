package app.v0;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.Timer;
import app.v0.*;

public class Game {
    private Bar bar;
    private Window win;
    private List<Ball> balls = new ArrayList<>();
    private int num_balls = 10, ball_size = 50, ball_speed = 5;

    public static final int WIDTH = 800, HEIGHT = 600,
                        BAR_WIDTH = 100, BAR_HEIGHT = 20, BAR_SPEED = 90,
                        FPS = 120;
    public Game() {
        launch();
        loop();
    }

    public void launch() {
        createBalls();
        win = new Window();
        bar = new Bar(
            (int)((WIDTH/2.00)-(BAR_WIDTH/2.00)),
            (int)((HEIGHT*0.90)-(BAR_HEIGHT/2.00)),
            BAR_WIDTH, BAR_HEIGHT
        );
        bar.vel(BAR_SPEED);
        win.comp(this.bar, this.balls);
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
        barCollision();
        ballCollision();
        moveBalls();
        inter();
        win.repaint();
    }

    private void barCollision() {
        if (bar.x >= (WIDTH - BAR_WIDTH)) bar.x = (WIDTH - BAR_WIDTH);
        if (bar.x <= 0) bar.x = 0;
    }

    private void ballCollision() {
        for (int i=0; i<this.num_balls; i++) {
            Ball b = this.balls.get(i);
            b.borderCollision(WIDTH, HEIGHT);
        }
    }

    private void moveBalls() {
        for (int i=0; i<this.num_balls; i++) {
            Ball b = this.balls.get(i);
            b.x += b.vx;
            b.y += b.vy;
            b.gravitas();
        }
    }

    private void inter() {
        Rectangle recbar = new Rectangle(
            this.bar.x, this.bar.y, this.bar.width, this.bar.height
        );
        for (int i=0; i<this.num_balls; i++) {
            Ball b = this.balls.get(i);
            Rectangle recball = new Rectangle(
                b.x, b.y, b.width, b.height
            );

            if ( recball.intersects(recbar) ) {
                b.vx *= -1;
                b.vy *= -1;
            }
        }
    }

    private void createBalls() {
        for (int i=0; i<this.num_balls; i++) {
            Ball b = new Ball(this.ball_size, this.ball_size, this.ball_size, this.ball_size);
            b.vel(this.ball_speed*rand(-1, 1), this.ball_speed*rand(-1, 1));
            this.balls.add(b);
        }
    }

    private int rand(int min, int max) {
        final var RANDOM = new java.util.Random();
        return RANDOM.nextInt((max - min) + 1) + min;
    }
}
