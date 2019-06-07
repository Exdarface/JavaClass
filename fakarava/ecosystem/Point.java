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
    
    /**
     * Renvoies la coordonnee X du Point
     * @return la coordonnee X du Point
     */
    public double getX() {
        return this.x;
    }
    
    /**
     * Renvoies la coordonnee Y du Point
     * @return la coordonnee Y du Point
     */
    public double getY() {
        return this.y;
    }

    /**
     * Renvoies les informations du Point
     * @return
     */
    @Override
    public String toString() {
        return this.x + ", " + this.y;
    }
}