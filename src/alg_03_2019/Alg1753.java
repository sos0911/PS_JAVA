package alg_03_2019;
import java.io.*;
import java.util.*;
class Info{
    int node, vertex;
    public Info(int node, int vertex){
        this.node = node;
        this.vertex = vertex;
    }
}
public class Alg1753 {
    static ArrayList<ArrayList<Info>> adjlist;
    static int[] dist; // 시작점에서 node까지의 최소 거리
    static int V, E;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjlist = new ArrayList<ArrayList<Info>>(V+1); // 1부터
        for(int i = 0; i <= V; i++)
            adjlist.add(new ArrayList<Info>());
        int start = Integer.parseInt(br.readLine()); // 시작점
        dist = new int[V+1]; // 1부터
        Arrays.fill(dist, INF); // INF로 채우기
        dist[start] = 0; // 시작점까지 거리는 0
        int a, b, c;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(new Info(b, c));
        }
        dijkstra();
        for(int i = 1; i <= V; i++)
            bw.write((dist[i] == INF? "INF" : dist[i]) + "\n");
        bw.close();
    }
    static void dijkstra(){ // priQ 사용x
       boolean[] visited = new boolean[V+1]; // false 초기화
        while(true){
            int closest = INF, here = -1;
            for(int i = 1; i <= V; i++) // 반복문마다 가장 가까운 node를 찾는다
                if(dist[i] < closest && !visited[i]){
                    here = i;
                    closest = dist[i];
                }
            if(closest == INF) // 더 이상 방문할 node가 없음
                break;
            visited[here] = true;
            for(Info i : adjlist.get(here)){
                int nextn = i.node;
                if(visited[nextn])
                    continue;
                int nextd = dist[here] + i.vertex;
                dist[nextn] = Math.min(dist[nextn], nextd);
            }
        }
    }
}
