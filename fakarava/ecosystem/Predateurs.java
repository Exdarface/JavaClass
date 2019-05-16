package fakarava.ecosystem;

import java.awt.Point;


public class Predateurs extends Poissons {
    public Predateurs(double poids_poisson,Point position_poisson) {
        // TODO Implement this method
        super(poids_poisson,position_poisson);
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

    public static void se_reproduit() {
        if(unite_temps/PREDATOR_CLONE_TIME ==1){
            for (Case c : Lagune.grille) {
                for (Poissons p : c.getContenu()) {
                    Class cla = p.getClass();
                    if(cla == Predateurs.class){
                        c.addContenu(new Predateurs(p.getPoids_poisson(),p.getPosition_poisson()));
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
