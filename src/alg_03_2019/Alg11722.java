package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg11722 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] dp = new int[N]; // 0 -
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());
        // dp[i] = input[i]로 끝나는 감소 수열 중 가장 긴 길이
        Arrays.fill(dp, 1); // 시작값은 자기 자신
        for(int i = 0; i < N; i++)
            for(int j = 0; j < i; j++)
                if(input[j] > input[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        int max = -1;
        for(int i = 0; i < N; i++)
            max = Math.max(max, dp[i]);
        System.out.println(max);
    }
}
