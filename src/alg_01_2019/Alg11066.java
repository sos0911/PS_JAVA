package alg_01_2019;
import java.io.*;
import java.util.*;

public class Alg11066 {
    static int Nofp;
    static int[] input = new int[501]; // index 1부터 사용
    static int[][] dp = new int[501][501];
    static int[] partsum = new int[501]; // index 1-i까지 더한 부분합 
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Noftc = Integer.parseInt(br.readLine());
        String[] temp;
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        for(int i = 0; i < Noftc; i++){
            Nofp = Integer.parseInt(br.readLine()); // 장 수
            temp = br.readLine().split(" ");
            for(int j = 1; j <= Nofp; j++){
            input[j] = Integer.parseInt(temp[j-1]);
            partsum[j] = partsum[j-1] + input[j];
            }
            System.out.println(dfsdp(1, Nofp));
            for(int j = 1; j < Nofp; j++)
                Arrays.fill(dp[j], -1); // 초기화
        }
    }
    static int dfsdp(int i, int j){ // (i, j) 구간의 최소비용 반환
        if(i == j)
            return 0;
        if(j - i == 1) // 기저 사례 : 각각을 만드는 최소비용이 없는 기저 사례임
            return input[i] + input[j];
        if(dp[i][j] != -1)
            return dp[i][j];
        int temp = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) // 이 for문을 돈다는 것은 차이가 2 이상
            temp = Math.min(temp, dfsdp(i, k) + dfsdp(k+1, j));
        return dp[i][j] = temp + partsum[j] - partsum[i-1];
    }
}
