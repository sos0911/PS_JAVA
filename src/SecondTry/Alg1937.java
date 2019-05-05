package SecondTry;
import java.io.*;
import java.util.*;

public class Alg1937 {
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;
    static int N;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
      public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          N = Integer.parseInt(br.readLine());
         map = new int[N][N];
          visited = new boolean[N][N];
          StringTokenizer st;
          for(int i = 0; i < N; i++){
              st = new StringTokenizer(br.readLine());
              for(int j = 0; j < N; j++)
                  map[i][j] = Integer.parseInt(st.nextToken());
          }
          dp = new int[N][N];
          for(int[] arr : dp)
              Arrays.fill(arr, -1);
          // dp[y][x] : (y,x)에서 출발하는 부분 경로의 최대 cost
          int ans = -1;
          for(int i = 0; i < N; i++)
              for(int j = 0; j < N; j++)
                  ans = Math.max(ans, dfs(i, j));
          System.out.println(ans);
      }
    static int dfs(int y, int x){
       if(dp[y][x] != -1)
           return dp[y][x];
        int tans = 1; // 자기 자신
        for(int i = 0; i < 4; i++){
            int nexty = y + dir[i][0];
            int nextx = x + dir[i][1];
            if(nexty >= 0 && nexty < N && nextx >= 0 && nextx < N && !visited[nexty][nextx] && map[nexty][nextx] > map[y][x]){
            visited[nexty][nextx] = true;
            tans = Math.max(tans, 1 + dfs(nexty, nextx));
          visited[nexty][nextx] = false;
            }
        }
        return dp[y][x] = tans;
    }
}
