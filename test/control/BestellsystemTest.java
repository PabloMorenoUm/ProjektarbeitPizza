package control;

import model.AlleZutaten;
import model.Pizza;
import model.Zutat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BestellsystemTest {

    private final AlleZutaten alleZutaten = new AlleZutaten();
    private ArrayList<Zutat> zutaten1;
    private ArrayList<Zutat> zutaten2;
    private Pizza pizza1;
    private Pizza pizza2;
    ArrayList<Pizza> pizzen;

    @Before
    public void setUp() {
        System.out.println("Setting Up");
        pizza1 = new Pizza();
        zutaten1 = new ArrayList<>();
        pizza2 = new Pizza();
        zutaten2 = new ArrayList<>();
        pizzen = new ArrayList<>();

    }

    @After
    public void tearDown() {
        System.out.println("Tearing down");
        pizza1 = null;
        zutaten1 = null;
        pizza2 = null;
        zutaten2 = null;
        pizzen = null;
        assertNull(pizza1);
        assertNull(zutaten1);
        assertNull(pizza2);
        assertNull(zutaten2);
        assertNull(pizzen);

    }

    @Test
    public void checkPreis() {
        System.out.println("running checkPreis");
        zutaten1.add((Zutat) alleZutaten.getListe().get(0));
        zutaten1.add((Zutat) alleZutaten.getListe().get(1));
        pizza1.updateZutaten(zutaten1);
        assertEquals(4.99 + 0.99 + 0.99, pizza1.getPreis(), .001);

    }

    @Test
    public void zahlen() {
        System.out.println("running zahlen");
        Bestellsystem bestellsystem = new Bestellsystem();

        zutaten1.add((Zutat) alleZutaten.getListe().get(1));
        zutaten1.add((Zutat) alleZutaten.getListe().get(2));
        pizza1.updateZutaten(zutaten1);

        zutaten2.add((Zutat) alleZutaten.getListe().get(3));
        zutaten2.add((Zutat) alleZutaten.getListe().get(5));
        zutaten2.add((Zutat) alleZutaten.getListe().get(6));
        pizza2.updateZutaten(zutaten2);

        pizzen.add(pizza1);
        pizzen.add(pizza2);

        assertEquals(4.99 + 0.99 + 1.39 + 4.99 + 1.39 + 0.59 + 0.59, bestellsystem.zahlen(pizzen), .001);

    }
}