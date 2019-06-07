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
    protected static ArrayList<Case> grille; // Tableau de Case construisant notre Lagune
    
    /**
     * @attribute
     */
    protected static Random rn;



    //Méthodes de classe : 

    /**
     * Change la densite Maximale de la Lagune
     * @param MAX_DENSITY nouvelle densite Maximale
     */
    public static void setMAX_DENSITY(Integer MAX_DENSITY){
        Lagune.MAX_DENSITY = MAX_DENSITY;
    }

    /**
     * Récupère la densite Maximale de la Lagune
     * @return densite Maximale de la Lagune
     */
    public static Integer getMAX_DENSITY(){
        return MAX_DENSITY;
    }

    /**
     * Cree un tableau de Case construisant notre Lagune
     */
    public static void creer_grille() {
        Lagune.grille = new ArrayList<Case>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Lagune.getGrille().add(new Case(i,j));
            }
        }
    }

    /**
     * Change la longueur de cote de la grille
     * @param N longueur de la grille
     */
    public static void setN(Integer N) {
        Lagune.N = N;
    }

    /**
     * Recupere la longueur de cote de la grille
     * @return la longueur de cote de la grille
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
     * Recupere la force du courant Maximale de la Lagune
     * @return force du courant Maximale de la Lagune
     */
    public static Integer getMAX_CURRENT_STRENGTH() {
        return MAX_CURRENT_STRENGTH;
    }

    /**
     * Recupere le nombre de passe de la Lagune
     * @return le nombre de passe de la Lagune
     */
    public static int getNb_passe(){
        return nb_passe;
    }
    
    /**
     *Change le generateur aleatoire de la Lagune
     * @param rn nouveau generateur aleatoire de la Lagune
     */
    public static void setRn(Random rn) {
        Lagune.rn = rn;
    }

    /**
     * Recupere le generateur aleatoire de la Lagune
     * @return le generateur aleatoire de la Lagune
     */
    public static Random getRn() {
        return rn;
    }

    /**
     * Recupere la grille de la Lagune
     * @return la grille de la Lagune
     */
    public static ArrayList<Case> getGrille() {
        return grille;
    }
}
