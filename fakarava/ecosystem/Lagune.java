package fakarava.ecosystem;

//TODO : COMMENTARY
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
    private static Integer MAX_DENSITY;

    /**
     * @attribute
     */
    public static Case[] grille;

    /**
     * @attribute
     */
    protected static Integer force_courant= MAX_CURRENT_STRENGTH/nb_passe;

    //Méthodes d'Instances :

    public void setForce_courant(Integer force_courant) {
        Lagune.force_courant = force_courant;
    }

    public Integer getForce_courant() {
        return force_courant;
    }

    //Méthodes de classe : 

    public static void setMAX_DENSITY(Integer MAX_DENSITY){
        Lagune.MAX_DENSITY = MAX_DENSITY;
    }
    public static Integer getMAX_DENSITY(){
        return MAX_DENSITY;
    }

    public static void creer_grille() {
        int k = -1;
        for (int i = 0; i < N; i++) {
            k++;
            for (int j = 0; j < N; j++) {
                grille[k] = new Case(i,j);
                k++;
            }
        }
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

}
