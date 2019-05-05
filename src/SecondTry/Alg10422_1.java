package SecondTry;
import java.io.*;
import java.util.*;

public class Alg10422_1 {
    
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          int mod = 1000000007;
        long[][] dp = new long[2501][2501]; // N/2 <= 2500
        // dp[x][y] = (가 x개, )가 y개까지 그려진 괄호 문자열(미완 가능)
        // 그려지는 와중에 (가 ) 개수보다 작으면 바로 fail
        // dp[x][y] = dp[x-1][y] + dp[x][y-1];
        // dp[x][0]은 모두 1
        for(int i = 1; i <= 2500; i++)
            dp[i][0] = 1;
        dp[1][1] = 1; // 초기값
        for(int i = 2; i <= 2500; i++)
            for(int j = 1; j <= i; j++){
                dp[i][j] += (dp[i-1][j] + dp[i][j-1])%mod; // (() + ) ..
             dp[i][j] %= mod;   
            }
        int Noftc = Integer.parseInt(br.readLine());
        for(int i = 0; i < Noftc; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp%2 != 0)
                bw.write(0 + "\n");
            else
            bw.write(dp[temp/2][temp/2] + "\n");
        }
        bw.close();
    }
}
