package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlleSaucenTest {
    private AlleSaucen alleSaucen;
    private Sauce tomaten;
    private Sauce bbq;

    @Before
    public void setUp() {
        System.out.println("Setting it up!");
        alleSaucen = new AlleSaucen();
        tomaten = new Sauce(1, "Tomatensauce", .0);
        bbq = new Sauce(2, "BBQ-Sauce", .0);
    }

    @Test
    public void checkContent() {
        System.out.println("Checking content");
        assertEquals(tomaten.getId(), alleSaucen.getListe().get(0).getId());
        assertEquals(tomaten.getName(), alleSaucen.getListe().get(0).getName());
        assertEquals(tomaten.getPreis(), alleSaucen.getListe().get(0).getPreis(), .001);
        assertEquals(bbq.getId(), alleSaucen.getListe().get(1).getId());
        assertEquals(bbq.getName(), alleSaucen.getListe().get(1).getName());
        assertEquals(bbq.getPreis(), alleSaucen.getListe().get(1).getPreis(), .001);
    }

    @After
    public void tearDown() {
        System.out.println("Tearing it down!");
        alleSaucen = null;
        tomaten = null;
        bbq = null;
        assertNull(alleSaucen);
        assertNull(tomaten);
        assertNull(bbq);
    }
}