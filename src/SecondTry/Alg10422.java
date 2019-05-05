package SecondTry;
import java.io.*;
import java.util.*;

public class Alg10422 { // 폐기 ㅅㅂ
    
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int mod = 1000000007;
        long[][] dp = new long[5001][2]; // 1 - 5000
        // [0]은 대칭인것 / [1]은 대칭이 아닌것
        dp[0][0] = 1; // 편의를 위해
        dp[2][0] = 1; dp[2][1] = 0;
        dp[4][0] = 2; dp[4][1] = 0;
     for(int i = 6; i <= 5000; i += 2){
         dp[i][0] += dp[i-2][0]; // [s] / () + s + () / (()) + s + (()) .. -> 
         for(int j = 0; j <= i-4; j += 2)
             if((i-j)/2 %2 == 0)
             dp[i][0] += dp[j][0]*dp[(i-j)/2][0];
         // dp[i][0] :: 똑같은거 두 개 붙여서 대칭되는 경우도 생각해야함..
        dp[i][1] += (dp[i-2][1] + 2*(dp[i-2][0] + dp[i-2][1]) - 2*dp[i-4][0])%mod;
         // [s] / () + s or s + ()인데 거기서 대칭 문자열 제함
     }
        int Noftc = Integer.parseInt(br.readLine());
        for(int i = 0; i < Noftc; i++){
            int temp = Integer.parseInt(br.readLine());
            bw.write((dp[temp][0] + dp[temp][1])%mod + "\n");
            bw.write("dp : " + temp + " :: " + dp[temp][0] + " " + dp[temp][1] + "\n");
        }
        bw.close();
    }
}
// 카탈란 수??
/*
근데 이러한 방법으로 하면
(())()(()) 이런 건 어쩌게(dp[8][0]에서 누락됨)
*/
