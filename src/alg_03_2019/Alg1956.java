package alg_03_2019;
import java.io.*;
import java.util.*;
public class Alg1956 {
    
    public static void main(String[] args) throws IOException{
        // 서로 다른 두 노드 간 같은 방향 도로는 무조건 1개라고 가정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] adj = new int[V+1][V+1]; // 1부터
        int INF = 9000000;
        for(int[] i : adj)
            Arrays.fill(i, INF);
        for(int i = 1; i <= V; i++)
            adj[i][i] = 0;
        int a, b, c;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj[a][b] = c;
        }
        // floyd
        for(int k = 1; k <= V; k++)
            for(int i = 1; i <= V; i++)
                for(int j = 1; j <= V; j++)
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
        int answer = INF;
        for(int i = 1; i <= V; i++)
            for(int j = i+1; j <= V; j++)
                    answer = Math.min(answer, adj[i][j] + adj[j][i]);
        if(answer == INF)
            System.out.println(-1);
        else
        System.out.println(answer);
    }
}
