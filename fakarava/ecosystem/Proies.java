package fakarava.ecosystem;

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
    public Proies(String nom,double poids_poisson,Point position_poisson,Integer vivacite_proie) {
        super(nom,poids_poisson,position_poisson);
        this.vivacite_proie = vivacite_proie;
    }

    // Méthodes d'instance : 

    /**
     * Transforme la vivacité de la Proie pointée
     * @param vivacite_proie nouvelle vivacité de la Proie
     */
    public void setVivacite_proie(Integer vivacite_proie) {
        this.vivacite_proie = vivacite_proie;
    }

    /**
     * Récupère la vivacité de la Proie pointée
     * @return vivacité de la Proie pointée
     */
    public Integer getVivacite_proie() {
        return vivacite_proie;
    }

    /**
     * Donne toutes les informations de la Proie pointée
     */
    @Override
    public String toString() {
        return this.getNumero_poisson()+":"+this.getClass().toString()+","+this.getNom_poisson()+","+
            this.getAge_poisson()+","+this.getPoids_poisson()+","+this.getPosition_poisson();
    }

    // Méthodes de classe : 

    /**
     * Reproduit toutes les Proies de la Lagune et les ajoute au contenu de la Case
     */
    public static void se_reproduitprey() {

        if(unite_temps%PREY_CLONE_TIME == 0){
            for (Case c : Lagune.grille) {
                for (Poissons p : c.getContenu()) {
                    if(p.getClass() == Proies.class){
                        c.addContenu(new Proies(p.getNom_poisson(),p.getPoids_poisson(),p.getPosition_poisson(),rn.nextInt(99)+1));
                    }
                }
            }
        }
    }

    /**
     * Transforme le délai de reproduction des Proies de la Lagune
     * @param PREY_CLONE_TIME délai de reproduction des Proies de la Lagune
     */
    public static void setPREY_CLONE_TIME(Integer PREY_CLONE_TIME) {
        Proies.PREY_CLONE_TIME = PREY_CLONE_TIME;
    }

    /**
     * Récupère le délai de reproduction des Proies de la Lagune
     * @return le délai de reproduction des Proies de la Lagune
     */
    public static Integer getPREY_CLONE_TIME() {
        return PREY_CLONE_TIME;
    }

    // Méthodes implémentées : 

    /**
     * Adapte la vivacité des Proies suivant l'état de la journée (jour ou nuit)
     */
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
