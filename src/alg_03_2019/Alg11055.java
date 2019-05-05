package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg11055 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N]; // 0 -
        int[] dp = new int[N]; // 0 -
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            input[i] = temp;
            dp[i] = temp; // 시작은 자기 자신 포함
        }
        for(int i = 0; i < N; i++)
            for(int j = 0; j < i; j++)
                if(input[i] > input[j])
                dp[i] = Math.max(dp[i], dp[j] + input[i]);
        int max = -1;
       for(int i = 0; i < N; i++)
           max = Math.max(max, dp[i]);
        System.out.println(max);
    }
}

// dp[i] = input[i]로 끝나는 증가 부분 수열 중 최대합

