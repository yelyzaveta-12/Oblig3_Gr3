package Oppgave4;

public class LenketMengde<T> implements MengdeADT<T> {


    //oppgave b)
    private class Node {
        T data;
        Node neste;

        Node(T data) {
            this.data = data;
        }
    }

    private Node start;
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
        Node current = start;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.neste;
        }
        return false;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            Node ny = new Node(element);
            ny.neste = start;
            start = ny;
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
        Node current = start;
        Node prev = null;

        while (current != null) {
            if (current.data.equals(element)) {
                if (prev == null) {
                    start = current.neste;
                } else {
                    prev.neste = current.neste;
                }
                antall--;
                return element;
            }
            prev = current;
            current = current.neste;
        }
        return null;
    }

    //ii
    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annen) {
        Node current = start;
        while (current != null) {
            if (!annen.inneholder(current.data)) {
                return false;
            }
            current = current.neste;
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
        Node current = start;
        while (current != null) {
            if (annen.inneholder(current.data)) {
                return false;
            }
            current = current.neste;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annen) {
        LenketMengde<T> ny = new LenketMengde<>();
        Node current = start;
        while (current != null) {
            if (annen.inneholder(current.data)) {
                ny.leggTil(current.data);
            }
            current = current.neste;
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
        Node current = start;
        while (current != null) {
            if (!annen.inneholder(current.data)) {
                ny.leggTil(current.data);
            }
            current = current.neste;
        }
        return ny;
    }

    @Override
    public T[] tilTabell() {
        T[] arr = (T[]) new Object[antall];
        Node current = start;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.neste;
        }
        return arr;
    }
}
