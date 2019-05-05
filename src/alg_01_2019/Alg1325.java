package alg_01_2019;
import java.util.*;
import java.io.*;

class Info{
 int node, value;
    public Info(int node, int value){
        this.node = node;
        this.value = value;
    }
}
public class Alg1325 {
    static ArrayList<LinkedList<Integer>> adjlist = new ArrayList<LinkedList<Integer>>();
    static int[] visited; // 방문 배열, 각 for문에서 초기화 없이 현재 탐색을 시작한 노드 번호 적기
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        for(int i = 0; i < N+1; i++)
            adjlist.add(new LinkedList<Integer>()); // 노드 수만큼 인접 리스트 생성(index 1 - N을 사용)
        visited = new int[N+1]; // index 1 - N
        M = Integer.parseInt(temp[1]);
        for(int i = 0; i < M; i++){
            temp = br.readLine().split(" ");
            adjlist.get(Integer.parseInt(temp[1])).add(Integer.parseInt(temp[0])); // 단방향 인접 리스트
        }
        bfs();
    }
    static void bfs() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> queue = new LinkedList<Integer>();
        LinkedList<Info> nodeInfo = new LinkedList<Info>(); // node와 node value 저장
        int temp, max = -1;
        for(int i = 1; i < N+1; i++){
            int answer = 1; // 각 for문 답 / 자기 자신 포함
            queue.add(i);
            while(!queue.isEmpty()){
                temp = queue.poll();
                for(int j : adjlist.get(temp))
                    if(visited[j] != i){
                        answer++;
                        visited[j] = i;
                        queue.add(j);
                    }
            }
            if(answer > max)
                max = answer;
            nodeInfo.add(new Info(i, answer));
        }
        for(Info in : nodeInfo){
            if(in.value == max)
               bw.write(in.node + " ");
        }
        bw.close();
    }
}

/*
bfs
단방향 그래프 만들고..

1부터 N까지 하나씩 queue에 넣은 다음
닿을 수 있는 컴퓨터 수 조사 >>
(컴퓨터 번호, 닿을 수 있는 숫자) 자료형
만들고 array에 넣어서 sort.
(override method)
최대값 뽑은 다음 동일한 최대값인 노드들 뽑아 출력
*/