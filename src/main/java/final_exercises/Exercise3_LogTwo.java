package final_exercises;

public class Exercise3_LogTwo {

    // The algorithm returns the base two algorithm of N, and it is a precondition that
    // N is a positive integer and a power of 2.
    // Called with N = 32 it returns 5, and with N = 4096 it returns 12.
    public static void main(String[] args) {
        System.out.println(logTwo(32));
    }

    public static int logTwo(int N) {
        int count = 0;
        if (N > 1) {
            count++;
            count += logTwo(N/2);
        }
        return count;
    }
}
