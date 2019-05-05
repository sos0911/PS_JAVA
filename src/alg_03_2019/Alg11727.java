package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg11727 {
    static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.fill(dp, -1);
        dp[1] = 1; dp[2] = 3;
        int N = Integer.parseInt(br.readLine());
        for(int i = 3; i < 1001; i++)
            dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
        bw.write(dp[N] + "\n");
        bw.close();
    }
}
