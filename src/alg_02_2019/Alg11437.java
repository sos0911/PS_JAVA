package alg_02_2019;
import java.util.*;
import java.io.*;

public class Alg11437 {
    static int[] depth; // root의 depth는 1
    static int[] parent;
    static ArrayList<LinkedList<Integer>> adjlist; // 인접 리스트
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        depth = new int[N+1];
        parent = new int[N+1];
        adjlist = new ArrayList<LinkedList<Integer>>(N+1);
        for(int i = 0; i <= N; i++)
            adjlist.add(new LinkedList<Integer>());
        StringTokenizer st;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(b);
            adjlist.get(b).add(a);
        }
        dfs(1, 1, 0); // 루트가 1로 정해져 있음 / 루트의 부모는 0으로 정함(전처리 과정)
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ad = depth[a];
            int bd = depth[b];
            while(ad > bd){
                a = parent[a];
                ad--;
            }
            while(bd > ad){
                b = parent[b];
                bd--;
            }
            while(a != b){
                a = parent[a];
                b = parent[b];
            }
           System.out.println(a); 
        }
    }
    static void dfs(int node, int d, int p){
        depth[node] = d;
        parent[node] = p;
        for(int i : adjlist.get(node))
            if(i != p) // 다시 돌아가는 경우는 제외
                dfs(i, d+1, node);
    }
}
