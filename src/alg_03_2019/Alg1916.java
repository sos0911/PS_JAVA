package alg_03_2019;
import java.io.*;
import java.util.*;

class Bus{
    int des, cost; // 목적지와 비용
    public Bus(int des, int cost){
        this.des = des;
        this.cost = cost;
    } 
}
public class Alg1916 {
    static ArrayList<ArrayList<Bus>> adjlist;
    static int N, M;
    static int[] dist; // 시작점에서부터의 거리 저장
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjlist = new  ArrayList<ArrayList<Bus>>(N+1); // 1부터
        dist = new int[N+1]; // 1부터
        Arrays.fill(dist, INF);
        for(int i = 0; i < N+1; i++)
            adjlist.add(new ArrayList<Bus>());
        StringTokenizer st;
        int a, b, c;
        for(int i = 0; i < M; i++){ // 단방향 그래프
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(new Bus(b, c));
        }
         st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(dist[dest]);
    }
    static void dijkstra(int st){ // 시간복잡도 : O(V^2 + E)
        // 윗 for문을 v번 수행하고 아래 for문을 모든 간선에 대해 수행하므로 
     boolean[] visited = new boolean[N+1]; // 1부터
        dist[st] = 0;
        while(true){
            int closest = INF, here = -1;
        for(int i = 1; i <= N; i++) // 가장 가까운 node를 찾는다.
            if(dist[i] < closest && !visited[i]){
                here = i;
                closest = dist[i];
            }
        if(closest == INF)
            break;
        visited[here] = true; // 방문하면서 dist[here]은 확정된다.
        for(Bus b : adjlist.get(here)){
            if(visited[b.des])
                continue;
            int nextn = b.des, nextd = dist[here] + b.cost;
            dist[nextn] = Math.min(dist[nextn], nextd);
        }
    }
}
}
