package fakarava.ecosystem;

import java.util.ArrayList;


public class Proies extends Poissons{
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

    // Methodes d'instance : 

    /**
     * Transforme la vivacite de la Proie pointee
     * @param vivacite_proie nouvelle vivacite de la Proie
     */
    public void setVivacite_proie(Integer vivacite_proie) {
        this.vivacite_proie = vivacite_proie;
    }

    /**
     * Recupere la vivacite de la Proie pointee
     * @return vivacite de la Proie pointee
     */
    public Integer getVivacite_proie() {
        return vivacite_proie;
    }

    /**
     * Donne toutes les informations de la Proie pointee
     * @returnles informations de la Proie pointee
     */
    @Override
    public String toString() {
        return this.getNumero_poisson()+":"+"Proies"+","+this.getNom_poisson()+","+
            this.getAge_poisson()+","+this.getPoids_poisson()+","+this.getPosition_poisson();
    }

    // Methodes de classe : 

    /**
     * Reproduit toutes les Proies de la Lagune et les ajoutent au contenu de la Case
     */
    public static void se_reproduitprey() {
        if(unite_temps%PREY_CLONE_TIME == 0){
            for (Case c : Lagune.getGrille()) {
                if(c.getContenu().size() != 0){
                    ArrayList<Proies> added = new ArrayList<Proies>();
                    for(int i = 0;i<c.getContenu().size();i++) {
                        if(c.getContenu().get(i).getClass() == Proies.class){
                            added.add(new Proies(c.getContenu().get(i).getNom_poisson(),
                                                          c.getContenu().get(i).getPoids_poisson(),
                                                          c.getContenu().get(i).getPosition_poisson(),
                                                          ((Proies)c.getContenu().get(i)).getVivacite_proie()));
                        }
                    }
                    while(added.size() !=0){
                        c.getContenu().add(added.get(0));
                        added.remove(0);
                    }
                }
            }
            System.out.println("Les Proies se sont reproduits.");
        }
    }

    /**
     * Transforme le delai de reproduction des Proies de la Lagune
     * @param PREY_CLONE_TIME delai de reproduction des Proies de la Lagune
     */
    public static void setPREY_CLONE_TIME(Integer PREY_CLONE_TIME) {
        Proies.PREY_CLONE_TIME = PREY_CLONE_TIME;
    }

    /**
     * Recupere le delai de reproduction des Proies de la Lagune
     * @return le delai de reproduction des Proies de la Lagune
     */
    public static Integer getPREY_CLONE_TIME() {
        return PREY_CLONE_TIME;
    }

    // Methodes implementees : 

    /**
     * Adapte la vivacite des Proies suivant l'etat de la journee (jour ou nuit)
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
