package backjoonalg;
import java.io.*;
import java.util.*;

public class Alg14889 {
    static boolean[] visited; // 방문 배열 / index 0부터 사용
    static int[][] cinergy; // s 배열 (각 행이 사람) / index 0부터 사용
    static LinkedList<Integer> one = new LinkedList<Integer>(); // 1팀
    static LinkedList<Integer> two = new LinkedList<Integer>(); // 2팀
    static int[] TP = new int[2]; // 각 step의 각 팀파워(1팀/2팀)
    static int Nofp, answer = 10000; // 주의
    static Iterator<Integer> it;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Nofp = Integer.parseInt(br.readLine());
        cinergy = new int[Nofp][Nofp];
        visited = new boolean[Nofp];
        String[] temp;
        for(int i = 0; i < Nofp; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < Nofp; j++)
                cinergy[i][j] = Integer.parseInt(temp[j]);
        }
        SetTM(0, -1);
        System.out.println(answer);
    }
     static void SetTM(int Nofone, int lastI){ // 1팀의 인원
         if(Nofone == Nofp/2){
             calTwoP();
             if(Math.abs(TP[0] - TP[1]) < answer)
                 answer = Math.abs(TP[0] - TP[1]);
             TP[1] = 0;
             two.clear();
             return;
         }
         for(int i = lastI + 1; i < Nofp; i++){
                 int tempsum = 0; // 각 단계에서 i를 추가시킴으로써 얻는 1팀전력
                 it = one.iterator();
                  while(it.hasNext()){
                    int temp = it.next();
                    tempsum += cinergy[i][temp];
                    tempsum += cinergy[temp][i];
                }
                 TP[0] += tempsum;
                 one.add(i);
                 visited[i] = true;
                 SetTM(Nofone+1, i);
                 TP[0] -= tempsum;
                 one.removeLast();
                 visited[i] = false;
         }
    }
    static void calTwoP(){// 2팀 power 계산
        for(int i = 0; i < Nofp; i++)
            if(!visited[i]){
                it = two.iterator();
                while(it.hasNext()){
                    int temp2 = it.next();
                    TP[1] += cinergy[i][temp2];
                    TP[1] += cinergy[temp2][i];
                }
                two.add(i);
            }
    }
}
