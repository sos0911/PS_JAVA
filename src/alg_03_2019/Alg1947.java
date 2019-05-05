package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1947 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int mod = 1000000000;
        long[] dp = new long[1000001]; // 0 - N
        dp[1] = 0; dp[2] = 1;
        for(int i = 3; i <= N; i++)
            dp[i] = (long)((i-1)*((dp[i-1] + dp[i-2])%mod)%mod); // k의 범위 : 2 - i
                           // 10억 * 백만 <= long
    System.out.println(dp[N]);
    }
}