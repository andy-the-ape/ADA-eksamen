package eksamen_2023_2;

public class Opgave6 {
    //Vi definerer en kategori af tal som har følgende egenskaber
    //  • Naturlige tal på 5 cifre (10000-99999)
    //  • Et af de to følgende kriterier skal være opfyldt
    //      o Cifrene er i stigende orden (eller lig med) fra venstre mod højre, fx 36789 og 24469.
    //      o Cifrene er i faldende orden (eller lig med) fra venstre mod højre, fx 86421 og 97743.
    //Skriv en metode/algoritme, som kan afgøre om et tal tilhører klassen eller ej. Din løsning må gerne
    //indeholde flere metoder

    public static void main(String[] args) {
        System.out.println(naturalOrderedNumbers(55321));
    }

    public static boolean naturalOrderedNumbers(int n) {
        String numberString = String.valueOf(n);
        //Determine if there are exactly 5 digits
        if (numberString.length() != 5) {
            return false;
        }
        return isAscending(numberString) || isDescending(numberString);
    }

    public static boolean isAscending(String n) {
        char[] chars = n.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < chars[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDescending(String n) {
        char[] chars = n.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] > chars[i-1]) {
                return false;
            }
        }
        return true;
    }
}
