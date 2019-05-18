package fakarava.ecosystem;

public class Predateurs extends Poissons {
    /**
     * @attribute
     */
    private static Integer PREDATOR_CLONE_TIME;

    /**
     * @attribute
     */
    private static Integer BITE_FACTOR;


    public static void chasse() {
        for (Case c : Lagune.grille) {
            if(c.getIs_passe()){
                Predateurs[] list_pred = {};
                // Remplissage d'un tableau de Predateurs de c
                for (Poissons p : c.getContenu()) {
                    if (p.getClass() == Predateurs.class) {
                        list_pred[list_pred.length] = ((Predateurs)p);
                    }
                }
                Proies[] list_prey = {};
                // Remplissage d'un tableau de Proies de c
                for (Poissons p : c.getContenu()) {
                    if(p.getClass() == Proies.class){
                        list_prey[list_prey.length] = ((Proies)p);
                    }
                }
                for (int k = 0; k < list_pred.length;k++) {
                    double poids_predator = list_pred[0].getPoids_poisson();
                    int index_predator = 0;
                    // Récupération du Predateurs le plus gros
                    for (int i =0; i < list_pred.length; i++) {
                        if(list_pred[i].getPoids_poisson() > poids_predator){
                            poids_predator = list_pred[i].getPoids_poisson();
                            index_predator = i;
                        }
                    }
                    int viv = list_prey[0].getVivacite_proie();
                    int index_prey = 0;
                    // Récupération de la Proies la moins vivace
                    for (int j = 0; j < list_prey.length; j++) {
                        if(list_prey[j].getVivacite_proie() < viv){
                            viv = list_prey[j].getVivacite_proie();
                            index_prey = j;
                        }
                    }
                    double surva = Math.max(0,list_prey[index_prey].getVivacite_proie()/list_prey[index_predator].getPoids_poisson()- Lagune.force_courant/100 );
                    // Calcul de la survie
                    if (rn.selection(surva)) {
                        // Création de la liste des AUTRES Predateurs
                        Predateurs[] list_mordu = {};
                        for(int i =0;i<list_pred.length;i++){
                            if(i!=index_predator) // Si ce n'est pas celui attaqué
                                list_mordu[list_mordu.length] = list_pred[i];
                        
                        }
                        int index_mordre = rn.who(list_mordu.length); // Attaque aléatoire
                        double q = list_pred[index_predator].getPoids_poisson()/BITE_FACTOR; // Dégats de l'attaque
                        if (list_mordu[index_mordre].getPoids_poisson() - q <= 0) {
                            c.removeContenu(list_mordu[index_mordre]);
                            for (Poissons po : temp_delete) {
                                if (po.getClass() == Predateurs.class) {
                                    list_pred[list_pred.length] = ((Predateurs)po);
                                }
                            }
                        }
                        else{
                            c.removeContenu(index_prey);
                        }
                    }
                }
            }
        }
    }

    // Constructeurs :

    public Predateurs(double poids_poisson,Point position_poisson) {
        super(poids_poisson,position_poisson);
        String[] espece = {"Requin-Tigre","Requin-Marteau","Requin-Bouledogue","Requin-taureau","Requin Blanc"};
        this.setNom_poisson(espece[rn.nextInt(5)]);
    }

    //Méthodes d'Instances : 

    @Override
    public String toString() {
        return this.getNumero_poisson()+":"+this.getClass().toString()+","+this.getNom_poisson()+","+
            this.getAge_poisson()+","+this.getPoids_poisson()+","+this.getPosition_poisson();
    }

    //Methodes de classe :

    public static void se_reproduit() {
        if(unite_temps/PREDATOR_CLONE_TIME ==1){
            for (Case c : Lagune.grille) {
                for (Poissons p : c.getContenu()) {
                    if(p.getClass() == Predateurs.class){
                        c.addContenu(new Predateurs(p.getPoids_poisson(),p.getPosition_poisson()));
                    }
                }
            }
        }
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

    // Méthodes implémentées :

    @Override
    public void ticktock() {
        for (Case c : Lagune.grille) {
            for (Poissons p : c.getContenu()) {
                if (p.getClass() == Predateurs.class) {
                    p.setPoids_poisson(p.getPoids_poisson()-1);
                }
            }
        }
    }

    
}
