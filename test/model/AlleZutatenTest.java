package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlleZutatenTest {
    private AlleZutaten alleZutaten;
    private Zutat gouda;
    private Zutat mozzarella;
    private Zutat salami;
    private Zutat schinken;
    private Zutat thunfisch;
    private Zutat peperoni;
    private Zutat ananas;
    private Zutat mais;
    private Zutat zwiebeln;
    private Zutat oliven;
    private Zutat ei;
    private Zutat paprika;
    private Zutat tomaten;
    private Zutat champignons;

    @Before
    public void setUp() {
        System.out.println("Setting it up!");
        alleZutaten = new AlleZutaten();
        gouda = new Zutat(11, "Gouda", .99);
        mozzarella = new Zutat(12, "Mozzarella", .99);
        salami = new Zutat(13, "Salami", 1.39);
        schinken = new Zutat(14, "Schinken", 1.39);
        thunfisch = new Zutat(15, "Thunfisch", .99);
        peperoni = new Zutat(16, "Peperoni", .59);
        ananas = new Zutat(17, "Ananas", .59);
        mais = new Zutat(18, "Mais", .59);
        zwiebeln = new Zutat(19, "Zwiebeln", .59);
        oliven = new Zutat(20, "Oliven", .99);
        ei = new Zutat(21, "Ei", .59);
        paprika = new Zutat(22, "Paprika", .59);
        tomaten = new Zutat(23, "Tomaten", .59);
        champignons = new Zutat(24, "Champignons", .59);
    }

    @Test
    public void checkContent() {
        System.out.println("Checking content");
        assertEquals(gouda.getId(), alleZutaten.getListe().get(0).getId());
        assertEquals(gouda.getName(), alleZutaten.getListe().get(0).getName());
        assertEquals(gouda.getPreis(), alleZutaten.getListe().get(0).getPreis(), .001);
        assertEquals(mozzarella.getId(), alleZutaten.getListe().get(1).getId());
        assertEquals(mozzarella.getName(), alleZutaten.getListe().get(1).getName());
        assertEquals(mozzarella.getPreis(), alleZutaten.getListe().get(1).getPreis(), .001);
        assertEquals(salami.getId(), alleZutaten.getListe().get(2).getId());
        assertEquals(salami.getName(), alleZutaten.getListe().get(2).getName());
        assertEquals(salami.getPreis(), alleZutaten.getListe().get(2).getPreis(), .001);
        assertEquals(schinken.getId(), alleZutaten.getListe().get(3).getId());
        assertEquals(schinken.getName(), alleZutaten.getListe().get(3).getName());
        assertEquals(schinken.getPreis(), alleZutaten.getListe().get(3).getPreis(), .001);
        assertEquals(thunfisch.getId(), alleZutaten.getListe().get(4).getId());
        assertEquals(thunfisch.getName(), alleZutaten.getListe().get(4).getName());
        assertEquals(thunfisch.getPreis(), alleZutaten.getListe().get(4).getPreis(), .001);
        assertEquals(peperoni.getId(), alleZutaten.getListe().get(5).getId());
        assertEquals(peperoni.getName(), alleZutaten.getListe().get(5).getName());
        assertEquals(peperoni.getPreis(), alleZutaten.getListe().get(5).getPreis(), .001);
        assertEquals(ananas.getId(), alleZutaten.getListe().get(6).getId());
        assertEquals(ananas.getName(), alleZutaten.getListe().get(6).getName());
        assertEquals(ananas.getPreis(), alleZutaten.getListe().get(6).getPreis(), .001);
        assertEquals(mais.getId(), alleZutaten.getListe().get(7).getId());
        assertEquals(mais.getName(), alleZutaten.getListe().get(7).getName());
        assertEquals(mais.getPreis(), alleZutaten.getListe().get(7).getPreis(), .001);
        assertEquals(zwiebeln.getId(), alleZutaten.getListe().get(8).getId());
        assertEquals(zwiebeln.getName(), alleZutaten.getListe().get(8).getName());
        assertEquals(zwiebeln.getPreis(), alleZutaten.getListe().get(8).getPreis(), .001);
        assertEquals(oliven.getId(), alleZutaten.getListe().get(9).getId());
        assertEquals(oliven.getName(), alleZutaten.getListe().get(9).getName());
        assertEquals(oliven.getPreis(), alleZutaten.getListe().get(9).getPreis(), .001);
        assertEquals(ei.getId(), alleZutaten.getListe().get(10).getId());
        assertEquals(ei.getName(), alleZutaten.getListe().get(10).getName());
        assertEquals(ei.getPreis(), alleZutaten.getListe().get(10).getPreis(), .001);
        assertEquals(paprika.getId(), alleZutaten.getListe().get(11).getId());
        assertEquals(paprika.getName(), alleZutaten.getListe().get(11).getName());
        assertEquals(paprika.getPreis(), alleZutaten.getListe().get(11).getPreis(), .001);
        assertEquals(tomaten.getId(), alleZutaten.getListe().get(12).getId());
        assertEquals(tomaten.getName(), alleZutaten.getListe().get(12).getName());
        assertEquals(tomaten.getPreis(), alleZutaten.getListe().get(12).getPreis(), .001);
        assertEquals(champignons.getId(), alleZutaten.getListe().get(13).getId());
        assertEquals(champignons.getName(), alleZutaten.getListe().get(13).getName());
        assertEquals(champignons.getPreis(), alleZutaten.getListe().get(13).getPreis(), .001);
    }

    @After
    public void tearDown() {
        System.out.println("Tearing it down!");
        alleZutaten = null;
        gouda = null;
        mozzarella = null;
        salami = null;
        schinken = null;
        thunfisch = null;
        peperoni = null;
        ananas = null;
        mais = null;
        zwiebeln = null;
        oliven = null;
        ei = null;
        paprika = null;
        tomaten = null;
        champignons = null;
        assertNull(alleZutaten);
        assertNull(gouda);
        assertNull(mozzarella);
        assertNull(salami);
        assertNull(schinken);
        assertNull(thunfisch);
        assertNull(peperoni);
        assertNull(ananas);
        assertNull(mais);
        assertNull(zwiebeln);
        assertNull(oliven);
        assertNull(ei);
        assertNull(paprika);
        assertNull(tomaten);
        assertNull(champignons);
    }
}