package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg9465 {
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 반복식 dp면 -1로 채우지 않아도 된다.
        // 공복 : 200000*4B*4 = 80만B*4 = 충분
        int[][] dp = new int[2][100001]; // 1 - 100000
        // dp[0][0], dp[1][0]은 항상 0
        int[][] input = new int[2][100001]; // 1 - 100000
        int Noftc = Integer.parseInt(br.readLine());
        for(int i = 0; i < Noftc; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for(int k = 0; k < 2; k++){
                st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++)
                input[k][j] = Integer.parseInt(st.nextToken());
            }
                dp[0][1] = input[0][1];
            dp[1][1] = input[1][1];
            for(int j = 2; j <= N; j++){
                dp[0][j] = Math.max(Math.max(dp[1][j-1], dp[1][j-2]) + input[0][j], dp[0][j-1]);
                dp[1][j] = Math.max(Math.max(dp[0][j-1], dp[0][j-2]) + input[1][j], dp[1][j-1]);
            }
            bw.write(Math.max(dp[0][N], dp[1][N]) + "\n");
        }
        bw.close();
    }
}
