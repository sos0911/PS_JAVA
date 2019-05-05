package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg15918 {
    static int answer = 0;
    static int n, x, y;
    static boolean[] visited; // 방문 배열
    public static void main(String[] args) throws IOException{
        // 비트마스트로 개선 가능.
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        visited = new boolean[2*n+1]; // index 1부터, false 초기화
        // 완전 탐색 진행
        visited[x] = true;
        visited[y] = true;
        dfs(1); // 1부터 시작
        System.out.println(answer);
    }
    static void dfs(int tar){ // 완전 탐색 메소드
        if(tar == n+1){
            answer++;
            return;
        }
        if(tar == y-x-1)
            dfs(tar+1); // 넘어감(이미 들어감)
        for(int i = 1; i < 2*n-tar; i++) // 모든 위치에 대해 시도함
            if(!visited[i] && !visited[i+tar+1]){
                visited[i] = true;
                visited[i+tar+1] = true;
                dfs(tar+1);
                visited[i] = false;
                visited[i+tar+1] = false;
            }
    }
}
