package eksamen_2023_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Opgave2 {

    //Skriv en rekursiv metode/algoritme med følgende signatur:
    //int secondLargestElem(int arr[], int length)
    //Den første parameter indeholder et array af heltal, fx {23,117,10,14,18,22,29,39,51,45,49,61,65,68,81,89}.
    //Den anden parameter er arrayets længde.
    //I det ovenstående eksempel returnerer metoden 89.
    //Overvej om din metode altid returnerer det korrekte tal, uanset rækkefølgen af tallene i dit array.

    public static void main(String[] args) {
        System.out.println(secondLargestElem(new int[]{23,117,10,14,18,22,29,39,51,45,49,61,65,68,81,89}, 16));
    }

    public static int secondLargestElem(int[] arr, int length) {
        if(length < 2){
            return -1;
        }

        if(length == 2){
            return Math.min(arr[0], arr[1]);
        }

        Arrays.sort(arr);
        int[] newArray = new int[length - 1];
        for(int i = 1; i < arr.length; i++){
            newArray[i-1] = arr[i];
        }
        return secondLargestElem(newArray, newArray.length);
    }

}
