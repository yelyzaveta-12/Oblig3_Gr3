package Oppgave4_uke10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitLenket {


    //i
    @Test
    void testInneholder() {
        MengdeADT<Integer> m = new LenketMengde<>();

        m.leggTil(5);

        assertTrue(m.inneholder(5));
        assertFalse(m.inneholder(10));
    }

    //ii
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

    //iii
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

    //iv
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

    //v
    @Test
    void testFjern() {
        MengdeADT<Integer> m = new LenketMengde<>();

        m.leggTil(3);
        m.fjern(3);

        assertFalse(m.inneholder(3));
    }
}
