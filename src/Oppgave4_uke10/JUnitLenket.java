package Oppgave4_uke10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitLenket {

    // i
    @Test
    void testInneholder() {
        MengdeADT<Integer> m = new LenketMengde<>();

        m.leggTil(5);

        assertTrue(m.inneholder(5));
        assertFalse(m.inneholder(10));
    }

    // ii
    @Test
    void testErDelmengdeAv() {
        MengdeADT<Integer> m1 = new LenketMengde<>();
        MengdeADT<Integer> m2 = new LenketMengde<>();

        m1.leggTil(5);
        m1.leggTil(6);

        m2.leggTil(5);
        m2.leggTil(6);
        m2.leggTil(7);

        assertTrue(m1.erDelmengdeAv(m2));
        assertFalse(m2.erDelmengdeAv(m1));
    }

    // iii
    @Test
    void testErLik() {
        MengdeADT<Integer> m1 = new LenketMengde<>();
        MengdeADT<Integer> m2 = new LenketMengde<>();

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
        MengdeADT<Integer> m1 = new LenketMengde<>();
        MengdeADT<Integer> m2 = new LenketMengde<>();

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
        MengdeADT<Integer> m = new LenketMengde<>();

        m.leggTil(3);
        m.fjern(3);

        assertFalse(m.inneholder(3));
    }

    @Test
    void testFjernFoersteElement() {
        MengdeADT<Integer> m = new LenketMengde<>();

        m.leggTil(1);
        m.leggTil(2);
        m.leggTil(3);

        Integer fjernet = m.fjern(3);

        assertEquals(3, fjernet);
        assertFalse(m.inneholder(3));
        assertEquals(2, m.antallElementer());
    }

    @Test
    void testErDisjunktTrue() {
        MengdeADT<Integer> m1 = new LenketMengde<>();
        MengdeADT<Integer> m2 = new LenketMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m2.leggTil(3);
        m2.leggTil(4);

        assertTrue(m1.erDisjunkt(m2));
    }

    @Test
    void testErDisjunktFalse() {
        MengdeADT<Integer> m1 = new LenketMengde<>();
        MengdeADT<Integer> m2 = new LenketMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m2.leggTil(2);
        m2.leggTil(3);

        assertFalse(m1.erDisjunkt(m2));
    }

    @Test
    void testSnitt() {
        MengdeADT<Integer> m1 = new LenketMengde<>();
        MengdeADT<Integer> m2 = new LenketMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);
        m1.leggTil(3);

        m2.leggTil(2);
        m2.leggTil(3);
        m2.leggTil(4);

        MengdeADT<Integer> snitt = m1.snitt(m2);

        assertTrue(snitt.inneholder(2));
        assertTrue(snitt.inneholder(3));
        assertFalse(snitt.inneholder(1));
        assertFalse(snitt.inneholder(4));
        assertEquals(2, snitt.antallElementer());
    }

    @Test
    void testSnittTomt() {
        MengdeADT<Integer> m1 = new LenketMengde<>();
        MengdeADT<Integer> m2 = new LenketMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m2.leggTil(3);
        m2.leggTil(4);

        MengdeADT<Integer> snitt = m1.snitt(m2);

        assertTrue(snitt.erTom());
        assertEquals(0, snitt.antallElementer());
    }
}