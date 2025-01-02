package porteføljeopgave_1;

public class Opgave1_SumAfUligeKvadreret {
    //Skriv en rekursiv algoritme, som har et naturligt tal som parameter og returnerer summen af de ulige tals
    //kvadrater fra 1 til N.
    //Eksempel: kaldt med parameteren 8 returneres 84 (1^2+3^2+ 5^2+ 7^2).
    //Det er vigtigt at optimere algoritmen, så overflødige rekursive kald undgås.

    public static void main(String[] args) {
        System.out.println(sumOfOddNumbersSquared(8));
    }

    public static int sumOfOddNumbersSquared(int N) {
        int sum = 0;
        if (N > 0) {
            if (N % 2 == 0) {
                sum += sumOfOddNumbersSquared(N-1);
            }
            else {
                sum += N*N + sumOfOddNumbersSquared(N-2);
            }
        }
        return sum;
    }
}
