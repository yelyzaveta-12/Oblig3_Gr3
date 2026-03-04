package Oppgave4;

public class Kjoretid {
    public static void main(String[] args) {

        //personal test
        int n = 100;

        //a)
        MengdeADT<Integer> tabell = new TabellMengde<>();

        //b)
        MengdeADT<Integer> lenket = new LenketMengde<>();

        //c)
        MengdeADT<Integer> set = new JavaSetToMengde<>();

        for (int i = 0; i < n; i++) {
            tabell.leggTil(i);
            lenket.leggTil(i);
        }

        long start = System.nanoTime();
        tabell.inneholder(n - 1);
        long slutt = System.nanoTime();
        System.out.println("Tabell tid(ns) : " + (slutt - start));

        start = System.nanoTime();
        lenket.inneholder(n - 1);
        slutt = System.nanoTime();
        System.out.println("Lenket tid(ns) : " + (slutt - start));

    }
}
