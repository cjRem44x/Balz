package app.v0;

public class Bar {
    public int x, y, width, height,
                vel;

    public Bar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void vel(int vel) {
        this.vel = vel;
    }
}
