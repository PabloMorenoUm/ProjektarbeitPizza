package model;

import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.*;

public class PizzenListTest {
    ArrayList<Zutat> zutaten;
    PizzenList pizzen = new PizzenList();
    private static final AlleZutaten alleZutaten = new AlleZutaten();
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    @Before
    public void setUp() {
        Pizza pizza1 = new Pizza();
        pizza1.setName("Pizza1");
        Pizza pizza2 = new Pizza();
        pizza2.setName("Pizza2");
        zutaten = new ArrayList<>();
        zutaten.add((Zutat) alleZutaten.getListe().get(0));
        zutaten.add((Zutat) alleZutaten.getListe().get(1));
        pizza2.setZutaten(zutaten);
        pizzen.add(pizza1);
        pizzen.add(pizza2);
    }

    @Test
    public void testToString() {
        String preis = currency.format(4.99);
        assertEquals("Pizza1\r\n Grundpreis " + preis + "\n--------------------\nPreis:" + preis +
                        "\n--------------------\n\n" + "Pizza2\r\n Grundpreis " + preis + "\r\n Gouda " +
                        currency.format(0.99) + "\r\n Mozzarella " + currency.format(0.99) +
                        "\n--------------------\nPreis:" + currency.format(4.99 + 2 * .99) +
                        "\n--------------------\n\nGesamtpreis: " + currency.format(2 * 4.99 + 2 * .99),
                pizzen.toString());
    }

    @Test
    public void zahlen() {
        assertEquals(currency.format(2 * 4.99 + 2 * .99), pizzen.zahlen());
    }
}