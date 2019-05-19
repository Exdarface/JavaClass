package fakarava.control;
import java.util.Random;

import fakarava.ecosystem.*;

public class Fakarava {
    // Champs :
    private static boolean isDay= true;
    public static boolean end = false;
    
    // Méthodes de classe :
    public static void init( int biteFactor, int maxCurrentStrength, int maxDensity,int n, int predatorCloneTime, int preyCloneTime, Long seed){
        Predateurs.setBITE_FACTOR(biteFactor);
        Lagune.setMAX_CURRENT_STRENGTH(maxCurrentStrength);
        Lagune.setMAX_DENSITY(maxDensity);
        Lagune.setN(n);
        Predateurs.setPREDATOR_CLONE_TIME(predatorCloneTime);
        Proies.setPREY_CLONE_TIME(preyCloneTime);
        Lagune.creer_grille();
        Random rn = new Random(seed);
        Fakarava.end = true;

    }
    
    public static int createPredator(String name, double weight, int x, int y){
        int new_preda = new Predateurs(name, weight, new Point(x,y)).getNumero_poisson();
        return new_preda;
    }
    
    public static int createPrey(String name, int weight, int x, int y, int dayVivacity){
        int new_prey = new Proies(name, weight, new Point(x,y), dayVivacity).getNumero_poisson();
        return new_prey;
    }
    public static int createFishWay(int x, int y){
        if ((y > 0 && y < Lagune.getN()-1) && (x == 0 || x == Lagune.getN()-1)) {
            for (Case c : Lagune.grille) {
                if(Case.get_case(new Point(c.getX(),c.getY())) == x*Lagune.getN()+y)
                    Lagune.grille[x*Lagune.getN()+y].setIs_passe(true);
            }
            return 1;
        }
        if(y == 0 || y == Lagune.getN()){
            for (Case c : Lagune.grille) {
                if(Case.get_case(new Point(c.getX(),c.getY())) == x*Lagune.getN()+y)
                    Lagune.grille[x*Lagune.getN()+y].setIs_passe(true);
            }
            return 1;
        }
        
        return 0;
    }

    public static int createDiver(String name, String labo){
        int new_diver = new Plongeurs(name, labo).getId_plongeur();
        return new_diver;
    }

    public static void deleteDiver(int diver){
        // TODO : Finir la méthode
        
    }

    public static void putCamera(int diver, int fishway){
        // TODO : Finir la méthode

    }

    public static void putTransmitters(int diver, int fishway){
        // TODO : Finir la méthode

    }
    
    public static void clockForward(){
        Poissons.unite_temps++;
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
        for (Case c : Lagune.grille) {
            for (Poissons p : c.getContenu()) {
                p.se_deplace();
            }
        }
        if(Fakarava.isDay = true){
            Fakarava.isDay = false;
            Predateurs.chasse();
        }
        else{
            Fakarava.isDay = true;
        }
        Poissons[] list_Poissons = {};
        for (Case c : Lagune.grille) {
            for (Poissons p : c.getContenu()) {
                list_Poissons[list_Poissons.length] = p;
            }
        }
        if(Lagune.getMAX_DENSITY() < list_Poissons.length){
            Fakarava.end = true;
        }
    }

    public static String[] spyReport(){
        // TODO : Finir la méthode
        String[] string = {};
        return string;
    }
}
