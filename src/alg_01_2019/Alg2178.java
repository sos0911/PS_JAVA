package alg_01_2019;
import java.io.*;
import java.util.*;
public class Alg2178 { // dfs 썼더니 시간초과.. 시간 복잡도 : dfs > bfs?
    static int Hofm, Wofm, answer = 10001;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        String temp2;
        Hofm = Integer.parseInt(temp[0]);
        Wofm = Integer.parseInt(temp[1]);
        map = new int[Hofm][Wofm];
        visited = new boolean[Hofm][Wofm];
        for(boolean[] arr : visited)
            Arrays.fill(arr, false);
        for(int j = 0; j < Hofm; j++){
            temp2 = br.readLine();
            for(int i = 0; i < Wofm; i++)
                map[j][i] = temp2.charAt(i) - '0';
        }
        dfs(0, 0, 1);
        System.out.println(answer);
    }
    static void dfs(int y, int x, int acc){// (y, x), 지나온 칸
        if(y < 0 || y >= Hofm || x < 0 || x >= Wofm) // 기저 사례
            return; // 비정상 종료
        if(visited[y][x] || map[y][x] == 0)
            return;
        if(y == Hofm-1 && x == Wofm-1){
            if(acc < answer)
                answer = acc;
            return;
        }
        visited[y][x] = true;
        for(int i = 0; i < 4; i++)
            dfs(y + dir[i][0], x + dir[i][1], acc+1);
        visited[y][x] = false;
    }
}
