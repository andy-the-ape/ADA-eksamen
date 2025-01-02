package porteføljeopgave_1;

public class Opgave6_SumDivisbleBy3 {
    //Skriv en rekursiv algoritme med følgende signatur:
    //int sumDivisibleBy3(int N)
    //Algoritmen returnerer summen af heltal større end 0 og mindre end eller lig med N, som er dividérbare
    //med 3.
    //Kaldt med N = 12 er den korrekte returværdi 30 (3+6+9+12). Kaldt med N = 14 er den korrekte
    //returværdi også 30.
    //Din algoritme skal optimeres således, at overflødige rekursive kald undgås.

    public static void main(String[] args) {
        System.out.println(sumDivisibleBy3(12));
    }
    public static int sumDivisibleBy3(int N) {
        int sum = 0;
        if (N > 3) {
            if (N % 3 == 0) {
                sum += N + sumDivisibleBy3(N-3);
            } else if (N % 3 == 1) {
                sum += sumDivisibleBy3(N-1);
            } else {
                sum += sumDivisibleBy3(N-2);
            }
        } else if (N == 3) {
            return sum += N;
        } else {
            return 0;
        }
        return sum;
    }
}
