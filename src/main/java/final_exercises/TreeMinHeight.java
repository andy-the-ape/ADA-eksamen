package final_exercises;

public class TreeMinHeight {

    public static boolean minimalHeight(int[] nodeArray, int height) {
        for (int i = 1; i < height + 1; i++) {
            int powerOfTwo = (int) Math.pow(2, i);
            if (powerOfTwo >= nodeArray.length) {
                return (height == i-1);
            }
        }
        return false;
    }

}
