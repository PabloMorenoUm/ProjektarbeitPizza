package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Testklasse, ob der Datensatz der Zutaten korrekt eingelesen ist.
 */
public class AlleZutatenTest {
    private AlleZutaten actualZutaten;
    private ArrayList<Zutat> expectedZutaten;

    @Before
    public void setUp() {
        System.out.println("Setting it up!");
        actualZutaten = new AlleZutaten();
        expectedZutaten = new ArrayList<>();
        expectedZutaten.add(new Zutat(11, "Gouda", .99));
        expectedZutaten.add(new Zutat(12, "Mozzarella", .99));
        expectedZutaten.add(new Zutat(13, "Salami", 1.39));
        expectedZutaten.add(new Zutat(14, "Schinken", 1.39));
        expectedZutaten.add(new Zutat(15, "Thunfisch", .99));
        expectedZutaten.add(new Zutat(16, "Peperoni", .59));
        expectedZutaten.add(new Zutat(17, "Ananas", .59));
        expectedZutaten.add(new Zutat(18, "Mais", .59));
        expectedZutaten.add(new Zutat(19, "Zwiebeln", .59));
        expectedZutaten.add(new Zutat(20, "Oliven", .99));
        expectedZutaten.add(new Zutat(21, "Ei", .59));
        expectedZutaten.add(new Zutat(22, "Paprika", .59));
        expectedZutaten.add(new Zutat(23, "Tomaten", .59));
        expectedZutaten.add(new Zutat(24, "Champignons", .59));
    }

    @Test
    public void checkContent() {
        System.out.println("Checking content");
        actualZutaten.getListe().forEach(s -> {
            System.out.println(" Checking id of " + s.getName());
            assertEquals(expectedZutaten.get(s.getId() - 11).getId(), s.getId());
        });
        actualZutaten.getListe().forEach(s -> {
            System.out.println(" Checking name of " + s.getName());
            assertEquals(expectedZutaten.get(s.getId() - 11).getName(), s.getName());
        });
        actualZutaten.getListe().forEach(s -> {
            System.out.println(" Checking price of " + s.getName());
            assertEquals(expectedZutaten.get(s.getId() - 11).getPreis(), s.getPreis(), .001);
        });
    }

    @Test
    public void checkId() {
        System.out.println("Checking id > 10");
        actualZutaten.getListe().forEach(s -> {
            System.out.println(" " + s.getName());
            assertTrue(s.getId() > 10);
        });
    }

    @Test
    public void checkPreis() {
        System.out.println("Checking price > 0");
        actualZutaten.getListe().forEach(s -> {
            System.out.println(" " + s.getName());
            assertTrue(s.getPreis() > 0);
        });
    }

    @After
    public void tearDown() {
        System.out.println("Tearing it down!");
        actualZutaten = null;
        expectedZutaten = null;
        assertNull(actualZutaten);
        assertNull(expectedZutaten);
    }
}