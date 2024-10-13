package app.v0;

public class Ball {
    public int x, y, 
        width, height,
        vx, vy, def_speed;

    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void vel(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
        this.def_speed = vx;
    }

    public void gravitas() {
        if (rand(1, 10) == 2) {
            this.y -= 1;
        }
    }

    public void borderCollision(int screen_width, int screen_height) {
        if (this.x <= 0) {
            this.vx *= -1;
            this.x = 0;  // Ensure it doesn't go past the border
            tweakVx();
        } else if (this.x >= (screen_width - this.width)) {
            this.vx *= -1;
            this.x = screen_width - this.width;  // Ensure it stays within bounds
            tweakVx();
        }
    
        if (this.y <= 0) {
            this.vy *= -1;
            this.y = 0;  // Ensure it doesn't go past the top border
            tweakVy();
        } else if (this.y >= (screen_height - this.height)) {
            this.vy *= -1;
            this.y = screen_height - this.height;  // Ensure it stays within bounds
            tweakVy();
        }
    }

    private void tweakVx() {
        if (rand(1, 10) == 2) {
            int n = rand(0, 5);
            switch (n) {
                default -> this.vx += rand(1, 5);
                case 1 -> this.vx -= rand(1, 7);
                case 2 -> this.vx = this.def_speed;
            }
            if (this.vx < 1) {
                this.vx = 1;
            }
            if (this.vx > 50) {
                this.vx = 50;
            }
        }
    }

    private void tweakVy() {
        if (rand(1, 10) == 2) {
            int n = rand(0, 5);
            switch (n) {
                default -> this.vy += rand(1, 3);
                case 1 -> this.vy -= rand(1, 7);
                case 2 -> this.vy = this.def_speed;
            }
            if (this.vy < 1) {
                this.vy = 1;
            }
            if (this.vy > 50) {
                this.vy = 50;
            }
        }
    }

    private int rand(int min, int max) {
        final var RANDOM = new java.util.Random();
        return RANDOM.nextInt((max - min) + 1) + min;
    }
}
