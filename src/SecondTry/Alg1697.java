package SecondTry;
import java.io.*;
import java.util.*;
public class Alg1697 {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
        System.out.println(bfs(sc.nextInt(), sc.nextInt()));
    }
    static int bfs(int start, int des){
        LinkedList<Integer> bfsQ = new LinkedList<Integer>();
        boolean[] visited = new boolean[100001]; // index 0부터
        int befrep = 1, nextrep = 0, answer = 0;
        bfsQ.add(start);
        while(!bfsQ.isEmpty()){
            for(int i = 0; i < befrep; i++){
            int temp = bfsQ.poll();
                if(temp == des)
                    return answer;
            if(judge(temp-1) && !visited[temp-1]){
                bfsQ.add(temp-1);
                visited[temp-1] = true;
             nextrep++;   
            }
            if(judge(temp+1) && !visited[temp+1]){
                 bfsQ.add(temp+1);
                visited[temp+1] = true;
             nextrep++;   
            }
            if(judge(temp*2) && !visited[temp*2]){
                bfsQ.add(temp*2);
                visited[temp*2] = true;
             nextrep++;   
            }
        }
            befrep = nextrep;
            nextrep = 0;
            answer++;
        }
        return -1; // 애초에 여기까지 올 수도 없음
    }
    static boolean judge(int v){
        return v >= 0 && v <= 100000? true : false;
    }
}
