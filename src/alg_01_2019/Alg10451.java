package alg_01_2019;
import java.io.*;
import java.util.*;
public class Alg10451 {
    //static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>(1001); // 인접 리스트
    static int[] adjlist = new int[1001]; // 선언 시 자동 0으로 초기화
    static boolean[] visited = new boolean[1001]; // 방문 배열
    public static void main(String[] args) throws IOException{
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int Noftc = Integer.parseInt(br.readLine());
        String[] temp;
        for(int i = 0; i < Noftc; i++){
            int N = Integer.parseInt(br.readLine());
            temp = br.readLine().split(" "); 
            for(int k = 0; k < N; k++)
     adjlist[k+1] = Integer.parseInt(temp[k]);
            sb.append(bfs(N) + "\n");
            for(int z = 1; z < N+1; z++){ // 초기화
                visited[z] = false; 
                adjlist[z] = 0;    
            }
        }
        System.out.println(sb.toString());
    }
    static int bfs(int N){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int temp, temp2, answer = 0; boolean Iscycle = false;
        for(int i = 1; i < N+1; i++){
            if(visited[i])
                continue;
            queue.add(i);
            outerloop: // cycle 생기는 즉시 탈출
         while(!queue.isEmpty()){
             temp = queue.poll();
             if((temp2 = adjlist[temp]) != 0){
                 if(temp2 == i){ // cycle 성립
                     Iscycle = true;
                     break outerloop;
                 }
                 visited[temp2] = true;
                 queue.add(temp2);
             }
         }
            if(Iscycle)
                answer++;
            Iscycle = false; // 초기화
        }
        return answer;
    }
}
