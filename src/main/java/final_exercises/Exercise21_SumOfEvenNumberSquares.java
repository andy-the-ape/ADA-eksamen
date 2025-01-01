package final_exercises;

public class Exercise21_SumOfEvenNumberSquares {

    public static void main(String[] args) {
        System.out.println(sumOfEvenNumberSquares(9));
    }

    public static int sumOfEvenNumberSquares(int N) {
        int sum = 0;
        if (N >= 2) {
            if (N % 2 == 0) {
                sum = N*N;
                sum += sumOfEvenNumberSquares(N-2);
            }
            else {
                sum += sumOfEvenNumberSquares(N-1);
            }
        }
        return sum;
    }
}
