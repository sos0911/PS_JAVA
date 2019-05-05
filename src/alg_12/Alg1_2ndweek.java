/*package alg_12;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Alg1_2ndweek { // 2610번 회의준비 도전중
    static int NofP;
    static List<Integer>[] relA; // 연관 배열
    static LinkedList<LinkedList<Integer>> councils; // 위원회들을 구분지어 놓은 linkedlist들
    static boolean[] visited; // 방문 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        NofP = Integer.parseInt(br.readLine());
        int Nofrepfor = Integer.parseInt(br.readLine());
        relA = new List[NofP + 1]; // index 1부터 사용
        for(int i = 0; i < NofP + 1; i++)
            relA[i] = new LinkedList<Integer>();
        for(int i = 0; i < Nofrepfor; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            relA[A].add(B);
             relA[B].add(A);
        }
        visited = new boolean[NofP + 1]; // index 1부터 사용
        Arrays.fill(visited, false);
        councils = new LinkedList<LinkedList<Integer>>();
         for(int i = 1; i < NofP+1; i++)
             bfs(i); // 사전 작업 :: 위원회를 나눈다.
        int[] answerindexes = new int[councils.size()]; // 정답들을 저장할 배열
        int i = 0;
        for(LinkedList<Integer> list : councils){
            int minTrans = 100000000;
            int answerI = -1;
            for(int n : list){
                  Arrays.fill(visited, false); // 다시 초기화
                int ta = FindmaxTrans(n);
                if(ta < minTrans){
                    minTrans = ta;
                 answerI = n;   
                }
            }
               answerindexes[i++] = answerI;
        }
        Arrays.sort(answerindexes);
        bw.write(answerindexes.length + "\n");
        for(int j : answerindexes)
            bw.write(j + "\n");
        bw.close();
    }
    static void bfs(int index){ 
        if(!visited[index]){
            LinkedList<Integer> newL = new LinkedList<Integer>();
            councils.add(newL);
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;
        int temp;
        while(!q.isEmpty()){
            temp = q.poll();
            newL.add(temp);
            for(int n : relA[temp]){
                if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
        }
    }
    static int FindmaxTrans(int Kindex){ // index가 위원장이 될 시 최댓값의 의사전달시간을 반환(using bfs)
      Queue<Integer> beQ = new LinkedList<Integer>();
        Queue<Integer> tempR;
        Queue<Integer> afQ = new LinkedList<Integer>();
        beQ.add(Kindex);
        visited[Kindex] = true;
        int temp;
        int eachA = 0; // 단계답
        boolean sc;
        boolean firstloop = true;
      while(firstloop || !afQ.isEmpty()){ 
          sc = false;
          if(firstloop)
          firstloop = false;
          else{
          tempR = beQ;
          beQ = afQ;
          afQ = tempR;
          }
        while(!beQ.isEmpty()){
            temp = beQ.poll();
            for(int n : relA[temp]){
                if(!visited[n]){
                    if(!sc){ // 최초 1회에 한해, 값 증가
                        eachA++; 
                        sc = true;   
                    }
                    afQ.add(n);
                    visited[n] = true;
                }
            }
        }   
        }
        return eachA;
    }
}
*/