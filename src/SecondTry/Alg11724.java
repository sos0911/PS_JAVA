package SecondTry;
import java.util.*;
import java.io.*;
public class Alg11724 {
    static ArrayList<LinkedList<Integer>> adjlist = new ArrayList<LinkedList<Integer>>(1001);
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N+1; i++)
            adjlist.add(new LinkedList<Integer>());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(b);
            adjlist.get(b).add(a);
        }
        System.out.println(bfs());
    }
    static int bfs(){ // 1 - N번째 노드까지 모두 탐색
        boolean[] visited = new boolean[N+1];
        int answer = 0;
        LinkedList<Integer> bfsQ = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++)
            if(!visited[i]){
                bfsQ.add(i);
             visited[i] = true;
                answer++;
                while(!bfsQ.isEmpty()){
                    int temp = bfsQ.poll();
                    for(int j : adjlist.get(temp))
                        if(!visited[j]){
                            bfsQ.add(j);
                         visited[j] = true;   
                        }
                }
            }
        return answer;
    }
}
