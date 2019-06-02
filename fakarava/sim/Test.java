package fakarava.sim;

import fakarava.control.Fakarava;

import fakarava.ecosystem.Lagune;
import fakarava.ecosystem.Point;
import fakarava.ecosystem.Proies;

public class Test {
    public static void main(String[] args) {
        int biteFactor = 10,
        maxCurrentStrength = 20,
        maxDensity = 3,
        n = 5,
        predatorCloneTime = 10,
        preyCloneTime = 5;
        Fakarava.init(biteFactor, maxCurrentStrength, maxDensity, n, predatorCloneTime,
        preyCloneTime, null);
        System.out.println(Lagune.grille.get(14).getContenu().add(new Proies("Merou",1.0,new Point(1,2),99)));
    }
}
