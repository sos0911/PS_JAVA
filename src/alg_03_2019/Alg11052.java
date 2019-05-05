package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg11052 {
    static int[] pi;
    static int[] dp;
    public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Nofc = Integer.parseInt(br.readLine());
        pi = new int[Nofc+1]; dp = new int[Nofc+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= Nofc; i++)
            pi[i] = Integer.parseInt(st.nextToken());
       // Arrays.fill(dp, -1);
        dp[1] = pi[1]; dp[0] = 0;
        for(int i = 2; i <= Nofc; i++)
            for(int j = 1; j <= i; j++)
            dp[i] = Math.max(dp[i], dp[i-j] + pi[j]);
        System.out.println(dp[Nofc]);
    }
}
