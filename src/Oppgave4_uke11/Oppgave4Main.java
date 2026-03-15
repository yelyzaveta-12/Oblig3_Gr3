package Oppgave4_uke11;

import java.util.Arrays;
import java.util.HashSet;

public class Oppgave4Main {
    public static void main(String[] args) {
        int antallElementer = 100000;
        int maksTall = 1000000;
        int antallSok = 10000;

        HashSet<Integer> hashSet = new HashSet<>();
        Integer[] tabell = new Integer[antallElementer];

        Oppgave4 oppgave = new Oppgave4();

        oppgave.fyllStrukturer(hashSet, tabell, antallElementer, maksTall);

        Arrays.sort(tabell);

        int[] soketall = oppgave.lagSoketall(antallSok, maksTall);

        long[] hashResultat = oppgave.sokIHashSet(hashSet, soketall);
        long[] tabellResultat = oppgave.sokITabell(tabell, soketall);

        System.out.println("Funn i HashSet: " + hashResultat[0]);
        System.out.println("Tid brukt på HashSet (ns): " + hashResultat[1]);

        System.out.println("Funn med binærsøk: " + tabellResultat[0]);
        System.out.println("Tid brukt på binærsøk (ns): " + tabellResultat[1]);
    }
}