package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg2660 {
    
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int INF = 200; // 가능한 adj[][]보다 큰 수면 됨
        int[][] adj = new int[N+1][N+1]; // 1부터
        for(int[] i : adj)
            Arrays.fill(i, INF);
        for(int i = 1; i <= N; i++)
            adj[i][i] = 0;
        StringTokenizer st;
        int a, b;
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1)
                break;
            adj[a][b] = 1;
            adj[b][a] = 1; // 양방향
        }
        int min = 3000, minN = 0;
        int[] sum = new int[N+1]; // 1부터 점수 저장
        for(int k = 1; k <= N; k++)
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    if(k == N)
                        sum[i] = Math.max(sum[i], adj[i][j]);
                }
                if(k == N)
                    if(sum[i] < min){
                        min = sum[i];
                        minN = 1; // 더 작은 수치가 있으므로 minN도 초기화
                    }
                    else if(sum[i] == min)
                        minN++;    
            }
        bw.write(min + " " + minN + "\n");
        for(int i = 1; i <= N; i++)
            if(sum[i] == min)
                bw.write(i + " ");
        bw.close();
    }
}
