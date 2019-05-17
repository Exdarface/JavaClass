package fakarava.control;
import fakarava.ecosystem.*;

public class Fakarava {
    // Champs :
    private static boolean isDay= true;
    public static boolean end;
    
    // Méthodes de classe :
    public static void init( int biteFactor, int maxCurrentStrength, int maxDensity,int n, int predatorCloneTime, int preyCloneTime, Long seed){
        Predateurs.setBITE_FACTOR(biteFactor);
        Lagune.setMAX_CURRENT_STRENGTH(maxCurrentStrength);
        Lagune.setMAX_DENSITY(maxDensity);
        Lagune.setN(n);
        Predateurs.setPREDATOR_CLONE_TIME(predatorCloneTime);
        Proies.setPREY_CLONE_TIME(preyCloneTime);
        Lagune.creer_grille();

    }
    
    public static int createPredator(String name, double weight, int x, int y){
        // TODO : Finir la méthode
        //Predateurs.Predateurs(weight, Point.Point(x,y));
        return 0;
    }
    
    public static int createPrey(String name, int weight, int x, int y, int dayVivacity){
        // TODO : Finir la méthode
        //Proies.Proies(weight, Point.Point(x, y), dayVivacity);
        return 0;
    }
    public static int createFishWay(int x, int y){
        // TODO : Finir la méthode
        return 0;
    }

    public static int createDiver(String name, String labo){
        fakarava.ecosystem.Plongeurs.Plongeurs(name, labo);
        return 0;
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
        // TODO : Finir la méthode

    }

    public static String[] spyReport(){
        // TODO : Finir la méthode
        String[] string = {};
        return string;
    }
}
