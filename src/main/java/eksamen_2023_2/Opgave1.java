package eksamen_2023_2;

public class Opgave1 {
    //Skriv en rekursiv metode/algoritme med følgende signatur:
    //int divByThreeAndOrFour(int N)
    //Parameteren N er et naturligt tal, og metoden skal returnere summen af de tal som er mindre end eller lig
    //med N, hvor 3 og/eller 4 går op.
    //Kaldt med parameteren 13 er den korrekte returværdi 42 (3 + 4 + 6 + 8 + 9 + 12).
    public static void main(String[] args) {
        System.out.println(divByThreeAndOrFour(13));
    }

    public static int divByThreeAndOrFour(int N) {
        int sum = 0;
        if (N <= 2) return 0; //base case

        if (N % 3 == 0 || N % 4 == 0) {
            sum += N + divByThreeAndOrFour(N-1);
        } else {
            sum += divByThreeAndOrFour(N-1);
        }
        return sum;
    }

}
