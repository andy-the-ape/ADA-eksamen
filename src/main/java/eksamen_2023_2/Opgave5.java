package eksamen_2023_2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Opgave5 {
    //Skriv en algoritme/metode, der kan tage en tekststreng som input og returnere det oftest forekommende
    //bogstav samt antal i form af en String/string.
    //String mostFrequentLetter(String s);
    //Parameteren kan kun indeholde små bogstaver i det engelske alfabet [a-z]. ascii-koden for ’a’ er 97 og 122
    //for ’z’.
    //Eksempel: kaldt med parameteren ”inagrassrootcampaignunlikeanyotherbeforeorsince” returneres ”a5”.
    //Bogstavet ’a’ topper med 5 forekomster i teksten.
    //Hvis det står ’uafgjort’ mellem to eller flere bogstaver, er det ligegyldigt, hvilket af dem du returnerer.
    //For at opnå maksimumpoints skal algoritmen have tidskompleksiteten O(N), hvor N er antal tegn i teksten.
    //Andre løsninger kan højest opnå 2/3, dvs. 10 af 15

    public static void main(String[] args) {
        System.out.println(mostFrequentLetter("inagrassrootcampaignunlikeanyotherbeforeorsince"));
    }
    public static String mostFrequentLetter(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> letterCount = new HashMap<>();

        Character mostFrequentChar = 'å';
        int highestCount = 0;

        for (char c : chars) {
            if (letterCount.containsKey(c)) {
                letterCount.put(c, letterCount.get(c)+1);
            } else {
                letterCount.put(c, 1);
            }
            if (letterCount.get(c) > highestCount) {
                mostFrequentChar = c;
                highestCount = letterCount.get(c);
            }
        }
        return mostFrequentChar.toString()+highestCount;
    }
}
