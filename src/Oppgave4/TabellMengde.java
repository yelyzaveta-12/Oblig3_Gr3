package Oppgave4;

import java.util.Arrays;

public class TabellMengde<T> implements  MengdeADT<T> {


    //oppgave a)
    private T[] tabell;
    private int antall;
    private static final int START_KAPASITET = 10;

    @SuppressWarnings("unchecked")
    public TabellMengde() {
        tabell = (T[]) new Object[START_KAPASITET];
        antall = 0;
    }

    private void utvidKapasitet() {
        tabell = Arrays.copyOf(tabell, tabell.length * 2);
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    //i)
    @Override
    public boolean inneholder(T element) {
        for (int i = 0; i < antall; i++) {
            if (tabell[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            if (antall == tabell.length) {
                utvidKapasitet();
            }
            tabell[antall] = element;
            antall++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        T[] annenTabell = annenMengde.tilTabell();
        for (T element : annenTabell) {
            leggTil(element);
        }
    }

    //v
    //Find element, replace it with siste
    @Override
    public T fjern(T element) {
        for (int i = 0; i < antall; i++) {
            if (tabell[i].equals(element)) {
                T fjernet = tabell[i];
                tabell[i] = tabell[antall - 1]; // erstatt med siste element
                tabell[antall - 1] = null;
                antall--;
                return fjernet;
            }
        }
        return null;
    }


    //ii)
    //ALL elements must be inside the other set for it to be a delmengde
    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(tabell[i])) {
                return false;
            }
        }
        return true;
    }

    //iii)
    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (antall != annenMengde.antallElementer()) {
            return false;
        }
        return erDelmengdeAv(annenMengde);
    }

    //disjunkt = no common elements
    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(tabell[i])) {
                return false;
            }
        }
        return true;
    }

    //intersection
    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        TabellMengde<T> resultat = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(tabell[i])) {
                resultat.leggTil(tabell[i]);
            }
        }
        return resultat;
    }

    //iv
    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        TabellMengde<T> resultat = new TabellMengde<>();
        resultat.leggTilAlleFra(this);
        resultat.leggTilAlleFra(annenMengde);
        return resultat;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        TabellMengde<T> resultat = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(tabell[i])) {
                resultat.leggTil(tabell[i]);
            }
        }
        return resultat;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] tilTabell() {
        return Arrays.copyOf(tabell, antall);
    }
}
