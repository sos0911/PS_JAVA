package alg_02_2019;
import java.io.*;
import java.util.*;
class Info5{
    int node, vertex;
    public Info5(int node, int vertex){
        this.node = node;
        this.vertex = vertex;
    }
}
public class Alg1761 { // lca 사용. root가 미정이므로 임의로 정하자
    // lca 문제와 다른 것은 거리를 구하는 것뿐. 두 노드 사이의 가장 가까운 공통 조상을 찾아 경로를 구해내는 것은 똑같음
    static int[] depth;
    static int[][] parent; 
    static int[] dist; // 1과 나머지 노드들 사이의 거리
    static int maxN = 40000, maxD = 16;
     static ArrayList<ArrayList<Info5>> adjlist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        depth = new int[N+1]; // 0으로 초기화
        parent = new int[maxN+1][maxD+1]; // node i의 2^j번째 조상을 저장
        dist = new int[N+1];
        adjlist = new ArrayList<ArrayList<Info5>>(N+1);
        for(int i = 0; i < N+1; i++)
            adjlist.add(new ArrayList<Info5>());
        StringTokenizer st;
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(new Info5(b, c));
             adjlist.get(b).add(new Info5(a, c));
        }
        dfs(1, 0, 0);
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
             bw.write(lca(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())) + "\n");
        }
        bw.close();
    }
    static void dfs(int node, int par, int dis){ // root의 부모는 0으로 가정
        depth[node] = depth[par]+1;
        parent[node][0] = par;
        dist[node] = dis;
        for(int i = 1; i <= maxD; i++)
        parent[node][i] = parent[parent[node][i-1]][i-1];
        
        for(Info5 in : adjlist.get(node))
            if(in.node != par)
                dfs(in.node, node, dis + in.vertex);
    }
    static int lca(int a, int b){ // a - b사이의 거리를 반환(using lca) / b를 올려줄 것
        int oria = a, orib = b; // 원래 ab 저장
        if(depth[a] != depth[b]){
            if(depth[a] > depth[b]){
                int temp = a;
                a = b;
                b = temp;
            }
            for(int i = maxD; i >= 0; i--)
                if(depth[a] <= depth[parent[b][i]])
                    b = parent[b][i];
        }
        int is; // 교차점(lca)
        if(a != b){
            for(int i = maxD; i >= 0; i--)
                if(parent[a][i] != parent[b][i]){
                    a = parent[a][i];
                    b = parent[b][i];
                }
            is = parent[a][0];
        }
        else
            is = a;
        return dist[oria] + dist[orib] - 2*dist[is];
    }
}
