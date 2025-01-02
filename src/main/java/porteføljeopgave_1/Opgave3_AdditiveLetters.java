package porteføljeopgave_1;

public class Opgave3_AdditiveLetters {
    //Skriv en rekursiv algoritme med følgende signatur:
    //bool additive(String s)
    //Parameteren indeholder en streng bestående af cifre, fx. “82842605”.
    //Algoritmen returnerer true, hvis parameteren indeholder en substring af tre på hinanden efterfølgende tal,
    //hvor det tredje ciffer er lig med summen af de to forrige.
    //I ovenstående eksempel returneres true, fordi indeks 5 (6) er summen af indeks 3 og 4 (4 plus 2).
    //Tip: ASCII-værdien af karakteren ‘7’ er 55.

    public static void main(String[] args) {
        System.out.println(additive("82842605"));
    }

    public static boolean additive(String s) {
        boolean additiveCondition = false;
        if (s.length() > 3) {
            if (Character.getNumericValue(s.charAt(0)) + Character.getNumericValue(s.charAt(1)) == Character.getNumericValue(s.charAt(2))) {
                additiveCondition = true;
            }
            else {
                additiveCondition = additive(s.substring(1));
            }
        }
        else if (s.length() == 3) {
            if (Character.getNumericValue(s.charAt(0)) + Character.getNumericValue(s.charAt(1)) == Character.getNumericValue(s.charAt(2))) {
                additiveCondition = true;
            }
        }
        return additiveCondition;
    }
}
