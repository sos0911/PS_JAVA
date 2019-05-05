package alg_01_2019;
import java.io.*;
import java.util.*;

public class Alg2156 {
    public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] info = new int[10001]; // index 1 - N
        int[] dp = new int[1000]; // index 0 - N / index 1 - I 범위에서 최댓값 저장
        for(int i = 1; i <= N; i++)
            info[i] = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = info[1];
        dp[2] = info[1] + info[2];
        for(int i = 3; i <= N; i++){
            dp[i] = dp[i-1];
            dp[i] = Math.max(dp[i-2] + info[i], dp[i]);
            dp[i] = Math.max(dp[i-3] + info[i-1] + info[i], dp[i]);
        }
        System.out.println(dp[N]);
    }
}
