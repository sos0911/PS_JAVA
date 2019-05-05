package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg9095 {
    static int[] dp = new int[11]; // 0 - 10
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int NofT = Integer.parseInt(br.readLine());
        for(int i = 3; i < 11; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        for(int i = 0; i < NofT; i++)
            bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
        bw.close();
    }
}
