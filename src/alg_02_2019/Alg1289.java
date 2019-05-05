package alg_02_2019;
import java.io.*;
import java.util.*;
class Node4{
    int node, vertex;
    public Node4(int node, int vertex){ // 노드 index와 간선 길이
        this.node = node;
        this.vertex = vertex;
    }
}
public class Alg1289 { // 주의. bfs로 해결불가능
   static ArrayList<LinkedList<Node4>> adjlist; // 인접 리스트(그래프로 표현)
    static final int stN = 1000000007;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjlist = new ArrayList<LinkedList<Node4>>(N+1); // index 1부터
        for(int i = 0; i < N+1; i++)
            adjlist.add(new LinkedList<Node4>());
        StringTokenizer st;
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(new Node4(b, c));
            adjlist.get(b).add(new Node4(a, c));
        }
        long finalA = 0;
        for(int i = 1; i <= N; i++){
            finalA += bfs(i);    
         finalA %= stN;   
        }
        System.out.println(finalA);
    }
    static int bfs(int tar){ // Node4 tar부터 시작하여 bfs > 가중치 반환
        int answer = 0;
        LinkedList<Node4> bfsQ = new LinkedList<Node4>(); // 탐색하면서 얻은 가중치 합과 현재 노드를 저장
        boolean[] visited = new boolean[N+1]; // index 1 - 
        bfsQ.add(new Node4(tar, 1));
        visited[tar] = true;
        while(!bfsQ.isEmpty()){
            Node4 temp = bfsQ.poll();
            for(Node4 n : adjlist.get(temp.node))
                if(!visited[n.node]){ 
                    long tempL = ((long)temp.vertex*n.vertex)%stN;
                    bfsQ.add(new Node4(n.node, (int)tempL));
                    if(n.node > tar){ // node값이 tar보다 클 때만 답에 추가
                    answer += tempL;
                    answer %= stN;
                    }
                   visited[n.node] = true;   
                }
        }
        return answer;
    }
}
