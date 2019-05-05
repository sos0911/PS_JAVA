package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1987 { // dfs back. bfs는 불가능 ㅅㅂ
    static char[][] map; // map
    static int R, C;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C =  Integer.parseInt(st.nextToken());
        map = new char[R][C]; // 0부터 
        for(int i = 0; i < R; i++){
            String temp = br.readLine();
            map[i] = temp.toCharArray();
        }
        System.out.println(1 + backdfs(0, 0, 1 << (map[0][0] - 'A')));
        // 시작점은 이미 방문했으므로
        // 알파벳은 27개이므로 visited > int 가능
    }
   static int backdfs(int y, int x, int visited){ // 최대 칸 수 계산
       int answer = 0;
       for(int i = 0; i < 4; i++){
        int nexty = y + dir[i][0];
           int nextx = x + dir[i][1];
           if(nexty >= 0 && nexty < R && nextx >= 0 && nextx < C && (visited & (1 << (map[nexty][nextx] - 'A'))) == 0)
              answer = Math.max(answer, 1 + backdfs(nexty, nextx, visited + (1 << (map[nexty][nextx] - 'A'))));
       }
       return answer;
}   
}
