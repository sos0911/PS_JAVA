package backjoonalg;
import java.util.Arrays;
import java.util.Scanner;

public class Alg2748 {
    static long[] dp; 
    public static void main(String[] args){
        dp = new long[91]; // index 1 - index 90
        Arrays.fill(dp, -1);
        Scanner sc = new Scanner(System.in);
        System.out.println(Fibonaci(sc.nextInt()));
    }
    static long Fibonaci(int n){
        if(n == 0 || n == 1)
            return n;
        long answer = 0;
        if(dp[n-1] != -1)
            answer += dp[n-1];
        else
            answer += Fibonaci(n-1);
         if(dp[n-2] != -1)
            answer += dp[n-2];
        else
            answer += Fibonaci(n-2);
        return dp[n] = answer;
    }
}
