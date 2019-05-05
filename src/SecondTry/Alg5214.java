package SecondTry;
import java.util.*;
import java.io.*;
public class Alg5214 {
    static int Nofs, link, Nofh; 
    static ArrayList<LinkedList<Integer>> adjlist;
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Nofs = Integer.parseInt(st.nextToken());
        link = Integer.parseInt(st.nextToken());
        Nofh = Integer.parseInt(st.nextToken());
        adjlist = new ArrayList<LinkedList<Integer>>(Nofs+Nofh+1);
        for(int i = 0; i < Nofs+1+Nofh; i++)
            adjlist.add(new LinkedList<Integer>());
        int dummy = Nofs+1;
        for(int i = 0; i < Nofh; i++){ // 입력 받기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < link; j++){
                int a = Integer.parseInt(st.nextToken());
                adjlist.get(a).add(dummy);
                adjlist.get(dummy).add(a);
            }
             dummy++;
        }
        System.out.println(bfs(1));
    }
    // point : 진짜 실재하는 node끼리의 간선은 없다. 결국 cost/2 + 1
    // 전체 노드 개수 : nofs + nofm
    static int bfs(int start){ // start에서 출발하여 Nofs번 노드까지의 역 개수의 최솟값 출력(시작점 포함)
        LinkedList<Integer> bfsQ = new LinkedList<Integer>();
        boolean[] visited = new boolean[Nofs+Nofh+1]; // index 1부터, false 초기화
        int befrep = 1, nextrep = 0, answer = 0;
        bfsQ.add(start);
        while(!bfsQ.isEmpty()){
        for(int j = 0; j < befrep; j++){
            int temp = bfsQ.poll();
            if(temp == Nofs)
                return answer/2 + 1;
            for(int i : adjlist.get(temp))
                if(!visited[i]){
                    bfsQ.add(i);
                    nextrep++;
                    visited[i] = true;   
                }
        }
            befrep = nextrep;
            nextrep = 0;
            answer++;
        }
        return -1;
    }
}
