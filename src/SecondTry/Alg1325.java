package SecondTry;
import java.util.*;
import java.io.*;
public class Alg1325 {
    static ArrayList<ArrayList<Integer>> adjlist;
    static int[] visited, nodeval; // 방문 배열, 각 for문에서 초기화 없이 현재 탐색을 시작한 노드 번호 적기
    static int N, M, Cursn; // 현재 탐색하는 노드
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        adjlist = new ArrayList<ArrayList<Integer>>(N+1);
        for(int i = 0; i < N+1; i++)
            adjlist.add(new ArrayList<Integer>()); // 노드 수만큼 인접 리스트 생성(index 1 - N을 사용)
        visited = new int[N+1]; // index 1 - N
        for(int i = 0; i < M; i++){
           temp = br.readLine().split(" ");
        adjlist.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1])); // 단방향 인접 리스트
        }
        nodeval = new int[N+1]; // index 1 - N
        int max = -1; 
        for(int i = 1; i < N+1; i++){
            Cursn = i;
            dfs(i);
        }
        for(int i = 1; i < N+1; i++)
            if(nodeval[i] > max)
                max = nodeval[i];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N+1; i++)
            if(nodeval[i] == max)
                sb.append(i + " ");
        System.out.println(sb.toString());
    }
    static void dfs(int n){
        visited[n] = Cursn;
        for(int i : adjlist.get(n))
            if(visited[i] != Cursn){
                nodeval[i]++;
                dfs(i);
            }
    }
}