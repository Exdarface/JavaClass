package fakarava.sim;

import fakarava.control.Fakarava;

import fakarava.ecosystem.Case;
import fakarava.ecosystem.Lagune;
import fakarava.ecosystem.Poissons;

public class Test {
    public static void main(String[] args) {
        int biteFactor = 10,
        maxCurrentStrength = 20,
        maxDensity = 12,
        n = 2,
        predatorCloneTime = 8,
        preyCloneTime = 3;
        Fakarava.init(biteFactor, maxCurrentStrength, maxDensity, n, predatorCloneTime,
        preyCloneTime, null);
        int jojo = Fakarava.createPrey("Mérou", 3.0, 0, 0, 45);
        for(Case c : Lagune.getGrille()){
            for(Poissons p : c.getContenu()){
                System.out.println(p.getAge_poisson());
                p.ticktock();
                System.out.println(p.getAge_poisson());
            }
        }
    }
}
