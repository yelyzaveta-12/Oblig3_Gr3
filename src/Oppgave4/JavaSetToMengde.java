package Oppgave4;

import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {


    //oppgave c)
    private Set<T> set = new HashSet<>();

    @Override
    public boolean erTom() {
        return set.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return set.contains(element);
    }

    @Override
    public void leggTil(T element) {
        set.add(element);
    }

    @Override
    public T fjern(T element) {
        return set.remove(element) ? element : null;
    }

    @Override
    public int antallElementer() {
        return set.size();
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annen) {
        for (T e : set) {
            if (!annen.inneholder(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annen) {
        return antallElementer() == annen.antallElementer()
                && erDelmengdeAv(annen);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annen) {
        for (T e : set) {
            if (annen.inneholder(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annen) {
        JavaSetToMengde<T> ny = new JavaSetToMengde<>();
        for (T e : set) {
            if (annen.inneholder(e)) {
                ny.leggTil(e);
            }
        }
        return ny;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annen) {
        JavaSetToMengde<T> ny = new JavaSetToMengde<>();
        ny.set.addAll(this.set);
        for (T e : annen.tilTabell()) {
            ny.leggTil(e);
        }
        return ny;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annen) {
        JavaSetToMengde<T> ny = new JavaSetToMengde<>();
        for (T e : set) {
            if (!annen.inneholder(e)) {
                ny.leggTil(e);
            }
        }
        return ny;
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annen) {
        for (T e : annen.tilTabell()) {
            set.add(e);
        }
    }

    @Override
    public T[] tilTabell() {
        return (T[]) set.toArray();
    }
}
