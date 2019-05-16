package fakarava.ecosystem;

import java.awt.Point;


public class Proies extends Poissons {
    public Proies() {

        String[] espece = {"Vieille","Anguille","Dauphin","Esturgon","Dorade","Mérou","Loche","Raie","Truite"};
    }
    public Proies(double poids_poisson,Point position_poisson,Integer vivacite_proie) {
        // TODO Implement this method
        super(poids_poisson,position_poisson);
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
        if(unite_temps/PREY_CLONE_TIME ==1){
            for (Case c : Lagune.grille) {
                for (Poissons p : c.getContenu()) {
                    Class cla = p.getClass();
                    if(cla == Proies.class){
                        c.addContenu(new Proies(p.getPoids_poisson(),p.getPosition_poisson()));
                    }
                }
            }
        }
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
