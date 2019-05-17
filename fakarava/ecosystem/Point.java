package fakarava.ecosystem;

public class Point extends java.awt.Point {
    /**
     * @attribute
     */
    private int x;
    /**
     * @attribute
     */
    private int y;

    // Constructeurs :
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Méthodes d'instance :
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

    // Méthodes de classe :
	public static void Point(int x, int y) {
		Point(x,y);
	}
}