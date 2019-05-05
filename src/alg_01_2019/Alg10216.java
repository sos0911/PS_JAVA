package alg_01_2019;
import java.io.*;
import java.util.*;

class info{
    int x, y, r;
    public info(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    } 
}
public class Alg10216 { // 2차원 : (x, y)
    static List<LinkedList<Integer>> adjlist = new ArrayList<LinkedList<Integer>>(); // 각 노드의 인접 리스트를 담는 arraylist 생성
    static int eachNofen; // 각 tc의 적군 수
    static boolean[] visited = new boolean[5005]; // 방문 배열
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Noftc = Integer.parseInt(br.readLine());
        for(int i = 0; i < Noftc; i++){
            adjlist.clear(); // 각 tc 시작 시 내용물 초기화
            Arrays.fill(visited, false);
            String[] temp;
            eachNofen = Integer.parseInt(br.readLine());
            for(int k = 0; k < eachNofen; k++)
            adjlist.add(new LinkedList<Integer>()); // 적군 수만큼 인접 리스트 생성(0번부터 적군수 - 1)
            info[] nodeinfo = new info[eachNofen]; // node 정보 저장할 배열 생성(index 0~)
            for(int j = 0; j < eachNofen; j++){
                temp = br.readLine().split(" ");
                nodeinfo[j] = new info(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
            }
            for(int j = 0; j < eachNofen; j++)
                for(int k = j+1; k < eachNofen; k++)
                    if(Math.pow(nodeinfo[j].r + nodeinfo[k].r, 2) >= Math.pow(nodeinfo[j].x - nodeinfo[k].x, 2) + Math.pow(nodeinfo[j].y - nodeinfo[k].y, 2)){ // 서로 영역이 겹침
                        adjlist.get(j).add(k);
                        adjlist.get(k).add(j);
                    }
            // 남은 것 : dfs or bfs 이용해서 그룹 수 찾아내기
            System.out.println(bfs());
        }
    }
    static int bfs(){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int temp, answer = 0;
        for(int i = 0; i < eachNofen; i++){
            if(visited[i]) // 방문한 노드면 skip
                continue;
            queue.add(i);
            visited[i] = true;
        while(!queue.isEmpty()){
            temp = queue.poll();
            for(int j : adjlist.get(temp))
                if(!visited[j]){
                    queue.add(j);
                    visited[j] = true;
                }
        }
            answer++;
        }
        return answer;
    }
}
