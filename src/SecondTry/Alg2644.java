package SecondTry;
import java.util.*;
import java.io.*;
public class Alg2644 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int P = sc.nextInt();
        System.out.println(bfs(A, P));
    }
    static int bfs(int A, int P){ // 수열을 queue에 넣어 늘려 가다가 visited된 노드 방문하면 값 출력하고 return
        LinkedList<Integer> bfsQ = new LinkedList<Integer>();
        int[] visited = new int[236197]; // 최대 나오는 노드는 236196, 방문한 시간 저장
        // 0이면 방문하지 않은 것
        int t = 1; // 현재 시간
        bfsQ.add(A);
        visited[A] = t; // 시간은 1부터 시작
        while(!bfsQ.isEmpty()){
                int temp = bfsQ.poll();
                int next = 0;
                while(temp > 0){
                    next += Math.pow(temp%10, P);
                     temp /= 10;   
                }
                if(visited[next] == 0){
                    bfsQ.add(next);
                 visited[next] = ++t;
                }
                else // 이미 전에 방문했던 노드
                    return visited[next]-1;
            }
        return -1; // cycle을 못 찾은 경우(해당x)
        }
    }
