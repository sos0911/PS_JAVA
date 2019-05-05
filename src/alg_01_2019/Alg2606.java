package alg_01_2019;
import java.util.*;

public class Alg2606 { // ?? 이것도 bfs로 풀어야 함?
    static List<LinkedList<Integer>> list;
    static int answer = 0;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        list =  new ArrayList<LinkedList<Integer>>(N+1); // N+1개의 공간을 만들어 index 1 - N까지 사용 
        visited = new boolean[N+1];
        Arrays.fill(visited, false);
        visited[1] = true; // 여기서부터 시작하므로
        for(int i = 0; i < N+1; i++)
            list.add(new LinkedList<Integer>());
        int Nofver = Integer.parseInt(sc.nextLine()); // 간선 갯수
        String temp; int a, b;
        for(int i = 0; i < Nofver; i++){
            a = sc.nextInt(); b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a); 
            sc.nextLine();
        }
        dfs(1);
        System.out.println(answer);
    }
    static void dfs(int node){
        for(int i : list.get(node))
            if(!visited[i]){
                answer++;
                visited[i] = true;
                dfs(i);
            }
    }
}
