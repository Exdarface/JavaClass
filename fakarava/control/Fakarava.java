package fakarava.control;
import fakarava.ecosystem;

public class Fakarava {
    // Champs :
    private static boolean isDay;
    public static boolean end;
    
    // M�thodes de classe :
    public static void init( int biteFactor, int maxCurrentStrength, int maxDensity,int n, int predatorCloneTime, int preyCloneTime, Long seed){
        Predateurs.setBITE_FACTOR(biteFactor);
        Lagune.setMAX_CURRENT_STRENGTH(maxCurrentStrength);
        Lagune.setMAX_DENSITY(maxDensity);
        Lagune.setN(n);
        Predateurs.setPREDATOR_CLONE_TIME(predatorCloneTime);
        Proies.setPREY_CLONE_TIME(preyCloneTime);

    }
    
    public static int createPredator(String name, double weight, int x, int y){
        return 0;
    }
    
    public static int createPrey(String name, int weight, int x, int y, int dayVivacity){
        return 0;
    }
    public static int createFishWay(int x, int y){
        return 0;
    }

    public static int createDiver(String name, String labo){
        return 0;
    }

    public static void deleteDiver(int diver){
        
    }

    public static void putCamera(int diver, int fishway){

    }

    public static void putTransmitters(int diver, int fishway){

    }
    
    public static void clockForward(){

    }

    public static String[] spyReport(){
        String string;
        return string;
    }
}
