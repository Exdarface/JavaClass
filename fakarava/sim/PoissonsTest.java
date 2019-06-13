package fakarava.sim;

import fakarava.control.Fakarava;

import fakarava.ecosystem.Point;
import fakarava.ecosystem.Predateurs;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PoissonsTest {
    Predateurs p = new Predateurs("Requin-Marteau",80.0,new Point(1,2));
    int biteFactor = 10,
    maxCurrentStrength = 20,
    maxDensity = 12,
    n = 5,
    predatorCloneTime = 8,
    preyCloneTime = 3;
    
    @Before
    public void setUp(){
        Fakarava.init(biteFactor, maxCurrentStrength, maxDensity, n, predatorCloneTime,
        preyCloneTime, null);
        
    }
    
    @Test
    public void getNumero_poissontest(){
        assertEquals(1,(int)p.getNumero_poisson());
    }
    
    @Test
    public void se_deplacetest(){
        assertEquals(1,(int)p.se_deplace());
    }
}
