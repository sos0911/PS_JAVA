package alg_01_2019;
import java.util.*;

public class Alg10844 {
    static int N;
    static int stN = 1000000000;
    static int[][] dp = new int[10][101]; // 처음 숫자가 0-9 / 길이가 0-100인 계단 수의 개수를 저장
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        long answer = 0;
        for(int i = 1; i < 10; i++){
            answer += dfsdp(i, N);
            answer %= stN;
        }
        System.out.println(answer);
    }
    static int dfsdp(int i, int len){
        if(len == 1) // 기저 사례
            return 1;
        if(dp[i][len] != -1)
            return dp[i][len];
        if(i == 0)
            return dp[i][len] = dfsdp(1, len-1) % stN;
        else if(i == 9)
            return dp[i][len] = dfsdp(8, len-1) % stN;
        else
            return dp[i][len] = (dfsdp(i+1, len-1) + dfsdp(i-1, len-1)) % stN;
    }
}
