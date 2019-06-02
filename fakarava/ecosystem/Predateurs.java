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
        for (Case c : Lagune.grille) {
            if(c.getIs_passe()){ // Si la case est une passe
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
                for (int k = 0; k < list_pred.size();k++) { // Pour tous les Predateurs présents
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
                    double surva = Math.max(0,list_prey.get(index_prey).getVivacite_proie()/list_pred.get(index_predator).getPoids_poisson()- (Lagune.getMAX_CURRENT_STRENGTH()/Lagune.nb_passe)/100 );
                    // Calcul de la survie
                    if (rn.selection(surva)) {
                        // Création de la liste des AUTRES Predateurs
                        ArrayList<Predateurs> list_mordu = new ArrayList<Predateurs>();
                        for(int i =0;i<list_pred.size();i++){
                            if(i!=index_predator) // Si ce n'est pas celui attaqué
                                list_mordu.add(list_pred.get(i));
                        
                        }
                        int index_mordre = rn.who(list_mordu.size()); // Attaque aléatoire
                        double q = list_mordu.get(index_mordre).getPoids_poisson()/BITE_FACTOR; // Dégats de l'attaque
                        // Mort du Predateurs si son poids est inférieur à q
                        if (list_mordu.get(index_mordre).getPoids_poisson() - q <= 0) {
                            c.getContenu().remove(list_mordu.get(index_mordre));
                            for (Poissons po : c.getContenu()) {
                                if (po.getClass() == Predateurs.class) {
                                    list_pred.add((Predateurs)po);
                                }
                            }
                        }
                        // Perte de poids du Predateurs si son poids est supérieur à q
                        else{
                            list_mordu.get(index_mordre).setPoids_poisson(list_mordu.get(index_mordre).getPoids_poisson()-q);
                        }
                    }
                    // Mort de la Proie
                    else{
                        list_pred.get(index_predator).setPoids_poisson(list_pred.get(index_predator).getPoids_poisson()+list_prey.get(index_prey).getPoids_poisson());
                        c.getContenu().remove(list_prey.get(index_prey));
                        for (Poissons p : c.getContenu()) {
                            if(p.getClass() == Proies.class){
                                list_prey.add((Proies)p);
                            }
                        }
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
                c.setContenu(list_final);
            }
        }
    }
    
    /**
     * Fait se reproduire par clonage tous les Predateurs de la Lagune
     */
    public static void se_reproduitpred() {
        if(unite_temps%PREDATOR_CLONE_TIME ==0){
            for (Case c : Lagune.grille) {
                for (Poissons p : c.getContenu()) {
                    if(p.getClass() == Predateurs.class){
                        c.getContenu().add(new Predateurs(p.getNom_poisson(),p.getPoids_poisson(),p.getPosition_poisson()));
                    }
                }
            }
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
                        for (Case c : Lagune.grille) {
                            if(c.getX() == this.getPosition_poisson().getX() && c.getY() == this.getPosition_poisson().getY()){
                                c.getContenu().remove(this); // Tuer en l'enlevant de la liste de la Case
                            }
                        }
                    }
    }

    
}
