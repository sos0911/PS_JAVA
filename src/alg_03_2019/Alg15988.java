package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg15988 {
    
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Noftc = Integer.parseInt(br.readLine());
        long dp[] = new long[1000001]; // 0 - 1000000 (정수)
        final int mod = 1000000009;
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for(int j = 4; j <= 1000000; j++)
             dp[j] = (dp[j-1] + dp[j-2] + dp[j-3])%mod;
        for(int i = 0; i < Noftc; i++){
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N] + "\n");
        }
        bw.close();
    }
}
