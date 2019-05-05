package alg_03_2019;
import java.io.*;
import java.util.*;
class node1504{
    int node, edge;
    public node1504(int node, int edge){
        this.node = node;
        this.edge = edge;
    }
}
public class Alg1504 {
    static ArrayList<ArrayList<node1504>> adjlist;
    static int[] dist; // 출발점으로부터의 거리 저장
    static int N, E;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        // 간선이 ㅈㄴ 많으므로 priQ 안쓸거임 v^2 + E < ElogE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjlist = new ArrayList<ArrayList<node1504>>(N+1); // 1부터
        dist = new int[N+1]; // 1부터
        for(int i = 0; i < N+1; i++)
            adjlist.add(new ArrayList<node1504>());
        int a, b, c;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(new node1504(b, c));
             adjlist.get(b).add(new node1504(a, c)); // 양방향 그래프
        }
        st = new StringTokenizer(br.readLine());
        int i1 = Integer.parseInt(st.nextToken());
        int i2 = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, INF);
      dijkstra(i1);
        int over = dist[i2]; // i1 - i2간 거리
     long answer1 = 0, answer2 = 0;
       Arrays.fill(dist, INF);
        dijkstra(1);
        answer1 += dist[i1]; answer2 += dist[i2];
        Arrays.fill(dist, INF);
        dijkstra(N);
        answer1 += dist[i2]; answer2 += dist[i1];
       long FA = Math.min(answer1, answer2) + over;
        if(FA >= INF)
            System.out.println(-1);
        else
            System.out.println(FA);
    }
    static void dijkstra(int st){ // st부터 모든 edge까지의 거리를 계산
        boolean[] visited = new boolean[N+1]; // 1부터
        dist[st] = 0;
        while(true){
            int closest = INF, here = -1;
            for(int i = 1; i <= N; i++)
                if(dist[i] < closest && !visited[i]){
                    here = i;
                    closest = dist[i];
                }
            if(closest == INF)
                break;
            visited[here] = true;
            for(node1504 n : adjlist.get(here)){
                if(visited[n.node])
                    continue;
                int nextn = n.node, nextd = dist[here] + n.edge;
                dist[nextn] = Math.min(dist[nextn], nextd);
            }
        }
    }
}
