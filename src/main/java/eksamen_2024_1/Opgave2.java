package eksamen_2024_1;

public class Opgave2 {
    //Skriv en rekursiv metode/algoritme med følgende signatur:
    //int sumDeleligMedTreOgOtte(int N)
    //Metoden returnerer summen af de tal, som er mindre end eller lig med N og er delelige med 3 eller 8. Er et
    //tal deleligt med både tre og otte, tælles det kun med én gang.
    //Kaldt med parameteren 26 returneres 132 (3+6+8+9+12+15+16+18+21+24)

    public static void main(String[] args) {
        System.out.println(sumDeleligMedTreOgOtte(26));
    }

    public static int sumDeleligMedTreOgOtte(int N) {
        int sum = 0;
        if (N <= 2) return 0;

        if (N % 3 == 0 || N % 8 == 0) {
            sum += N + sumDeleligMedTreOgOtte(N-1);
        } else {
            sum += sumDeleligMedTreOgOtte(N-1);
        }
        return sum;
    }
}
