package Oppgave4_uke11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Oppgave4 {

    public void fyllStrukturer(HashSet<Integer> hashSet, Integer[] tabell, int antallElementer, int maksTall) {
        int tall = 376;

        for (int i = 0; i < antallElementer; i++) {
            hashSet.add(tall);
            tabell[i] = tall;
            tall = (tall + 45713) % maksTall;
        }
    }

    public int[] lagSoketall(int antallSok, int maksTall) {
        Random random = new Random();
        int[] soketall = new int[antallSok];

        for (int i = 0; i < antallSok; i++) {
            soketall[i] = random.nextInt(maksTall);
        }

        return soketall;
    }

    public long[] sokIHashSet(HashSet<Integer> hashSet, int[] soketall) {
        int funn = 0;
        long startTid = System.nanoTime();

        for (int i = 0; i < soketall.length; i++) {
            if (hashSet.contains(soketall[i])) {
                funn++;
            }
        }

        long sluttTid = System.nanoTime();
        long tid = sluttTid - startTid;

        return new long[]{funn, tid};
    }

    public long[] sokITabell(Integer[] tabell, int[] soketall) {
        int funn = 0;
        long startTid = System.nanoTime();

        for (int i = 0; i < soketall.length; i++) {
            if (Arrays.binarySearch(tabell, soketall[i]) >= 0) {
                funn++;
            }
        }

        long sluttTid = System.nanoTime();
        long tid = sluttTid - startTid;

        return new long[]{funn, tid};
    }
}