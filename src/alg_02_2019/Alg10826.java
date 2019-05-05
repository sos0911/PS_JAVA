package alg_02_2019;
import java.io.*;
import java.util.*;
public class Alg10826 {
    static long[] dp = new long[10001]; // index 1 - 10000
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(dp, -1);
        System.out.println(Fibo(Integer.parseInt(br.readLine())));
    }
    static long Fibo(int n){
        if(n == 0 || n == 1)
            return n;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = Fibo(n-1) + Fibo(n-2);
    }
}
