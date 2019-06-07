package fakarava.sim;

import fakarava.control.Fakarava;

public class Simulation {
    public static void main(String[] args) {
        int biteFactor = 10,
        maxCurrentStrength = 20,
        maxDensity = 80,
        n = 3,
        predatorCloneTime = 2,
        preyCloneTime = 7;
        Fakarava.init(biteFactor, maxCurrentStrength, maxDensity, n, predatorCloneTime,
        preyCloneTime, null);
        int jojo = Fakarava.createPrey("Mérou", 3.0, 1, 1, 99);
        int lola = Fakarava.createPrey("Poisson Lune", 1.0, 0, 1, 90);
        int alfred = Fakarava.createPrey("Poisson Perroquet", 2.0, 0, 0, 51);
        int bertha = Fakarava.createPredator("Requin Marteau", 100.0, 0, 1);
        int adolphe = Fakarava.createPredator("Requin Gris", 75.0, 1, 1);
        int p1 = Fakarava.createFishway(1, 0);
        int p2 = Fakarava.createFishway(2, 1);
        int enzo = Fakarava.createDiver("Enzo", "Tahiti");
        Fakarava.clockForward();
        Fakarava.putCamera(enzo, p1);
        Fakarava.putTransmitters(enzo, p1);
        long time = 1;
        while (!Fakarava.end){
            Fakarava.clockForward();
            time++;
            //if (verbose)
                //System.out.println(Arrays.toString(Fakarava.spyReport())+"\n\n");
        }
        System.out.println(time);
    }
}
