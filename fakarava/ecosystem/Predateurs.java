package fakarava.ecosystem;

import java.util.ArrayList;

public class Predateurs extends Poissons{
    /**
     * @attribute
     */
    private static Integer PREDATOR_CLONE_TIME;

    /**
     * @attribute
     */
    private static Integer BITE_FACTOR;

    // Constructeurs :

    public Predateurs(String nom,double poids_poisson,Point position_poisson) {
        super(nom,poids_poisson,position_poisson);
    }

    //Méthodes d'Instances : 

    /**
     * Donne toutes les informations du Predateurs pointé
     */
    @Override
    public String toString() {
        return "Predateurs"+this.getNumero_poisson()+":"+this.getNom_poisson()+","+
            this.getAge_poisson()+","+this.getPoids_poisson()+","+this.getPosition_poisson();
    }

    //Methodes de classe :

    /**
     * Fait chasser tous les Predateurs de la Lagune
     */
    public static void chasse() {
        for (Case c : Lagune.getGrille()) {
            if(c.getIs_passe()){ // Si la case est une passe
                System.out.println("La chasse commence!");
                ArrayList<Predateurs> list_pred = new ArrayList<Predateurs>();
                ArrayList<Proies> list_prey = new ArrayList<Proies>();
                // Remplissage d'un tableau de Predateurs et de Proies de c
                for (Poissons p : c.getContenu()) {
                    if (p.getClass() == Predateurs.class) {
                        list_pred.add((Predateurs)p);
                    }
                    if(p.getClass() == Proies.class){
                        list_prey.add((Proies)p);
                    }
                }
                if(list_pred.size()==0 || list_prey.size() == 0){
                    break;
                }
                for (int k = 0; k < list_pred.size();k++) { // Pour tous les Predateurs présents
                    if(list_pred.size()==0 || list_prey.size() == 0){
                        break;
                    }
                    double poids_predator = list_pred.get(0).getPoids_poisson();
                    int index_predator = 0;
                    // Récupération du Predateurs le plus gros
                    for (int i =0; i < list_pred.size(); i++) {
                        if(list_pred.get(i).getPoids_poisson() > poids_predator){
                            poids_predator = list_pred.get(i).getPoids_poisson();
                            index_predator = i;
                        }
                    }
                    int viv = list_prey.get(0).getVivacite_proie();
                    int index_prey = 0;
                    // Récupération de la Proies la moins vivace
                    for (int j = 0; j < list_prey.size(); j++) {
                        if(list_prey.get(j).getVivacite_proie() < viv){
                            viv = list_prey.get(j).getVivacite_proie();
                            index_prey = j;
                        }
                    }
                    double surva = Math.max(0,(list_prey.get(index_prey).getVivacite_proie()/list_pred.get(index_predator).getPoids_poisson())
                                              - ((double)(Lagune.getMAX_CURRENT_STRENGTH()/Lagune.getNb_passe())/100) );
                    // Calcul de la survie
                    if (Lagune.getRn().selection(surva)) {
                        // Création de la liste des AUTRES Predateurs
                        System.out.println("L'attaque a �chou�");
                        ArrayList<Predateurs> list_mordu = new ArrayList<Predateurs>();
                        for(int i =0;i<list_pred.size();i++){
                            if(i!=index_predator) // Si ce n'est pas celui attaqué
                                list_mordu.add(list_pred.get(i));
                        
                        }
                        if(list_mordu.size() == 0)
                            break;
                        int index_mordre =Lagune.getRn().who(list_mordu.size()); // Attaque aléatoire
                        System.out.println("Predateur attaqu� : "+list_mordu.get(index_mordre).toString());
                        double q = list_mordu.get(index_mordre).getPoids_poisson()/BITE_FACTOR; // Dégats de l'attaque
                        // Mort du Predateurs si son poids est inférieur à q
                        if (list_mordu.get(index_mordre).getPoids_poisson() - q <= 0) {
                            c.getContenu().remove(list_mordu.get(index_mordre));
                            list_pred.remove(list_mordu.get(index_mordre));
                            System.out.println("Le Predateur "+list_mordu.get(index_mordre).getNumero_poisson()+"est mort");
                        }
                        // Perte de poids du Predateurs si son poids est supérieur à q
                        else{
                            list_mordu.get(index_mordre).setPoids_poisson(list_mordu.get(index_mordre).getPoids_poisson()-q);
                            System.out.println("Le Predateur "+list_mordu.get(index_mordre).getNumero_poisson()+"a perdu du poids");
                        }
                    }
                    // Mort de la Proie
                    else{
                        System.out.println("L'attaque a r�ussi");
                        System.out.println("La Proie"+list_pred.get(index_predator).getNumero_poisson()+"est morte");
                        list_pred.get(index_predator).setPoids_poisson(list_pred.get(index_predator).getPoids_poisson()+list_prey.get(index_prey).getPoids_poisson());
                        Proies kprey = list_prey.get(index_prey);
                        c.getContenu().remove(kprey);
                        list_prey.remove(kprey);
                    }
                }
                // Mise à jour des Poissons présents dans la Case en fin de chasse
                ArrayList<Poissons> list_final = new ArrayList<Poissons>();
                for (Predateurs p : list_pred) {
                    list_final.add((Poissons)p);
                }
                for (Proies p : list_prey) {
                    list_final.add((Poissons)p);
                }
                System.out.println("La Chasse du jour est finie.");
            }
        }
    }
    
    /**
     * Fait se reproduire par clonage tous les Predateurs de la Lagune
     */
    public static void se_reproduitpred() {
        if(unite_temps%PREDATOR_CLONE_TIME ==0){
            for (Case c : Lagune.getGrille()) {
                ArrayList<Predateurs> added = new ArrayList<Predateurs>();
                for (Poissons p : c.getContenu()) {
                    if(p.getClass() == Predateurs.class){
                        added.add(new Predateurs(p.getNom_poisson(),p.getPoids_poisson(),p.getPosition_poisson()));
                    }
                }
                while(added.size() !=0){
                    c.getContenu().add(added.get(0));
                    added.remove(0);
                }
            }
            System.out.println("Les Predateurs se sont reproduits");
        }
    }

    /**
     * Transforme le délai de reproduction des Predateurs
     * @param PREDATOR_CLONE_TIME nouveau délai de reproduction
     */
    public static void setPREDATOR_CLONE_TIME(Integer PREDATOR_CLONE_TIME) {
        Predateurs.PREDATOR_CLONE_TIME = PREDATOR_CLONE_TIME;
    }

    /**
     * Récupère le délai de reproduction des Predateurs
     * @return délai de reproduction des Predateurs
     */
    public static Integer getPREDATOR_CLONE_TIME() {
        return PREDATOR_CLONE_TIME;
    }

    /**
     * Transforme la puissance de la morsure des Predateurs
     * @param BITE_FACTOR nouvelle puissance de la morsure des Predateurs
     */
    public static void setBITE_FACTOR(Integer BITE_FACTOR) {
        Predateurs.BITE_FACTOR = BITE_FACTOR;
    }

    /**
     * Récupère la puissance de la morsure des Predateurs
     * @return puissance de la morsure des Predateurs
     */
    public static Integer getBITE_FACTOR() {
        return BITE_FACTOR;
    }

    // Méthodes implémentées :

    /**
     * Réduit le poids de 1 du Prédateur pointé
     */
    @Override
    public void ticktock() {
        this.setPoids_poisson(this.getPoids_poisson()-1); // Réduire le poids
                    if(this.getPoids_poisson() == 0){// Tuer si son poids atteint 0
                        for (Case c : Lagune.getGrille()) {
                            if(c.getX() == this.getPosition_poisson().getX() && c.getY() == this.getPosition_poisson().getY()){
                                c.getContenu().remove(this); // Tuer en l'enlevant de la liste de la Case
                            }
                        }
                    }
    }

    
}
