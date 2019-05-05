package alg_01_2019;
import java.io.*;
import java.util.*;
public class Alg1890 {
    static int N;
    static int[][] map; // (y, x)
    static long[][] dp; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        for(long[] arr : dp)
            Arrays.fill(arr, -1);
        String[] temp;
        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(temp[j]);
        }
        System.out.println(dfs(0, 0));
    }
    static long dfs(int y, int x){
        if(y < 0 || y >= N || x < 0 || x >= N) // 범위 벗어남
            return 0;
        if(y == N-1 && x == N-1) // 목표지점 도달
            return 1;
        else if(map[y][x] == 0) // 도달한 건 아닌데 더 이상 진행 불가
            return 0;
        if(dp[y][x] != -1) // 메모이제이션
            return dp[y][x];
        return dp[y][x] = dfs(y + map[y][x], x) + dfs(y, x + map[y][x]);
    }
}
