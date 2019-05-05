package alg_03_2019;
import java.io.*;
import java.util.*;
class node6118{
    int V, E; // 노드 번호와 값
    public node6118(int V, int E){
        this.V = V;
        this.E = E;
    }
}
public class Alg6118 {
    static int[] dist; // 1번 헛간부터의 최소 거리
    static int INF = 25000;
    static int N, M;
    static ArrayList<ArrayList<Integer>> adjlist;
    public static void main(String[] args) throws IOException{ // priQ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjlist = new ArrayList<ArrayList<Integer>>(N+1); // 1부터
        dist = new int[N+1]; // 1부터
        for(int i = 0; i <= N; i++)
            adjlist.add(new ArrayList<Integer>());
        int a, b;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(b);
            adjlist.get(b).add(a);
        }
        Arrays.fill(dist, INF);
        dist[1] = 0;
        dijkstra();
        int maxN = -1, max = -1, Nofmax = 0; // 헛간 번호 / 헛간 거리 / 헛간 개수 
        for(int i = 1; i < N+1; i++)
            if(dist[i] != INF)
                if(dist[i] > max){ // max값 갱신
                    maxN = i;
                    max = dist[i];
                    Nofmax = 1;
                }
                else if(dist[i] == max)
                    Nofmax++;
        System.out.println(maxN + " " + max + " " + Nofmax);
    }
    static void dijkstra(){
        PriorityQueue<node6118> priQ = new PriorityQueue<node6118>(M, (node6118 n1, node6118 n2) -> n1.E > n2.E? 1 : -1);
        priQ.add(new node6118(1, 0));
        while(!priQ.isEmpty()){
            node6118 temp = priQ.poll();
            if(dist[temp.V] < temp.E)
                continue;
            for(int i : adjlist.get(temp.V)){
                int nextn = i;
                int nextd = temp.E + 1;
                if(dist[nextn] > nextd){
                    dist[nextn] = nextd;
                    priQ.add(new node6118(nextn, nextd));
                }
            }
        }
    }
}
