package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

    World world = new World();

    Enemy hilichurl = new Enemy("Hilichurl", 1);
    Enemy ruinGuardian = new Enemy("Ruin Guardian", 2);
    Enemy oceanid = new Enemy("Oceanid", 3);
    Enemy signora = new Enemy("Signora", 4);

    Reward mora = new Reward("Mora", 3);
    Reward primogem = new Reward("Primogem", 5);

    /**
     * Check that the observers correctly update itself based on the level of the world
     * that they observe, and also check if a world can add and remove observers
     */
    @Test
    void observerTest(){
        world.addObserver(hilichurl);
        world.addObserver(ruinGuardian);
        world.addObserver(oceanid);
        world.addObserver(signora);

        world.addObserver(mora);
        world.addObserver(primogem);

        assertEquals(4, hilichurl.getLevel());
        assertEquals(8, ruinGuardian.getLevel());
        assertEquals(12, oceanid.getLevel());
        assertEquals(16, signora.getLevel());

        assertEquals(3, mora.getQuantity());
        assertEquals(2, primogem.getQuantity());

        world.setLevel(5);

        assertEquals(20, hilichurl.getLevel());
        assertEquals(40, ruinGuardian.getLevel());
        assertEquals(60, oceanid.getLevel());
        assertEquals(80, signora.getLevel());

        assertEquals(17, mora.getQuantity());
        assertEquals(10, primogem.getQuantity());

        world.removeObserver(signora);

        world.setLevel(1);

        assertEquals(4, hilichurl.getLevel());
        assertEquals(8, ruinGuardian.getLevel());
        assertEquals(12, oceanid.getLevel());
        assertEquals(80, signora.getLevel());

        assertEquals(3, mora.getQuantity());
        assertEquals(2, primogem.getQuantity());
    }
}