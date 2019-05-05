package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg2193 {
    static long[][] dp = new long[2][91]; // 1 - 90
    // int 안에 다 들어갈려나?
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(long[] arr : dp)
            Arrays.fill(arr, -1);
        dp[0][1] = 0; dp[1][1] = 1; // dp[1] = 1;
        dp[0][2] = 1; dp[1][2] = 0;
        for(int i = 3; i < 91; i++){
            dp[0][i] = dp[1][i-1] + dp[0][i-1];
            dp[1][i] = dp[0][i-1];
        }
       bw.write((dp[0][N] + dp[1][N]) + "\n");
        bw.close();
    }
}
