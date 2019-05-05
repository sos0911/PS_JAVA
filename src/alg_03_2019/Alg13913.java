package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg13913 {
    static ArrayList<ArrayList<Integer>> adjlist; // 노드 간 연결관계 리스트
    static int N, K;
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adjlist = new ArrayList<ArrayList<Integer>>(100001); // 0 - 100000
        // 사실 각 노드당 간선은 무조건 1개 이하라 arraylist는 없어도 되는디..
        for(int i = 0; i <= 100000; i++)
            adjlist.add(new ArrayList<Integer>());
        System.out.println(bfs());
        int temp = K; // 역추적 시작
        Stack<Integer> ansstack = new Stack<Integer>();
        ansstack.push(temp);
        while(!adjlist.get(temp).isEmpty()){
            ansstack.push(adjlist.get(temp).get(0));
            temp = adjlist.get(temp).get(0);
        }
        while(!ansstack.isEmpty())
            bw.write(ansstack.pop() + " ");
        bw.close();
    }
    static int bfs(){ // 가장 빠른 시간 출력
        // 과정 중 i에서 j로 이동가능 시 j -> i 간선 생성
        LinkedList<Integer> bfsQ = new LinkedList<Integer>();
        bfsQ.add(N);
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        int bef = 1, af = 0, ans = 0;
        while(!bfsQ.isEmpty()){
            for(int i = 0; i < bef; i++){
                int temp = bfsQ.poll();
                if(temp == K)
                 return ans;   
                if(temp-1 >= 0 && !visited[temp-1]){
                    bfsQ.add(temp-1);
                    adjlist.get(temp-1).add(temp);
                    visited[temp-1] = true;
                    af++;
                }
                if(temp+1 <= 100000 && !visited[temp+1]){
                    bfsQ.add(temp+1);
                     adjlist.get(temp+1).add(temp);
                    visited[temp+1] = true;
                    af++;
                }
                if(temp*2 <= 100000 && !visited[temp*2]){
                    bfsQ.add(temp*2);
                     adjlist.get(temp*2).add(temp);
                    visited[temp*2] = true;
                    af++;
                }
            }
            bef = af;
            af = 0;
            ans++;
        }
        return -1; // impossible step
    }
}
