package general_tools;

public class HeapValidator {

    // Function to check if the array represents a max-heap
    public static boolean isMaxHeap(int[] array) {
        boolean isValid = true;
        for (int i = 1; i <= (array.length - 1) / 2; i++) {
            int leftChildIndex = 2 * i;
            int rightChildIndex = 2 * i + 1;

            // Check left child
            if (leftChildIndex < array.length && array[i] < array[leftChildIndex]) {
                System.out.println("Node " + array[i] + " (parent) er mindre end node " + array[leftChildIndex] + " (venstre child)");
                isValid = false;
            }

            // Check right child
            if (rightChildIndex < array.length && array[i] < array[rightChildIndex]) {
                System.out.println("Node " + array[i] + " (parent) er mindre end node " + array[rightChildIndex] + " (højre child)");
                isValid = false;
            }
        }
        return isValid;
    }

    // Function to check if the array represents a min-heap
    public static boolean isMinHeap(int[] array) {
        boolean isValid = true;
        for (int i = 1; i <= (array.length - 1) / 2; i++) {
            int leftChildIndex = 2 * i;
            int rightChildIndex = 2 * i + 1;

            // Check left child
            if (leftChildIndex < array.length && array[i] > array[leftChildIndex]) {
                System.out.println("Node " + array[i] + " (parent) er større end node " + array[leftChildIndex] + " (venstre child)");
                isValid = false;
            }

            // Check right child
            if (rightChildIndex < array.length && array[i] > array[rightChildIndex]) {
                System.out.println("Node " + array[i] + " (parent) er større end node " + array[rightChildIndex] + " (højre child)");
                isValid = false;
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        int[] array = {0, 4, 17, 12, 20, 25, 15, 38, 22, 30, 24, 45, 67, 18, 40, 42, 36, 56};

        System.out.println("Checker om array'et er en Max-Heap:");
        boolean isMax = isMaxHeap(array);
        System.out.println("Er array'et et validt Max-Heap? " + isMax);

        System.out.println("\nChecker om array'et er en Min-Heap:");
        boolean isMin = isMinHeap(array);
        System.out.println("Er array'et et validt Min-Heap? " + isMin);

        if (!isMax && !isMin) {
            System.out.println("\nArray'et representerer hverken et Max-Heap eller et Min-Heap.");
        }
    }
}
