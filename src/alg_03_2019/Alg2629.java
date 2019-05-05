package alg_03_2019;
import java.util.*;

public class Alg2629 {
    static int[] dp = new int[1001]; // 1 - 1000
    static int mod = 10007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Arrays.fill(dp, -1);
        System.out.println(comsdp(N));
    }
    static int comsdp(int n){
        if(n == 0 || n == 1) // 기저 사례
            return 1;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = (comsdp(n-1) + comsdp(n-2))%mod;
    }
}
