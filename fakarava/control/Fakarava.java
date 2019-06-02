package fakarava.control;

import fakarava.ecosystem.Camera;
import fakarava.ecosystem.Case;
import fakarava.ecosystem.Emetteur;
import fakarava.ecosystem.Lagune;
import fakarava.ecosystem.Plongeurs;
import fakarava.ecosystem.Point;
import fakarava.ecosystem.Poissons;
import fakarava.ecosystem.Predateurs;
import fakarava.ecosystem.Proies;

import java.util.ArrayList;

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
        Lagune.setRn(fakarava.ecosystem.Random.getARandom());
        Fakarava.end = false;

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
        Lagune.grille.get(emplacement).getContenu().add((Poissons)preda);
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
        Lagune.grille.get(emplacement).getContenu().add((Poissons)prey);
        int new_prey = prey.getNumero_poisson();
        return new_prey;
    }

    /**
     * Creation d'une passe
     * @param x coordonnée x de la Case se transformant en passe
     * @param y coordonnée y de la Case se transformant en passe
     * @return La position absolue dans la grille de la Lagune
     */
    public static int createFishway(int x, int y){
        if ((y > 0 && y < Lagune.getN()-1) && (x == 0 || x == Lagune.getN()-1)) {
            for (Case c : Lagune.grille) {
                if(Case.getCase(new Point(c.getX(),c.getY())) == x*Lagune.getN()+y)
                Lagune.grille.get(x*Lagune.getN()+y).setIs_passe(true);
            }
        }
        if(y == 0 || y == Lagune.getN()){
            for (Case c : Lagune.grille) {
                if(Case.getCase(new Point(c.getX(),c.getY())) == x*Lagune.getN()+y)
                Lagune.grille.get(x*Lagune.getN()+y).setIs_passe(true);
            }
        }
        return x*Lagune.getN()+y;
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
                Camera.getAll_camera().remove(c);
            }
        }
        for(Emetteur e : Emetteur.getAll_emetteur()){
            if(e.getId_plongeur_assos() == diver){
                Emetteur.getAll_emetteur().remove(e);
            }
        }
    }

    public static void putCamera(int diver, int fishway){
        new Camera(new Point(fishway/Lagune.getN(),fishway%Lagune.getN()),diver);
    }

    public static void putTransmitters(int diver, int fishway){
        for (Case c : Lagune.grille) {
            if(Case.getCase(new Point(c.getX(),c.getY())) == fishway){
                for (Poissons p : c.getContenu()) {
                    if(p.getClass() == Predateurs.class){
                        new Emetteur(((Predateurs)p), diver);
                    }
                }
            }
        }

    }
    /**
     * augmente les pendules chronobiologiques des Poissons
     */
    public static void clockForward(){
        Poissons.setUnite_temps(Poissons.getUnite_temps()+1);
        for (Case c : Lagune.grille) {
            for (Poissons p : c.getContenu()) {
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
        ArrayList<Proies> list_prey = new ArrayList<Proies>();
        for (Case c : Lagune.grille) {
            for (Poissons p : c.getContenu()) {
                if(p.getClass() == Proies.class){
                    list_prey.add((Proies)p);
                }
            }
        }
        if(list_prey.size() == 0){
            Fakarava.end = true;
        }
    }

    public static String[] spyReport(){
        // TODO : Finir la méthode
        String[] string = {};
        return string;
    }
}
