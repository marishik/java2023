import java.math.BigInteger;

public class Math1 {

    //Вычисляется факториал, программа работает до n<=12
    public static int fact(int value) {
        if (value == -1)
            return 0;
        else if (value == 0)
            return 1;
        else if (value == 1)
            return 1;

        int n = 1;
        for(int i = 2; i <= value; i++)
            n *= i;
        return n;
    }

    public static int sign(int value){
        if (value < 0)
            return -1;
        else if (value == 0)
            return 0;
        else if (value > 0)
            return 1;
        else return value;
    }
}
