package app.v0;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import app.v0.*;

public class Game {
    private Bar bar;
    private Window win;
    private List<Ball> balls = new ArrayList<>();
    private int num_balls = 3, ball_size = 50, ball_speed = 5, 
                score = 0;
    private JLabel flash_lbl = null, score_lbl = null, shadow = null;

    public static final int WIDTH = 800, HEIGHT = 600,
                        BAR_WIDTH = 100, BAR_HEIGHT = 20, BAR_SPEED = 90,
                        FPS = 120;
/***************************************************************/
    public Game() {
        launch();
        loop();
    }
/***************************************************************/
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
    /**/
    public void loop() {
        Timer timer = new Timer((int)(1000/FPS), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        timer.start();
    }
    /**/
    public void update() {
        dispScore();
        barCollision();
        ballCollision();
        inter();
        moveBalls();
        ballScores();
        win.repaint();
    }

    public void ballScores() {
        for (Ball b: this.balls) {
            if ((b.y+b.height) >= HEIGHT) {
                this.score++;            
            }
        }
    }

    public void dispScore() {
        if (this.score_lbl != null) win.remove(this.score_lbl);
        if (this.shadow != null) win.remove(this.shadow);

        this.score_lbl = new JLabel(Integer.toString(this.score));
        this.score_lbl.setFont( new Font("serif", Font.BOLD, 100) );
        this.score_lbl.setBounds(
            WIDTH/2,
            50,
            WIDTH/5, WIDTH/5
        );
        this.score_lbl.setForeground(Color.magenta);
        win.add(this.score_lbl);
        this.shadow = new JLabel(Integer.toString(this.score));
        this.shadow.setFont( new Font("serif", Font.BOLD, 100) );
        this.shadow.setBounds(
            WIDTH/2-5,
            52,
            WIDTH/5, WIDTH/5
        );
        this.shadow.setForeground(Color.gray);
        win.add(this.shadow);
    }
/*************************************************************************/
    private void barCollision() {
        if (bar.x >= (WIDTH - BAR_WIDTH)) bar.x = (WIDTH - BAR_WIDTH);
        if (bar.x <= 0) bar.x = 0;
    }
    /**/
    private void ballCollision() {
        for (int i=0; i<this.num_balls; i++) {
            Ball b = this.balls.get(i);
            b.borderCollision(WIDTH, HEIGHT);
        }
    }
    /**/
    private void inter() {
        Rectangle bar_rect = new Rectangle(
            bar.x, bar.y, bar.width, bar.height
        );
        for (int i=0; i<this.balls.size(); i++) {
            Ball b = this.balls.get(i);
            Rectangle b_rect = new Rectangle(
                b.x, b.y, b.width, b.height
            );

            if ( b_rect.intersects(bar_rect) && b.border_hit ) {
                b.vx *= -1;
                b.vy *= -1;
                b.border_hit = false;
            }
        }
    }
/*********************************************************************************/
    private void moveBalls() {
        for (int i=0; i<this.num_balls; i++) {
            Ball b = this.balls.get(i);
            check_speed(b);
            b.x += b.vx;
            b.y += b.vy;
            b.gravitas();
        }
    }
    /**/
    private void createBalls() {
        for (int i=0; i<this.num_balls; i++) {
            Ball b = new Ball(this.ball_size, this.ball_size, this.ball_size, this.ball_size);
            b.vel(this.ball_speed*rand(-1, 1), this.ball_speed*rand(-1, 1));
            this.balls.add(b);
        }
    }

    private void check_speed(Ball b)
    {
        // Fix slow ball at start
        if (b.vy == 0 || b.vx == 0)
        {
            b.vy += ball_speed;
            b.vx -= ball_speed;
        }
    }
/***************************************************************/
    private int rand(int min, int max) {
        final var RANDOM = new java.util.Random();
        return RANDOM.nextInt((max - min) + 1) + min;
    }
}
