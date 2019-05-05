package alg_02_2019;
import java.io.*;
import java.util.*;
public class Alg11725 { // 1에서부터 BFS로 풀거임.
    static int[] answer; // index 1 - N
    static int N;
    static ArrayList<LinkedList<Integer>> adjlist;
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        answer = new int[N+1];
        adjlist = new ArrayList<LinkedList<Integer>>(N+1);
        for(int i = 0; i < N+1; i++)
            adjlist.add(new LinkedList<Integer>()); // N+1개 생성
        StringTokenizer st; int a, b;
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(b);
            adjlist.get(b).add(a);
        }
        bfs();
        for(int i = 2; i <= N; i++)
            bw.write(answer[i] + "\n");
        bw.close();
    }
    static void bfs(){
        LinkedList<Integer> bfsQ = new LinkedList<Integer>();
        boolean[] visited = new boolean[N+1]; // index 1 - N
        Arrays.fill(visited, false);
        bfsQ.add(1);
        while(!bfsQ.isEmpty()){
            int temp = bfsQ.poll();
            for(int i : adjlist.get(temp))
                if(!visited[i]){
                bfsQ.add(i);
                answer[i] = temp;
                    visited[i] = true;
                }
        }
    }
}
