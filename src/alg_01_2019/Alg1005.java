package alg_01_2019;
import java.io.*;
import java.util.*;

public class Alg1005 {
    static ArrayList<LinkedList<Integer>> adjlist = new  ArrayList<LinkedList<Integer>>(1001); // index 1 - 1000
    static int[] dp = new int[1001]; // index 1 - 1000
    static int[] times = new int[1001]; // index 1 - 1000, 건설시간 저장
    static int Nofb, Nofr, tar; // 건물의 수, 규칙의 수, target node
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] IsstartN  = new boolean[1001]; // start node 판별
        for(int i = 0; i < 1001; i++){
            adjlist.add(new LinkedList<Integer>());
             dp[i] = -1;
            IsstartN[i] = true;
        }
        int Noftc = Integer.parseInt(br.readLine());
        String temp[];
        for(int i = 0; i < Noftc; i++){ // for문 끝에 dp, adjlist 초기화(times는 x)
            temp = br.readLine().split(" ");
            Nofb = Integer.parseInt(temp[0]);
            Nofr = Integer.parseInt(temp[1]);
            temp = br.readLine().split(" ");
            for(int j = 1; j < Nofb+1; j++)
                times[j] = Integer.parseInt(temp[j-1]);
            for(int j = 1; j < Nofr+1; j++){
                temp = br.readLine().split(" ");
                int a = Integer.parseInt(temp[0]);
                int b = Integer.parseInt(temp[1]);
                IsstartN[b] = false;
               adjlist.get(a).add(b);
            }
            tar = Integer.parseInt(br.readLine());
            int answer = Integer.MIN_VALUE;
            for(int j = 1; j < Nofb+1; j++)
                if(IsstartN[j]){ // 초기 건물이 가능한 건물(문제)
                    if(dfsdp(j) == -2) // 목적지 도달 못하는 경우는 제외
                        continue;
                        if(dp[j] > answer)
                        answer = dp[j];
                    }
            bw.write(answer + "\n");
            for(int j = 1; j < Nofb+1; j++){ // 초기화
                adjlist.get(j).clear();
                 dp[j] = -1;
                IsstartN[j] = true;
            }
        }
        bw.close();
    }
    static int dfsdp(int node){ // node에서 목적지까지 가는 경로값의 최대값 반환
        if(dp[node] != -1)
            return dp[node];
        if(node == tar)
            return dp[node] = times[tar];
        int tempa = -2, temp;
        for(int i : adjlist.get(node))
            if((temp = dfsdp(i)) > tempa)
                tempa = temp;
        return dp[node] = (tempa == -2? -2 : tempa + times[node]);
    }
}