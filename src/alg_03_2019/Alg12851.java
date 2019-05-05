package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg12851 { // 숨바꼭질 2
    static int N, K;
    static int fa = 0, Nofway = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // idea : bfs로 찾는데 시간대별로 찾고 방법 수까지 찾자!
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(fa);
        System.out.println(Nofway);
    }
    static void bfs(){
        LinkedList<Integer> bfsQ = new LinkedList<Integer>();
        LinkedList<Integer> visitedQ = new LinkedList<Integer>();
        // 방문처리 예정인 노드들 모음
         boolean[] visited = new boolean[100001]; // 1 - 100000
        bfsQ.add(N);
          visited[N] = true;
        int bef = 1, af = 0; boolean check = false;
        while(!bfsQ.isEmpty()){
            for(int i = 0;  i < bef; i++){
            int temp = bfsQ.poll();
                if(temp == K){ // 도달한 경로가 나옴
                    Nofway++;
                    check = true;
                }
            if(temp-1 >= 0 && !visited[temp-1]){ // 범위 내 / 미방문
             bfsQ.add(temp-1);
                visitedQ.add(temp-1);
                af++;
            }
                if(temp+1 <= 100000 && !visited[temp+1]){ // 범위 내 / 미방문
             bfsQ.add(temp+1);
                visitedQ.add(temp+1);
                    af++;
            }
                if(temp*2 <= 100000 && !visited[temp*2]){ // 범위 내 / 미방문
             bfsQ.add(temp*2);
               visitedQ.add(temp*2);
                    af++;
            }
            }
            if(check)
                break;
            // 한 단계 끝날 때 일괄 방문처리
            while(!visitedQ.isEmpty())
                visited[visitedQ.poll()] = true;
            bef = af;
            af = 0;
            fa++;
        }
    }
}
