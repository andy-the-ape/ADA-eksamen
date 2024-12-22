package eksamen_2023_1;

import java.util.Arrays;

public class Opgave6Prioritetskø {
    public static void main(String[] args) {
        System.out.println(getXelement(new int[]{13, 21, 16, 24, 31, 19, 68, 65, 26, 32}, 5));
    }

    public static int getXelement(int[] arr, int x) {
        int[] heap = Arrays.copyOf(arr, arr.length);
        Arrays.sort(heap);
        return heap[x-1];
    }
}
