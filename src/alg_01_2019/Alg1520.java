package alg_01_2019;
import java.io.*;
import java.util.*;
public class Alg1520 { // visited 필요x
    static int Hofm, Wofm;
    static int[][] map, dp; // (0,0)부터 시작, (y,x)
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp;
        temp = br.readLine().split(" ");
        Hofm = Integer.parseInt(temp[0]);
        Wofm = Integer.parseInt(temp[1]);
        map = new int[Hofm][Wofm];
        dp = new int[Hofm][Wofm];
        for(int i = 0; i < Hofm; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < Wofm; j++)
                map[i][j] = Integer.parseInt(temp[j]);
        }
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        System.out.println(dfsdp(0, 0));
    }
    static int dfsdp(int y, int x){ // (y,x)에서 목적지까지 가는 경로 수 반환
        if(y == Hofm-1 && x == Wofm-1) // 목적지 도달
            return 1;
        if(dp[y][x] != -1)
            return dp[y][x];
        int sum = 0, tempy, tempx;
        for(int i = 0; i < 4; i++){ // for문을 그냥 넘어갔다면 진행할 곳이 없다는 뜻 = 0
            tempy = y + dir[i][0];
            tempx = x + dir[i][1];
            if(tempy < 0 || tempy >= Hofm || tempx < 0 || tempx >= Wofm) // 범위 벗어남
                continue;
            if(map[tempy][tempx] < map[y][x])
            sum += dfsdp(tempy, tempx);
        }
        return dp[y][x] = sum;
    }
}
