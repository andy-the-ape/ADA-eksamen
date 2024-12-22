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
                System.out.println("Node " + array[i] + " (parent) is smaller than node " + array[leftChildIndex] + " (child left)");
                isValid = false;
            }

            // Check right child
            if (rightChildIndex < array.length && array[i] < array[rightChildIndex]) {
                System.out.println("Node " + array[i] + " (parent) is smaller than node " + array[rightChildIndex] + " (child right)");
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
                System.out.println("Node " + array[i] + " (parent) is greater than node " + array[leftChildIndex] + " (child left)");
                isValid = false;
            }

            // Check right child
            if (rightChildIndex < array.length && array[i] > array[rightChildIndex]) {
                System.out.println("Node " + array[i] + " (parent) is greater than node " + array[rightChildIndex] + " (child right)");
                isValid = false;
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        int[] array = {0, 17, 21, 23, 44, 32, 65, 38, 56, 46, 69, 33, 77, 67, 56, 39, 61, 60, 62, 50, 71};

        System.out.println("Checking if the array is a Max-Heap:");
        boolean isMax = isMaxHeap(array);
        System.out.println("Is the array a valid Max-Heap? " + isMax);

        System.out.println("\nChecking if the array is a Min-Heap:");
        boolean isMin = isMinHeap(array);
        System.out.println("Is the array a valid Min-Heap? " + isMin);

        if (!isMax && !isMin) {
            System.out.println("\nThe array does not represent either a Max-Heap or a Min-Heap.");
        }
    }
}
