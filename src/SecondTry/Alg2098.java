package SecondTry;
import java.io.*;
import java.util.*;

public class Alg2098 {
    static int[][] dist; // 거리 배열
    static int Nofn, start = 0, max = 20000000; // 순회 start node
    static int[][] dp;
    public static void main(String[] args) throws IOException{ // 0번 노드 - 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Nofn = Integer.parseInt(br.readLine());
        dist = new int[Nofn][Nofn]; // index 1부터
        dp = new int[Nofn][1<<Nofn]; // 0으로 초기화
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        StringTokenizer st;
        for(int i = 0; i < Nofn; i++){ // 입력 받기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < Nofn; j++)
              dist[i][j] = Integer.parseInt(st.nextToken());
        }
       System.out.println(dfsdp(start, 1<<start));
    }
    static int dfsdp(int here, int visited){ // 현재 위치가 here이고 visited가 주어질 때 앞으로 남은 도시들을 반환하는 최소 비용을 반환 (0...0부터 1...1까지)
        if(visited == (1<<Nofn)-1){
            if(dist[here][start] == 0) // 불가능한 경로
                return max;
            else
                return dist[here][start];
        }
         if(dp[here][visited] != -1)
            return dp[here][visited];
        int temp = max;
        for(int i = 0; i < Nofn; i++){
            if((visited & (1<<i)) > 0 || dist[here][i] == 0) // 이미 방문하거나 길이 없는 경우 건너뜀
               continue;
            temp = Math.min(temp, dist[here][i] + dfsdp(i, visited + (1<<i)));
        }
        return dp[here][visited] = temp;
    }
}
