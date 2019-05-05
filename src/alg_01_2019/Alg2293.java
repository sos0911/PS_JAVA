package alg_01_2019;
import java.util.*;
import java.io.*;

public class Alg2293 {
    static int N, K, len;
    static int[] vofc; // 동전 가치 저장
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N = sc.nextInt();
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        //K = sc.nextInt();
        K = Integer.parseInt(temp[1]);
        dp = new int[10001][100];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        vofc = new int[N]; // index 0 - N-1
        for(int i = 0; i < N; i++)
            //vofc[i] = sc.nextInt();
            vofc[i] = Integer.parseInt(br.readLine());
        System.out.println(dfsdp(K, 0));
    }
    static int dfsdp(int left, int lastI){
        if(left == 0) // 기저 사례
            return 1;
        if(dp[left][lastI] != -1)
            return dp[left][lastI];
        int sum = 0;
        for(int i = lastI; i < N; i++)
            if(vofc[i] <= left)
                sum += dfsdp(left - vofc[i], i);
        return dp[left][lastI] = sum;
    }
}
/*
dp(int left, int lastI)

left : 남은 가치
lastI : 직전에 마지막으로 쓴 index

부분 문제 : 남은 가치와 마지막 index가 주어질 때
index부터 사용하여 남은 가치를 메우는 가짓수
반환

기저 사례 : 남은 가치가 0이면 1 반환

int = 4B

250*4000 정도밖에 안됨

1000000

dp = new int[10000][100]

==========================

int[10001];
*/