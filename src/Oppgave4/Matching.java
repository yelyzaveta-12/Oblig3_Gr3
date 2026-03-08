package Oppgave4;

public class Matching {
    static double match(Person a, Person b) {

        MengdeADT<String> A = a.getHobbyer();
        MengdeADT<String> B = b.getHobbyer();

        MengdeADT<String> felles = A.snitt(B);

        MengdeADT<String> pA = A.minus(B);
        MengdeADT<String> pB = B.minus(A);

        MengdeADT<String> totalt = A.union(B);

        //match = felles – (kunA + kunB) / totalt

        return (double) felles.antallElementer() - ((double) (pA.antallElementer() + pB.antallElementer())
                / totalt.antallElementer());
    }

    public static void main(String[] args) {
        Person Yelyzaveta = new Person("Yelyzaveta",
                "gym", "høre på musikk", "gaming");

        Person Lasse = new Person("Lasse",
                "høre på musikk", "øl", "venner", "gå på tur");

        Person Minnelin = new Person("Minnelin", "");

        Person Helle = new Person ("Helle", "gaming", "");

        double ab = match(Minnelin, Lasse);
        double ac = match(Helle, Yelyzaveta);
        double bc = match(Minnelin, Helle);
        double cb = match(Lasse, Helle);

        System.out.println("Match mellom Minnelin&Lasse = " + ab);
        System.out.println("Match mellon Helle&Yelyzaveta = " + ac);
        System.out.println("Match mellom Minnelin&Helle = " + bc);
        System.out.println("Match mellom Lasse&Helle = " + cb);
    }
}

