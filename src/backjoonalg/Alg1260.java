/*package backjoonalg;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;

public class Alg1260 {
    static List<Integer>[] Graph;
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean[] visited; // 방문 여부 배열
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Nofnodes = Integer.parseInt(st.nextToken());
        int Nofvertex = Integer.parseInt(st.nextToken());
        int StartNode = Integer.parseInt(st.nextToken());
        visited = new boolean[Nofnodes+1]; // index 1 - Nofnodes까지 사용
        Arrays.fill(visited, false);
        Graph = new List[Nofnodes+1]; // 그래프 정보를 저장할 global linkedlist 배열(index 1 - Nofnodes 까지 사용)
        for(int i = 0; i < Nofnodes+1; i++)
            Graph[i] = new LinkedList<Integer>();
        
        for(int i = 0; i < Nofvertex; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Graph[x].add(y);
            Graph[y].add(x);
        }
        for(List<Integer> i : Graph)
        Collections.sort(i); // 내용물 오름차순 정렬
        
        DFSusingS(StartNode);
        bw.newLine(); // 줄 개행
        Arrays.fill(visited, false); // 방문배열 초기화
        BFSusingQ(StartNode);
        bw.close();
    }
    static void DFSusingS(int StartNode) throws IOException{ // stack을 이용한 dfs
        Stack<Integer> s = new Stack<Integer>();
        boolean flag; // while문 내 for문이 끝나면 요소를 꺼낼지 말지 결정
        s.push(StartNode);
        visited[StartNode] = true;
        bw.write(StartNode + " ");
        
        while(!s.empty()){
            int top = s.peek();
            flag = false;
            for(int i : Graph[top]){
                if(!visited[i]){ // 방문을 하지 않은 node라면 방문한다.(dfs)
                    s.add(i);
                    bw.write(i + " ");
                    flag = true;
                    visited[i] = true;
                break;
                }
            }
            if(!flag) // for문에서 방문하지 않은 노드를 찾지 못함
                s.pop();
        }
    }
    static void BFSusingQ(int StartNode) throws IOException{ // queue를 이용한 bfs
        Queue<Integer> q = new LinkedList<Integer>(); // queue<>()
        q.add(StartNode);
        visited[StartNode] = true;
         //bw.write(StartNode + " ");
        
        while(!q.isEmpty()){
            int first = q.poll();
           bw.write(first + " ");
            for(int i : Graph[first]){
                if(!visited[i]){ // 방문을 하지 않은 노드라면.. (bfs)
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
}
}*/
