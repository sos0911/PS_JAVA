package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1707 {
    static ArrayList<ArrayList<Integer>> adjlist;
    static int[] group = new int[20001]; // 그룹 1,2 / visited의 역할도 겸함
    static int V, E;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 양방향 그래프
        adjlist = new ArrayList<ArrayList<Integer>>(20001);
        for(int i = 0; i < 200001; i++)
            adjlist.add(new ArrayList<Integer>());
        int Noftc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < Noftc; i++){ // 매 for문마다 arr clear
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            for(int j = 0; j < E; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjlist.get(a).add(b);
                 adjlist.get(b).add(a);
            }
            boolean check = true;
           for(int j = 1; j <= V; j++)
               if(group[j] == 0 && !dfs(j, 1)){ // 조건 안맞으면 false 반환
                   check = false;
                   bw.write("NO\n");
                break;
               }
            if(check)
                bw.write("YES\n");
            // arraylist 초기화
            for(int j = 1; j <= V; j++){
                adjlist.get(j).clear();
                 group[j] = 0;   
            }
        }
        bw.close();
    }
    static boolean dfs(int here, int col){ // col은 묶을 그룹
          group[here] = col;
        for(int i : adjlist.get(here)) // 주위 돌면서 아직 방문x 노드가 있다면 dfs
            if(group[i] == 0){
                if(!dfs(i, (col%2) + 1))
                    return false;
            }
            else
                if(group[i] != (col%2)+1)
                    return false;
        return true;
    }
}
