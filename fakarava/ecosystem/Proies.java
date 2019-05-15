package fakarava.ecosystem;

import java.awt.Point;


public class Proies extends Poissons {
    public Proies(Integer numero_poisson, String nom_poisson, float poids_poisson, Integer age_poisson,
                  Point position_poisson,Integer vivacite_proie) {
        // TODO Implement this method
        super(numero_poisson, nom_poisson, poids_poisson, age_poisson, position_poisson);
        this.vivacite_proie = vivacite_proie;
    }

    /**
     * @attribute
     */
    private Integer vivacite_proie;

    /**
     * @attribute
     */
    private static Integer PREY_CLONE_TIME;

    public static Proies se_reproduit() {
    }
    
    @Override
    public String toString() {
    }

    public void setVivacite_proie(Integer vivacite_proie) {
        this.vivacite_proie = vivacite_proie;
    }

    public Integer getVivacite_proie() {
        return vivacite_proie;
    }

    public static void setPREY_CLONE_TIME(Integer PREY_CLONE_TIME) {
        Proies.PREY_CLONE_TIME = PREY_CLONE_TIME;
    }

    public static Integer getPREY_CLONE_TIME() {
        return PREY_CLONE_TIME;
    }
}
