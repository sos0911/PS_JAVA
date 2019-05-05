package alg_03_2019;
import java.io.*;
import java.util.*;
class Point{
    int y, x;
    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Alg1261 {
    static int[][] dist; // 최소 거리 저장
    static int[][] adj; // 입력 맵 저장
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int INF = 200;
    public static void main(String[] args) throws IOException{
        // 잃는 금액을 최소로 하는 경로 find
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        dist = new int[N][M];
        adj = new int[N][M]; // 0부터
            for(int i = 0; i < N; i++){
               String temp = br.readLine();
                for(int j = 0; j < M; j++)
                    adj[i][j] = temp.charAt(j) - '0';
            }
        dijkstra(N, M); // size 전달
        System.out.println(dist[N-1][M-1]);
    }
    static void dijkstra(int N, int M){ // map size
        for(int[] i : dist)
            Arrays.fill(i, INF);
        boolean[][] visited = new boolean[N][M]; // false로 초기화
        dist[0][0] = 0;
        while(true){
            int closest = INF;
            Point here = new Point(-1, -1);
            for(int i = 0; i < N; i++) // 가장 가까운 노드를 찾는다.
                for(int j = 0; j < M; j++)
                    if(dist[i][j] < closest && !visited[i][j]){
                        here.y = i;
                        here.x = j;
                        closest = dist[i][j];
                    }
            if(closest == INF)
                break;
            visited[here.y][here.x] = true; // dist[][]는 이 시점에서 고정됨
            for(int i = 0; i < 4; i++){
                int nexty = here.y + dir[i][0];
                int nextx = here.x + dir[i][1];
                if(nexty >= 0 && nexty < N && nextx >= 0 && nextx < M){
                    if(visited[nexty][nextx])
                        continue;
                    dist[nexty][nextx] = Math.min(dist[nexty][nextx], dist[here.y][here.x] + adj[nexty][nextx]);
                }
            }
        }
    }
}
