package eksamen_2024_2;

public class Opgave1 {
    //Skriv en metode/algoritme med følgende signatur:
    //
    // bool sumAfToTalLigParameter(int[] arr, int l, int X)
    //
    //Den første parameter er et array af positive, sorterede heltal uden dubletter; anden parameter er længden
    //af arrayet; og tredje parameter er den værdi, der ledes efter.
    //
    //Metoden skal finde af om der findes to tal i arrayet, hvis sum er lig med parameteren X. Hvis svaret er ja,
    //returneres true. Hvis svaret er nej, returneres false. Det samme tal må ikke bruges to gange.
    //
    // Opgaven skal løses i to versioner således at:
    //  • Version 1 har kvadratisk tidskompleksitet – O(N^2).
    //  • Version 2 har lineær tidskompleksitet O(N), det vil sige, at hvert element i tabellen kun må læses én
    //  gang.
    //
    // De to løsninger tæller lige meget, altså 6 %.

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 8, 13, 21}; // Sorted array
        int x = 10;

        System.out.println(sumAfToTalLigParameter1(arr, arr.length, x)); // true (2 + 8 = 10)
        System.out.println(sumAfToTalLigParameter2(arr, arr.length, x)); // true (2 + 8 = 10)

        x = 2;
        System.out.println(sumAfToTalLigParameter1(arr, arr.length, x)); // false
        System.out.println(sumAfToTalLigParameter2(arr, arr.length, x)); // false
    }

    //Version 1
    public static boolean sumAfToTalLigParameter1(int[] arr, int l, int x) {
        //Quadratic time complexity O(N)
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                if (arr[i] + arr[j] == x) {
                    return true;
                }
            }
        }
        return false;
    }

    //Version 2
    public static boolean sumAfToTalLigParameter2(int[] arr, int l, int x) {
        //Linear time complexity O(N^2)
        int left = 0; // start pointer
        int right = l-1; // end pointer

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {
                return true;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
