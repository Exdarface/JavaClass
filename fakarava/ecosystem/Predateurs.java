package fakarava.ecosystem;

import java.awt.Point;


public class Predateurs extends Poissons {
    public Predateurs(Integer numero_poisson, String nom_poisson, float poids_poisson, Integer age_poisson,
                      Point position_poisson,Integer vivacite_proie) {
        // TODO Implement this method
        super(numero_poisson, nom_poisson, poids_poisson, age_poisson, position_poisson);
    }

    /**
     * @attribute
     */
    private static Integer PREDATOR_CLONE_TIME;

    /**
     * @attribute
     */
    private static Integer BITE_FACTOR;

    public static void chasse() {
    }

    public static Predateurs se_reproduit() {
        if(unite_temps/PREDATOR_CLONE_TIME ==1){
            for (Case c : Lagune.grille) {
                for (Poissons p : c.getContenu()) {
                    Class cla = p.getClass();
                    if(cla == Predateurs.class){
                        Lagune.grille[Lagune.grille.length] = new Predateurs(numero_poisson, nom_poisson, poids_poisson, age_poisson, position_poisson, vivacite_proie)
                    

                    }
                }
            }
        }
    }

    @Override
    public String toString() {
    }

    public static void setPREDATOR_CLONE_TIME(Integer PREDATOR_CLONE_TIME) {
        Predateurs.PREDATOR_CLONE_TIME = PREDATOR_CLONE_TIME;
    }

    public static Integer getPREDATOR_CLONE_TIME() {
        return PREDATOR_CLONE_TIME;
    }

    public static void setBITE_FACTOR(Integer BITE_FACTOR) {
        Predateurs.BITE_FACTOR = BITE_FACTOR;
    }

    public static Integer getBITE_FACTOR() {
        return BITE_FACTOR;
    }
}
