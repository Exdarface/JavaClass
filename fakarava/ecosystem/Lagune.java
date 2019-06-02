package fakarava.ecosystem;

import java.util.ArrayList;

public abstract class Lagune {
    /**
     * @attribute
     */
    protected static Integer N;

    /**
     * @attribute
     */
    protected static int nb_passe;
    /**
     * @attribute
     */
    private static Integer MAX_CURRENT_STRENGTH;

    /**
     * @attribute
     */
    protected static Integer MAX_DENSITY;

    /**
     * @attribute
     */
    public static ArrayList<Case> grille; // Tableau de Case construisant notre Lagune
    
    /**
     * @attribute
     */
    protected static Random rn;



    //Méthodes de classe : 

    /**
     * Change la densité Maximale de la Lagune
     * @param MAX_DENSITY nouvelle densitée Maximale
     */
    public static void setMAX_DENSITY(Integer MAX_DENSITY){
        Lagune.MAX_DENSITY = MAX_DENSITY;
    }

    /**
     * Récupère la densité Maximale de la Lagune
     * @return densitée Maximale de la Lagune
     */
    public static Integer getMAX_DENSITY(){
        return MAX_DENSITY;
    }

    /**
     * Créé un tableau de Case construisant notre Lagune
     */
    public static void creer_grille() {
        Lagune.grille = new ArrayList<Case>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Lagune.grille.add(new Case(i,j));
            }
        }
    }

    /**
     * Change la longueur de coté de la grille
     * @param N longueur de la grille
     */
    public static void setN(Integer N) {
        Lagune.N = N;
    }

    /**
     * Récupère la longueur de coté de la grille
     * @return la longueur de coté de la grille
     */
    public static Integer getN() {
        return N;
    }

    /**
     * Transforme la force du courant Maximale de la Lagune
     * @param MAX_CURRENT_STRENGTH nouvelle force du courant Maximale
     */
    public static void setMAX_CURRENT_STRENGTH(Integer MAX_CURRENT_STRENGTH) {
        Lagune.MAX_CURRENT_STRENGTH = MAX_CURRENT_STRENGTH;
    }

    /**
     * Récupère la force du courant Maximale de la Lagune
     * @return force du courant Maximale de la Lagune
     */
    public static Integer getMAX_CURRENT_STRENGTH() {
        return MAX_CURRENT_STRENGTH;
    }

    public static void setRn(Random rn) {
        Lagune.rn = rn;
    }

    public static Random getRn() {
        return rn;
    }

    public static ArrayList<Case> getGrille() {
        return grille;
    }
}
