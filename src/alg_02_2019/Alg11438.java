package alg_02_2019;
import java.io.*;
import java.util.*;

public class Alg11438 {
    static int[] depth;
    static int maxN = 100000, maxD = 17; // WC(노드 수 최대 & 일렬트리)에도 2^17번째 조상까지 탐색하면 루트 노드를 커버 가능
    static int[][] parent;
    static ArrayList<ArrayList<Integer>> adjlist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        depth = new int[N+1]; // 0으로 초기화
        parent = new int[maxN+1][maxD+1]; // node x의 2^y번째 조상을 저장
        adjlist = new  ArrayList<ArrayList<Integer>>(N+1);
        for(int i = 0; i <= N; i++)
            adjlist.add(new ArrayList<Integer>());
        StringTokenizer st;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(b);
             adjlist.get(b).add(a);
        }
        dfs(1, 0); // root의 parent는 0
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            bw.write(lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
        }
        bw.close();
    }
    static void dfs(int node, int par){
        depth[node] = depth[par]+1;
        parent[node][0] = par; // node의 1번째 조상 저장
        
        for(int i = 1; i <= maxD; i++){ // 전처리 과정 :: dfs로 훑으면서 각 노드의 2 제곱꼴번쨰의 가능한 조상을 모두 저장한다.
            int temp = parent[node][i-1];
            parent[node][i] = parent[temp][i-1];
        }
        for(int i : adjlist.get(node))
            if(i != par) // 부모로 back하는 것만 걸러낸다.
                dfs(i, node);
    }
    static int lca(int a, int b){ // 무조건 b를 올려줄 거에요. 조건 안맞으면 swap
        if(depth[a] != depth[b]){
            if(depth[a] > depth[b]){
                int temp = a;
                a = b;
                b = temp;
            }
            for(int i = maxD; i >= 0; i--) // 높이를 맞춰준다.
                if(depth[a] <= depth[parent[b][i]])
                    b = parent[b][i];
        }
            if(a != b){ // 높이를 맟춘 후 같지 않으면 둘이 같은 양씩 올려주면서 답 바로 전에 멈춤
                for(int i = maxD; i >= 0; i--)
                    if(parent[a][i] != parent[b][i]){
                        a = parent[a][i];
                        b = parent[b][i];
                    }
          return parent[a][0];
            }
        else
            return a;
        }
    }
