package SecondTry;
import java.io.*;
import java.util.*;
class Infom{ // 인접 노드의 번호, vertex
    int node, vertex;
    public Infom(int node, int vertex){
        this.node = node;
        this.vertex = vertex;
    }
}
public class Alg1967 { // tree이므로 유방향 그래프로 보겠음.
    static int Nofn;
    static ArrayList<LinkedList<Infom>> adjlist; // 각 노드의 인접한 노드의 정보 저장
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Nofn = Integer.parseInt(br.readLine());
        adjlist = new ArrayList<LinkedList<Infom>>(Nofn+1); // index 1 - Nofn
        for(int i = 0; i < Nofn+1; i++)
            adjlist.add(new LinkedList<Infom>());
        StringTokenizer st;
        for(int i = 0; i < Nofn-1; i++){
            st = new StringTokenizer(br.readLine());
            int mn = Integer.parseInt(st.nextToken());
            int sn = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjlist.get(mn).add(new Infom(sn, v));
            adjlist.get(sn).add(new Infom(mn, v));
        }
        System.out.println(farthest(farthest(1).node).vertex); 
    }
    static Infom farthest(int node){ // node로부터 가장 먼 노드 번호와 길이를 Infom형으로 반환
        boolean[] visited = new boolean[Nofn+1]; // false로 초기화
        visited[node] = true;
        Infom answer = new Infom(1, 0);
        LinkedList<Infom> bfsQ = new LinkedList<Infom>();
        bfsQ.add(new Infom(node, 0));
        while(!bfsQ.isEmpty()){
            Infom temp = bfsQ.poll();
            visited[temp.node] = true;
            if(temp.node != node && adjlist.get(temp.node).size() == 1){ // leaf node에 다다를 시 답이 현재 답보다 크면 갱신하고 continue
                if(temp.vertex > answer.vertex){
                answer.vertex = temp.vertex;
                answer.node = temp.node;   
                }
            }
            else
            for(Infom i : adjlist.get(temp.node))
                if(!visited[i.node])
                bfsQ.add(new Infom(i.node, temp.vertex + i.vertex));
        }
        return answer;
    }
}