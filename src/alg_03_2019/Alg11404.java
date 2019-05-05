package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg11404 {
    
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int INF = 20000000;
        int[][] adjlist = new int[N+1][N+1]; // 도시 번호 : 1 -
        // i -> j로 가는 최소 비용 저장 / 0으로 초기화
        // 최소 경로는 1천만을 넘지 못하므로 int
        for(int[] i : adjlist)
            Arrays.fill(i, INF); // 큰 값으로 초기화
        for(int i = 1; i <= N; i++)
            adjlist[i][i] = 0; // 자기 자신으로의 경로는 0
        int M = Integer.parseInt(br.readLine());
        int a, b, c;
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(adjlist[a][b] > c)
                adjlist[a][b] = c;
        }
        for(int k = 1; k <= N; k++)
            for(int i = 1; i <= N; i++){
                if(adjlist[i][k] == INF)
                    continue;
                for(int j = 1; j <= N; j++)
                    adjlist[i][j] = Math.min(adjlist[i][j], adjlist[i][k] + adjlist[k][j]);
            }
        // 3중 for문 / 각 for문마다 1..k까지의 도시를 경유점으로 써서
        // i -> j까지 가는 최소 경로를 동적 계획법으로 구해낸다.
        // adjlist를 구성하는 단계에서 도시를 쓰지 않는 경로는 이미 구함
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++)
                if(adjlist[i][j] == INF)
                    bw.write("0 ");
                else
                    bw.write(adjlist[i][j] + " ");
         bw.newLine();   
        }
        bw.close();
    }
}
