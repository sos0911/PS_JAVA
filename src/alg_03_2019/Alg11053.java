package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg11053 {
    // N^2 시간복잡도 해결방법
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
        int[] input = new int[N]; // 0 - N-1
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[N]; // index i까지 봤을 때 i로 끝나는 수열의 최대 길이
        dp[0] = 1;
        int max = dp[0];
        for(int i = 1; i < N; i++){
            int ans = 1;
            for(int j = 0; j < i; j++)
                if(input[j] < input[i]) // 조건이 되면
                ans = Math.max(ans, dp[j] + 1);
            dp[i] = ans;
            max = Math.max(max, ans);
        }
        System.out.println(max);
    }
}
