package eksamen_2023_2;

public class Opgave3 {

    public static void main(String[] args) {
        System.out.println(myMethod1(64));
    }

    public static int myMethod1(int x)
    {
        int y = 0;
        for (int i = 0; i <= x; i++)
        {
            if (x < 256)
                y += myMethod2(x*x);
            else
                y += myMethod2(x/2);
        }
        return y;
    }

    public static int myMethod2(int x)
    {
        int y = 0;
        for (int i = 0;i <= x; i++)
        {
            if (x < 256)
                y += myMethod3(x);
            else
                y += myMethod3(x*2);
        }
        return y;
    }
    public static int myMethod3(int x)
    {
        int y = 0;
        for (int i = x; i > 0; i/=2)
            y++;
        return y;
    }
}
