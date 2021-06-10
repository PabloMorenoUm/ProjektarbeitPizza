package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.*;

public class PizzenListTest {
    PizzenList pizzen = new PizzenList();
    private static final AlleZutaten alleZutaten = new AlleZutaten();
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    @Before
    public void setUp() {
        System.out.println("Setting it up!");
        // pizza1 hat keine Beläge, pizza2 schon.
        Pizza pizza1 = new Pizza();
        pizza1.setName("Pizza1");
        Pizza pizza2 = new Pizza();
        pizza2.setName("Pizza2");
        ArrayList<Zutat> zutaten = new ArrayList<>();
        zutaten.add((Zutat) alleZutaten.getListe().get(0));
        zutaten.add((Zutat) alleZutaten.getListe().get(1));
        pizza2.updateZutaten(zutaten);
        pizzen.add(pizza1);
        pizzen.add(pizza2);
    }

    @Test
    public void checkPreis() {
        assertTrue(pizzen.stream().mapToDouble(Pizza::getPreis).sum() > 0);
    }

    @Test
    public void testToString() {
        System.out.println("Running: toString");
        String preis = currency.format(4.99);
        assertEquals("Pizza1\r\n Grundpreis " + preis + "\r\n--------------------\r\nPreis: " + preis +
                        "\r\n--------------------\r\n\r\n" + "Pizza2\r\n Grundpreis " + preis + "\r\n Gouda " +
                        currency.format(0.99) + "\r\n Mozzarella " + currency.format(0.99) +
                        "\r\n--------------------\r\nPreis: " + currency.format(4.99 + 2 * .99) +
                        "\r\n--------------------\r\n\r\nGesamtpreis: " + currency.format(2 * 4.99 + 2 * .99),
                pizzen.toString());
    }

    @Test
    public void zahlen() {
        System.out.println("Running: zahlen");
        assertEquals(currency.format(2 * 4.99 + 2 * .99), pizzen.zahlen());
    }

    @After
    public void tearDown() {
        System.out.println("Tearing it down!");
        pizzen = null;
        assertNull(pizzen);
    }
}