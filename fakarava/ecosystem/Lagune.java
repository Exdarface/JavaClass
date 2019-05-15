package fakarava.ecosystem;

import java.awt.Point;

import java.util.Collection;

public abstract class Lagune {
    /**
     * @attribute
     */
    private static Integer N;

    /**
     * @attribute
     */
    private static Integer MAX_CURRENT_STRENGTH;

    /**
     * @attribute
     */
    private Point[] grille;

    /**
     * @attribute
     */
    private Integer force_courant;

    public static void creer_grille() {
    }

    public static void setN(Integer N) {
        Lagune.N = N;
    }

    public static Integer getN() {
        return N;
    }

    public static void setMAX_CURRENT_STRENGTH(Integer MAX_CURRENT_STRENGTH) {
        Lagune.MAX_CURRENT_STRENGTH = MAX_CURRENT_STRENGTH;
    }

    public static Integer getMAX_CURRENT_STRENGTH() {
        return MAX_CURRENT_STRENGTH;
    }

    public void setForce_courant(Integer force_courant) {
        this.force_courant = force_courant;
    }

    public Integer getForce_courant() {
        return force_courant;
    }
}
