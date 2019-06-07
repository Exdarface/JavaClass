package fakarava.sim;

import fakarava.control.Fakarava;

import fakarava.ecosystem.Case;
import fakarava.ecosystem.Lagune;
import fakarava.ecosystem.Point;
import fakarava.ecosystem.Poissons;
import fakarava.ecosystem.Predateurs;

import java.util.ArrayList;

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
        int req = Fakarava.createPredator("Requin-Marteau",80.0,0,0);
        int req2 = Fakarava.createPredator("Requin-Loup", 80.0, 0, 0);
        Case.getCasec(new Point(0,0)).setIs_passe(true);
        Predateurs.chasse();
        ArrayList<Poissons> res = new ArrayList<Poissons>();
        for(Case c : Lagune.getGrille()){
            for(Poissons p : c.getContenu()){
                res.add(p);
            }
        }
        System.out.println(res.toString());
    }
}
