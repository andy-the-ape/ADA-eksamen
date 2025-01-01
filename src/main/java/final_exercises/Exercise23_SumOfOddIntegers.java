package final_exercises;

public class Exercise23_SumOfOddIntegers {

    public static void main(String[] args) {
        System.out.println(sumOfOddIntegers(9));
    }

    public static int sumOfOddIntegers(int N) {
        int sum = 0;
        if (N > 0) {
            if (N % 2 != 0) {
                sum = N;
                sum += sumOfOddIntegers(N-2);
            }
            else {
                sum += sumOfOddIntegers(N-1);
            }
        }
        return sum;
    }
}
