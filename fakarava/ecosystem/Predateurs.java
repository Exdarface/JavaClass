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
        // TODO : Finir la méthode
        for (Case c : Lagune.grille) {
            if(c.getIs_passe()){
                Poissons[] temp = c.getContenu();
                double poids = 0;
                int index_predator = 0;
                for (int i = 0; i < temp.length; i++) {
                    if(temp[i].getClass() == Predateurs.class && temp[i].getPoids_poisson() > poids){
                        poids = temp[i].getPoids_poisson();
                        index_predator = i;
                    }
                }
                int index_prey = 0;
                int viv = 999;
                for(int j = 0; j< temp.length; j++){

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
        // Ne fait rien, mais import obligatoire
    }

    
}
