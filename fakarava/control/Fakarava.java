package fakarava.control;

import fakarava.ecosystem.*;

public class Fakarava {
    // Champs :
    private static boolean isDay= true;
    public static boolean end = false;
    
    // Méthodes de classe :

    /**
     * Initialise une instance d'une Lagune
     * @param biteFactor Puissance de la morsure des Predateurs
     * @param maxCurrentStrength Force du courant Maximale
     * @param maxDensity Densité de population de Poissons Maximale
     * @param n Longueur de coté de la grille de la Lagune
     * @param predatorCloneTime Délai de reproduction des Predateurs
     * @param preyCloneTime Délai de reproduction des Proies
     * @param seed graine de la simulation
     */
    public static void init( int biteFactor, int maxCurrentStrength, int maxDensity,int n, int predatorCloneTime, int preyCloneTime, Long seed){
        Predateurs.setBITE_FACTOR(biteFactor);
        Lagune.setMAX_CURRENT_STRENGTH(maxCurrentStrength);
        Lagune.setMAX_DENSITY(maxDensity);
        Lagune.setN(n);
        Predateurs.setPREDATOR_CLONE_TIME(predatorCloneTime);
        Proies.setPREY_CLONE_TIME(preyCloneTime);
        Lagune.creer_grille();
        Random rn = Random.getARandom();
        Fakarava.end = true;

    }
    
    /**
     * Creation d'un Predateurs
     * @param name nom du Predateurs
     * @param weight poids du Predateurs
     * @param x position x du Predateurs
     * @param y position y du Predateurs
     * @return numero du Predateurs
     */
    public static int createPredator(String name, double weight, int x, int y){
        Predateurs preda = new Predateurs(name,weight,new Point(x, y));
        int emplacement = Case.getCase(preda.getPosition_poisson());
        Lagune.grille[emplacement].addContenu(((Poissons)preda));
        int new_preda = preda.getNumero_poisson();
        return new_preda;
    }

    /**
     * Creation d'une Proies
     * @param name nom de la Proies
     * @param weight poids de la Proies
     * @param x position x de la Proies
     * @param y position y de la Proies
     * @param dayVivacity vivacite de la Proies de jour
     * @return numero de la Proies
     */
    public static int createPrey(String name, double weight, int x, int y, int dayVivacity){
        Proies prey = new Proies(name, weight, new Point(x,y), dayVivacity);
        int emplacement = Case.getCase(prey.getPosition_poisson());
        Lagune.grille[emplacement].addContenu(((Poissons)prey));
        int new_prey = prey.getNumero_poisson();
        return new_prey;
    }

    /**
     * Creation d'une passe
     * @param x coordonnée x de la Case se transformant en passe
     * @param y coordonnée y de la Case se transformant en passe
     * @return 1 si la passe à été crée, 0 si elle ne l'as pas été
     */
    public static int createFishway(int x, int y){
        if ((y > 0 && y < Lagune.getN()-1) && (x == 0 || x == Lagune.getN()-1)) {
            for (Case c : Lagune.grille) {
                if(Case.getCase(new Point(c.getX(),c.getY())) == x*Lagune.getN()+y)
                    Lagune.grille[x*Lagune.getN()+y].setIs_passe(true);
            }
            return 1;
        }
        if(y == 0 || y == Lagune.getN()){
            for (Case c : Lagune.grille) {
                if(Case.getCase(new Point(c.getX(),c.getY())) == x*Lagune.getN()+y)
                    Lagune.grille[x*Lagune.getN()+y].setIs_passe(true);
            }
            return 1;
        }
        return 0;
    }

    /**
     * Creation d'une passe
     * @param name nom du plongeur
     * @param labo nom du laboratoire
     * @return id du plongeur créé
     */
    public static int createDiver(String name, String labo){
        int new_diver = new Plongeurs(name, labo).getId_plongeur();
        return new_diver;
    }

    /**
     * Supprime les composants du plongeurs (Emetteur et Camera)
     * @param diver plongeur associé
     */
    public static void deleteDiver(int diver){
        for (Camera c : Camera.getAll_camera()) {
            if(c.getId_plongeur_assos() == diver){
                Camera.removeAll_camera(c);
            }
        }
        for(Emetteur e : Emetteur.getAll_emetteur()){
            if(e.getId_plongeur_assos() == diver){
                Emetteur.removeAll_emetteur(e);
            }
        }
    }

    public static void putCamera(int diver, int fishway){
        // TODO : Finir la méthode

    }

    public static void putTransmitters(int diver, int fishway){
        // TODO : Finir la méthode

    }
    /**
     * augmente les pendules chronobiologiques des Poissons
     */
    public static void clockForward(){
        Poissons.setUnite_temps(Poissons.getUnite_temps()+1);
        for (Case c : Lagune.grille) {
            for (Poissons p : c.getContenu()) {
                if(p.getClass() == Proies.class){ // Réduire ou augmenter la vivacité de chaque Proies
                    ((Proies)p).ticktock();
                }
                if(p.getClass() == Predateurs.class){ // Réduire le poids de chaque Prédateurs
                    ((Predateurs)p).ticktock();
                }
                p.ticktock();                   
            }   
        }
        Proies.se_reproduitprey();
        Predateurs.se_reproduitpred();
        for (Case c : Lagune.grille) {
            for (Poissons p : c.getContenu()) {
                p.se_deplace();
            }
        }
        if(Fakarava.isDay == true){
            Fakarava.isDay = false;
            Predateurs.chasse();
        }
        else{
            Fakarava.isDay = true;
        }
        //Itération 1 : Trop de Poissons dans la LaguneS
        if(Lagune.getMAX_DENSITY() < Poissons.getNbr_poissons()){
            Fakarava.end = true;
        }
        //Itération 2 : Plus de Proies dans la Lagune
        Proies[] list_prey = {};
        for (Case c : Lagune.grille) {
            for (Poissons p : c.getContenu()) {
                if(p.getClass() == Proies.class){
                    list_prey[list_prey.length] = ((Proies)p);
                }
            }
        }
        if(list_prey.length == 0){
            Fakarava.end = true;
        }
    }

    public static String[] spyReport(){
        // TODO : Finir la méthode
        String[] string = {};
        return string;
    }
}
