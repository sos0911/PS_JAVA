package alg_03_2019;
import java.io.*;
import java.util.*;
class point{
    int y, x;
    public point(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Alg4485 {
    static int[][] dist; // 최소 거리 저장
    static int[][] adj; // 입력 맵 저장
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int INF = 15000;
    public static void main(String[] args) throws IOException{
        // 잃는 금액을 최소로 하는 경로 find
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int index = 1;
        dist = new int[125][125];
        adj = new int[125][125]; // 0부터
        StringTokenizer st;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0)
                break;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++)
                    adj[i][j] = Integer.parseInt(st.nextToken());
            }
           dijkstra(N); // map 크기 전달
            bw.write("Problem " + (index++) + ": " + (adj[0][0] + dist[N-1][N-1]) + "\n");
        }
        bw.close();
    }
    static void dijkstra(int size){ // map size
        for(int[] i : dist)
            Arrays.fill(i, INF);
        boolean[][] visited = new boolean[size][size]; // false로 초기화
        dist[0][0] = 0;
        while(true){
            int closest = INF;
            point here = new point(-1, -1);
            for(int i = 0; i < size; i++) // 가장 가까운 노드를 찾는다.
                for(int j = 0; j < size; j++)
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
                if(nexty >= 0 && nexty < size && nextx >= 0 && nextx < size){
                    if(visited[nexty][nextx])
                        continue;
                    dist[nexty][nextx] = Math.min(dist[nexty][nextx], dist[here.y][here.x] + adj[nexty][nextx]);
                }
            }
        }
    }
}
