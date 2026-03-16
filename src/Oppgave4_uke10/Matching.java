package Oppgave4_uke10;

public class Matching {
    static double match(Person a, Person b) {

        MengdeADT<String> A = a.getHobbyer();
        MengdeADT<String> B = b.getHobbyer();

        MengdeADT<String> felles = A.snitt(B);
        MengdeADT<String> pA = A.minus(B);
        MengdeADT<String> pB = B.minus(A);
        MengdeADT<String> totalt = A.union(B);

        return (double) felles.antallElementer()
                - ((double) (pA.antallElementer() + pB.antallElementer()) / totalt.antallElementer());
    }

    public static void main(String[] args) {
        Person yelyzaveta = new Person("Yelyzaveta",
                "gym", "høre på musikk", "gaming");

        Person lasse = new Person("Lasse",
                "høre på musikk", "øl", "venner", "gå på tur");

        Person minnelin = new Person("Minnelin",
                "gaming", "serier", "trening");

        double yl = match(yelyzaveta, lasse);
        double ym = match(yelyzaveta, minnelin);
        double lm = match(lasse, minnelin);

        System.out.println("Match mellom Yelyzaveta og Lasse = " + yl);
        System.out.println("Match mellom Yelyzaveta og Minnelin = " + ym);
        System.out.println("Match mellom Lasse og Minnelin = " + lm);

        if (yl >= ym && yl >= lm) {
            System.out.println("Beste match er Yelyzaveta og Lasse.");
        } else if (ym >= yl && ym >= lm) {
            System.out.println("Beste match er Yelyzaveta og Minnelin.");
        } else {
            System.out.println("Beste match er Lasse og Minnelin.");
        }
    }
}