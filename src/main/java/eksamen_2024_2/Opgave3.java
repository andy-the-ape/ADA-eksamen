package eksamen_2024_2;

public class Opgave3 {

    //Skriv en rekursiv metode/algoritme med følgende signatur:
    //int antalVokaler(String str,int l)
    //Parameteren str indeholder små bogstaver i det engelske alfabet:
    //{a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z}.
    //Og metoden skal returnere antallet af vokaler i strengen str, og vi antager, at vokalerne er:
    //{a,e,i,o,u,y}
    //Kaldt med strengen ”stationsbygninger” returneres 6, eftersom vokalerne i strengen er ”a,i,o,y,i,e”.
    //Den anden parameter i metoden angiver længden af strengen minus 1, idet det antages, at strengen
    //opfattes som et array af karakterer (chars).
    //Det kan anbefales at skrive en hjælpemetode med returværdi true ellers false, som kan afgøre om den
    //enlige parameter af datatypen char, er en vokal eller en konsonant

    public static void main(String[] args) {
        System.out.println(antalVokaler("stationsbygninger", 17));
    }

    public static int antalVokaler(String str, int l) {
        int vokaler = 0;
        if (l > 0) {
            if (erVokal(str.charAt(0))) {
                vokaler += 1+antalVokaler(str.substring(1), l-1);
            }
            else {
                vokaler += antalVokaler(str.substring(1), l-1);
            }
        }
        return vokaler;
    }

    public static boolean erVokal(char c) {
        char[] vokaler = new char[]{'a','e','i','o','u','y'};

        for (char value : vokaler) {
            if (c == value) {
                return true;
            }
        }
        return false;
    }
}
