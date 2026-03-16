package Oppgave4_uke10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitTabell {

    // i
    @Test
    void testInneholder() {
        MengdeADT<Integer> m = new TabellMengde<>();

        m.leggTil(5);
        m.leggTil(2);

        assertTrue(m.inneholder(5));
        assertTrue(m.inneholder(2));
        assertFalse(m.inneholder(10));
    }

    // ii
    @Test
    void testErDelmengdeAv() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        MengdeADT<Integer> m2 = new TabellMengde<>();
        MengdeADT<Integer> m3 = new TabellMengde<>();
        MengdeADT<Integer> m4 = new TabellMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m2.leggTil(1);
        m2.leggTil(2);
        m2.leggTil(3);

        m3.leggTil(4);
        m3.leggTil(5);
        m3.leggTil(6);

        m4.leggTil(6);

        assertTrue(m1.erDelmengdeAv(m2));
        assertFalse(m2.erDelmengdeAv(m1));

        assertTrue(m4.erDelmengdeAv(m3));
    }

    // iii
    @Test
    void testErLik() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        MengdeADT<Integer> m2 = new TabellMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m2.leggTil(1);
        m2.leggTil(2);

        assertTrue(m1.erLik(m2));

        m2.leggTil(3);
        assertFalse(m1.erLik(m2));
    }

    // iv
    @Test
    void testUnion() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        MengdeADT<Integer> m2 = new TabellMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m2.leggTil(2);
        m2.leggTil(3);

        MengdeADT<Integer> union = m1.union(m2);

        assertTrue(union.inneholder(1));
        assertTrue(union.inneholder(2));
        assertTrue(union.inneholder(3));
    }

    // v
    @Test
    void testFjern() {
        MengdeADT<Integer> m = new TabellMengde<>();

        m.leggTil(111);
        m.fjern(111);

        assertFalse(m.inneholder(111));
    }

    @Test
    void testMinus() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        MengdeADT<Integer> m2 = new TabellMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);
        m1.leggTil(3);

        m2.leggTil(3);
        m2.leggTil(4);

        MengdeADT<Integer> minus = m1.minus(m2);

        assertTrue(minus.inneholder(1));
        assertTrue(minus.inneholder(2));
        assertFalse(minus.inneholder(3));
        assertEquals(2, minus.antallElementer());
    }

    @Test
    void testMinusIngenFelles() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        MengdeADT<Integer> m2 = new TabellMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m2.leggTil(3);
        m2.leggTil(4);

        MengdeADT<Integer> minus = m1.minus(m2);

        assertTrue(minus.inneholder(1));
        assertTrue(minus.inneholder(2));
        assertEquals(2, minus.antallElementer());
    }

    @Test
    void testLeggTilAlleFra() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        MengdeADT<Integer> m2 = new TabellMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m2.leggTil(2);
        m2.leggTil(3);
        m2.leggTil(4);

        m1.leggTilAlleFra(m2);

        assertTrue(m1.inneholder(1));
        assertTrue(m1.inneholder(2));
        assertTrue(m1.inneholder(3));
        assertTrue(m1.inneholder(4));
        assertEquals(4, m1.antallElementer());
    }

    @Test
    void testLeggTilAlleFraTom() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        MengdeADT<Integer> m2 = new TabellMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m1.leggTilAlleFra(m2);

        assertTrue(m1.inneholder(1));
        assertTrue(m1.inneholder(2));
        assertEquals(2, m1.antallElementer());
    }
}