package fakarava.sim;

import fakarava.control.Fakarava;

import fakarava.ecosystem.Plongeurs;

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
        System.out.println(new Plongeurs("Eric","Washington").getId_plongeur());
    }
}
