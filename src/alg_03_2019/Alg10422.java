package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg10422 {
    
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int mod = 1000000007;
        long[][] dp = new long[5001][2]; // 1 - 5000
        // [0]은 대칭인것 / [1]은 대칭이 아닌것
        dp[0][0] = 1; dp[0][1] = 0; // 편의를 위해
        dp[2][0] = 1; dp[2][1] = 0;
        dp[4][0] = 2; dp[4][1] = 0;
        for(int i = 6; i <= 5000; i += 2){ // dp[짝수]만 0이 아님
            //dp[i][0]
            dp[i][0] += dp[i-2][0]; // [s]
            for(int j = 0; j <= i-2; j += 2)
               if(((i-j)/2)%2 == 0)
                   dp[i][0] += dp[j][0]*dp[(i-j)/2][0]; // ㅡ _ ㅡ
            //dp[i][1]
            dp[i][1] += dp[i-2][1]; // [s]
            for(int j = 2; j <= i-2; j += 2){
                dp[i][1] += (dp[j][0] + dp[j][1])*(dp[i-j][0] + dp[i-j][1]); // st
                if(j > i/2)
                    dp[i][1] -= dp[j-(i-j)][0]*dp[i-j][0];
                else if(j == i/2)
                    dp[i][1] -= dp[i/2][0];
                else
                    dp[i][1] -= dp[(i-j)-j][0]*dp[j][0];
            }
        }
        int Noftc = Integer.parseInt(br.readLine());
        for(int i = 0; i < Noftc; i++){
            int temp = Integer.parseInt(br.readLine());
            bw.write((dp[temp][0] + dp[temp][1]) + "\n");
        }
        bw.close();
    }
}
