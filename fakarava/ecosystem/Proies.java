package fakarava.ecosystem;

// TODO : COMMENTARY
public class Proies extends Poissons {
    /**
     * @attribute
     */
    private Integer vivacite_proie;

    /**
     * @attribute
     */
    private static Integer PREY_CLONE_TIME;

    // Constructeurs :
    public Proies(double poids_poisson,Point position_poisson,Integer vivacite_proie) {
        super(poids_poisson,position_poisson);
        this.vivacite_proie = vivacite_proie;
        String[] espece = {"Vieille","Anguille","Dauphin","Esturgon","Dorade","Mérou","Loche","Raie","Truite"};
        this.setNom_poisson(espece[rn.nextInt(5)]);
    }

    // Méthodes d'instance : 
    public void setVivacite_proie(Integer vivacite_proie) {
        this.vivacite_proie = vivacite_proie;
    }

    public Integer getVivacite_proie() {
        return vivacite_proie;
    }

    @Override
    public String toString() {
        return this.getNumero_poisson()+":"+this.getClass().toString()+","+this.getNom_poisson()+","+
            this.getAge_poisson()+","+this.getPoids_poisson()+","+this.getPosition_poisson();
    }

    // Méthodes de classe : 
    public static void se_reproduit() {

        if(unite_temps/PREY_CLONE_TIME ==1){
            for (Case c : Lagune.grille) {
                for (Poissons p : c.getContenu()) {
                    if(p.getClass() == Proies.class){
                        c.addContenu(new Proies(p.getPoids_poisson(),p.getPosition_poisson(),rn.nextInt(15)+1));
                    }
                }
            }
        }
    }

    public static void setPREY_CLONE_TIME(Integer PREY_CLONE_TIME) {
        Proies.PREY_CLONE_TIME = PREY_CLONE_TIME;
    }

    public static Integer getPREY_CLONE_TIME() {
        return PREY_CLONE_TIME;
    }

    // Méthodes implémentées : 
    @Override
    public void ticktock() {
        if (unite_temps%2 != 0 && this.getClass() == Proies.class) {
            this.setVivacite_proie(this.vivacite_proie/2);
        }
        if (unite_temps%2 ==0 && this.getClass() == Proies.class && unite_temps != 0){
            this.setVivacite_proie(this.vivacite_proie*2);
        }
    }
}
