package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg13549 { // 숨바꼭질 2
    static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }
    static int bfs(){
        LinkedList<Integer> bfsQ = new LinkedList<Integer>();
        int ans = 0;
        boolean[] visited = new boolean[100001]; // 0- 
        bfsQ.add(N);
        visited[N] = true;
        int bef = 1, af = 0;
        while(!bfsQ.isEmpty()){
            int add = 0;
            ListIterator<Integer> itr = bfsQ.listIterator(0);
            for(int i = 0; i < bef; i++){
            int tval = itr.next();
             while(tval*2 <= 100000 && !visited[tval*2]){
                 itr.add(tval*2); // 되나?
                 // 와 ㅅㅂ 이렇게 해서 itr에 추가되었다는 걸 인지시켜야 하나..
                 visited[tval*2] = true;
                 tval *= 2;
                 add++;
             }
            }
            bef += add;
            // temp-1 / temp+1 연산 진행
            for(int i = 0; i < bef; i++){
                int tval = bfsQ.poll();
                if(tval == K) // 답 경로 나오면 바로 종료
                    return ans;
                if(tval-1 >= 0 && !visited[tval-1]){
                    bfsQ.add(tval-1);
                    visited[tval-1] = true;
                    af++;
                }
                if(tval+1 <= 100000 && !visited[tval+1]){
                     bfsQ.add(tval+1);
                    visited[tval+1] = true;
                    af++;
                }
            }
            bef = af;
            af = 0;
            ans++;
        }
        return -1; // 여기 도달? -> 답이 없음(말이 안됨)
    }
}
/*
bfs를 돌릴때

일단 2*K로 이동할때 0초 걸리므로

queue에 있는 bef만큼 peek해서 보는데 각각에 대한 2*K를 while문으로
돌려서 queue에 싹 다 넣으면서 bef++한다음

변경된 bef만큼 보면서 temp-1, temp+1 연산 진행

5

5 10 20.. 늘리고 

여기에서 temp-1 temp+1 

숨4 idea ::

그래프??

어느 점 i에서 어느 점 j으로 갈 수 있을 때마다

j -> i인 간선 생성한다.

경로 찾은 뒤

 5 -> 10 -> 9 -> 18 -> 17 이면

17까지 간뒤 역추적하면 씹가능

StringBuilder 사용하던가 역출력하든가


*/
