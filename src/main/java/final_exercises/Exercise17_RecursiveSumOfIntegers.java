package final_exercises;

public class Exercise17_RecursiveSumOfIntegers {
    public static void main(String[] args) {
        System.out.println(sumOfIntegers(4));
    }

    public static int sumOfIntegers(int N) {
        int sum = N;
        if (N > 0) {
            sum += sumOfIntegers(N-1);
        }
        return sum;
    }
}