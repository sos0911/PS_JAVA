/*package alg_02_2019;
import java.io.*;
import java.util.*;
class Pair<N, V>{ // node, vertex. 어떤 자료형이 오더라도 대응 가능
    N node;
    V vertex;
    public Pair(N node, V vertex){
        this.node = node;
        this.vertex = vertex;
    }
}
public class Alg1167 { // 가중치 있는 트리 내의 dfs! cycle이 있으면 안됨!
    static ArrayList<LinkedList<Pair>> adjlist; // 인접 리스트(가중치) / index 1 - Nofn까지 사용
    static int Nofn;
    static int[] degree; // 차수 모음
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Nofn = Integer.parseInt(br.readLine());
        adjlist = new ArrayList<LinkedList<Pair>>(Nofn+1);
        for(int i = 0; i < Nofn+1; i++)
            adjlist.add(new LinkedList<Pair>());
        degree = new int[Nofn+1]; // index 1 - Nofn
        String[] temp;
        for(int i = 0; i < Nofn; i++){
            temp = br.readLine().split(" ");
            int node = Integer.parseInt(temp[0]); // 메인 node
            int j = 1;
            while(!temp[j].equals("-1")){
                degree[node]++; // 해당 node degree++;
                int N = Integer.parseInt(temp[j++]);
                int V = Integer.parseInt(temp[j++]);
                adjlist.get(node).add(new Pair(N, V));
                adjlist.get(N).add(new Pair(node, V));
            }
        }
        System.out.println((int)bfs((int)bfs(1).node).vertex);
    }
    static Pair bfs(int node){ // leaf node에서 bfs -> 목적지 노드 / 최장 길이 반환
            LinkedList<Pair> bfsQ = new LinkedList<Pair>();
            boolean[] visited = new boolean[Nofn+1];
        Pair bfsA = new Pair(node, -1); // bfs 답
        Arrays.fill(visited, false);
            bfsQ.add(new Pair(node, 0)); // node부터 bfs 시작
            visited[node] = true;
            while(!bfsQ.isEmpty()){
                Pair temp = bfsQ.poll();
                for(Pair p : adjlist.get((int)temp.node))
                    if(!visited[(int)p.node]){
                         if(degree[(int)p.node] == 1){ // leaf node => queue에 안 넣고 비교 후 답 갱신
                             if((int)temp.vertex + (int)p.vertex > (int)bfsA.vertex){
                                 bfsA.node = p.node;
                                 bfsA.vertex = (int)temp.vertex + (int)p.vertex;
                             }
                         }
                        else // not leaf node -> queue에 넣음
                        bfsQ.add(new Pair(p.node, (int)temp.vertex + (int)p.vertex));
                        visited[(int)p.node] = true;
                    }
            }
        return bfsA;
        }
    }
    */