package fakarava.ecosystem;

public class Point extends java.awt.Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        super(x,y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return this.x + ", " + this.y;
    }
}