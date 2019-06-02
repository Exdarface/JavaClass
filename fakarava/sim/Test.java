package fakarava.sim;

import fakarava.ecosystem.*;
import fakarava.control.*;
import java.util.ArrayList;

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
        int jojo = Fakarava.createPrey("Mérou", 3.0, 1, 2, 99);
        ArrayList<Proies> list_prey = new ArrayList<Proies>();
        for (Case c : Lagune.getGrille()) {
            for (Poissons p : c.getContenu()) {
                if(p.getClass() == Proies.class){
                    list_prey.add((Proies)p);
                }
            }
        }
        System.out.println(list_prey.size());
    }
}
