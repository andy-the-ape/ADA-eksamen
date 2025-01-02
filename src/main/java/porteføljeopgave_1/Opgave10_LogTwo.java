package porteføljeopgave_1;

public class Opgave10_LogTwo {
    //Skriv en rekursiv metode med følgende signatur:
    //int logTo(int N)
    //Algoritmen returner totals-logaritmen af N, og det er en forudsætning, at N er et naturligt tal og en potens
    //af 2.
    //Kaldt med N = 32 returneres 5, og med N = 4096 returneres 12

    public static void main(String[] args) {
        System.out.println(logTwo(1));
    }

    public static int logTwo(int N) {
        int logCount = 0;
        if (N > 2) {
            logCount += 1+logTwo(N/2);
        } else if (N == 2) {
            logCount ++;
        }
        return logCount;
    }
}
