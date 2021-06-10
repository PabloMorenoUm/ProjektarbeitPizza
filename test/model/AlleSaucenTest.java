package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AlleSaucenTest {
    private AlleSaucen actualSaucen;
    private ArrayList<Sauce> expectedSaucen;

    @Before
    public void setUp() {
        System.out.println("Setting it up!");
        actualSaucen = new AlleSaucen();
        expectedSaucen = new ArrayList<>();
        expectedSaucen.add(new Sauce(1, "Tomatensauce", .0));
        expectedSaucen.add(new Sauce(2, "BBQ-Sauce", .0));
    }

    @Test
    public void checkContent() {
        System.out.println("Checking content");
        actualSaucen.getListe().forEach(s -> {
            System.out.println(" Checking id of " + s.getName());
            assertEquals(expectedSaucen.get(s.getId() - 1).getId(), s.getId());
        });
        actualSaucen.getListe().forEach(s -> {
            System.out.println(" Checking name of " + s.getName());
            assertEquals(expectedSaucen.get(s.getId() - 1).getName(), s.getName());
        });
        actualSaucen.getListe().forEach(s -> {
            System.out.println(" Checking price of " + s.getName());
            assertEquals(expectedSaucen.get(s.getId() - 1).getPreis(), s.getPreis(), .001);
        });
    }

    @Test
    public void checkId() {
        System.out.println("Checking id < 10");
        actualSaucen.getListe().forEach(s -> {
            System.out.println(" " + s.getName());
            assertTrue(s.getId() < 10);
        });
    }

    @Test
    public void checkPreis() {
        System.out.println("Checking price = 0");
        actualSaucen.getListe().forEach(s -> {
            System.out.println(" " + s.getName());
            assertEquals(.0, s.getPreis(), .001);
        });
    }

    @After
    public void tearDown() {
        System.out.println("Tearing it down!");
        actualSaucen = null;
        expectedSaucen = null;
        assertNull(actualSaucen);
        assertNull(expectedSaucen);
    }
}