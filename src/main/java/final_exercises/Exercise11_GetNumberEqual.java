package final_exercises;

public class Exercise11_GetNumberEqual {

    // The algorithm returns the number of occurrences of a certain integer (parameter val) in an
    // integer array (parameter x). Parameter n is the number of elements in the array.
    public static void main(String[] args) {
        System.out.println(getNumberEqual(new int[]{7, 4, 1, 3, 5, 6, 4, 8}, 8, 4));
    }

    public static int getNumberEqual(int[] x, int n, int val) {
        int count = 0;
        if (n > 1) {
            if (val == x[n-1]) {
                count++;
            }
            count += getNumberEqual(x, n-1, val);
        }
        return count;
    }
}
