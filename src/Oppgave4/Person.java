package Oppgave4;

public class Person {

    private String navn;
    private MengdeADT<String> hobbyer;

    public Person(String navn, String... hobbyer) {
        this.navn = navn;
        this.hobbyer = new TabellMengde<>();
        for (String h : hobbyer)
            this.hobbyer.leggTil(h);
    }

    public String getNavn() {
        return navn;
    }

    public MengdeADT<String> getHobbyer() {
        return hobbyer;
    }
}