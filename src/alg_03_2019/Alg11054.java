package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg11054 {
    
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] dp = new int[N]; // 가장 긴 증가 부분 수열
        int[] dp2 = new int[N]; // 가장 긴 감소 부분 수열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());
         Arrays.fill(dp, 1); // 시작값은 자기 자신
         Arrays.fill(dp2, 1); // 시작값은 자기 자신
        for(int i = 0; i < N; i++)
            for(int j = 0; j < i; j++)
                if(input[i] > input[j])
                dp[i] = Math.max(dp[i], dp[j] + 1);
        for(int i = N-1; i >= 0; i--)
            for(int j = i+1; j < N; j++)
                if(input[i] > input[j])
                dp2[i] = Math.max(dp2[i], dp2[j] + 1);
        int max = -1;
        for(int i = 0; i < N; i++)
            max = Math.max(max, dp[i] + dp2[i]);
        System.out.println(max-1); // dp[i]가 두번 들어가요!
    }
}
