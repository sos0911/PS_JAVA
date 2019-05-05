package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1389 {
    
    public static void main(String[] args) throws IOException{
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
        int INF = 300;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] adj = new int[N+1][N+1];
        for(int[] i : adj)
            Arrays.fill(i, INF);
        for(int i = 1; i <= N; i++)
            adj[i][i] = 0;
        int a, b;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a][b] = 1;
            adj[b][a] = 1; // 친구 관계는 양방향
        }
        for(int k = 1; k <= N; k++)
            for(int i = 1; i <= N; i++)
                for(int j = 1; j <= N; j++)
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
        int answer = 10001, ap = -1;
        for(int i = 1; i <= N; i++){
            int temp = 0;
            for(int j = 1; j <= N; j++)
                temp += adj[i][j];
            if(answer > temp){
                answer = temp;
                ap = i;
            }
        }
        System.out.println(ap);
    }
}
