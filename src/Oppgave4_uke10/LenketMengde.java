package Oppgave4_uke10;

public class LenketMengde<T> implements MengdeADT<T> {


    //oppgave b)
    private class Node {
        T data;
        Node neste;

        Node(T data) {
            this.data = data;
        }
    }

    private Node foerste;
    private int antall;

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    //i
    @Override
    public boolean inneholder(T element) {
        Node p = foerste;
        while (p != null) {
            if (p.data.equals(element)) {
                return true;
            }
            p = p.neste;
        }
        return false;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            Node ny = new Node(element);
            ny.neste = foerste;
            foerste = ny;
            antall++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annen) {
        for (T e : annen.tilTabell()) {
            leggTil(e);
        }
    }

    //v
    @Override
    public T fjern(T element) {
        Node p = foerste;
        Node prev = null;

        while (p != null) {
            if (p.data.equals(element)) {
                if (prev == null) {
                    p = p.neste;
                } else {
                    prev.neste = p.neste;
                }
                antall--;
                return element;
            }
            prev = p;
            p = p.neste;
        }
        return null;
    }

    //ii
    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annen) {
        Node p = foerste;
        while (p != null) {
            if (!annen.inneholder(p.data)) {
                return false;
            }
            p = p.neste;
        }
        return true;
    }

    //iii
    @Override
    public boolean erLik(MengdeADT<T> annen) {
        return antall == annen.antallElementer() &&
                erDelmengdeAv(annen);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annen) {
        Node p = foerste;
        while (p != null) {
            if (annen.inneholder(p.data)) {
                return false;
            }
            p = p.neste;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annen) {
        LenketMengde<T> ny = new LenketMengde<>();
        Node p = foerste;
        while (p != null) {
            if (annen.inneholder(p.data)) {
                ny.leggTil(p.data);
            }
            p = p.neste;
        }
        return ny;
    }

    //iv
    @Override
    public MengdeADT<T> union(MengdeADT<T> annen) {
        LenketMengde<T> ny = new LenketMengde<>();
        ny.leggTilAlleFra(this);
        ny.leggTilAlleFra(annen);
        return ny;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annen) {
        LenketMengde<T> ny = new LenketMengde<>();
        Node p = foerste;
        while (p != null) {
            if (!annen.inneholder(p.data)) {
                ny.leggTil(p.data);
            }
            p = p.neste;
        }
        return ny;
    }

    @Override
    public T[] tilTabell() {
        T[] arr = (T[]) new Object[antall];
        Node p = foerste;
        int i = 0;
        while (p != null) {
            arr[i++] = p.data;
            p = p.neste;
        }
        return arr;
    }
}
