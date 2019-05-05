package alg_02_2019;
import java.io.*;
import java.util.*;
public class Alg1780 {
    static int[][] map;
    static int[] answer = new int[3]; // -1, 0, 1
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        div(0, 0, N);
        for(int i : answer)
            System.out.println(i);
    }
    static void div(int y, int x, int len){ // (y,x)부터 시작하는 정사각형 len x len크기를 탐색
        int temp = map[y][x]; boolean Isunited = true; // 하나의 문자로 통일?
        for(int i = y; i < y+len; i++)
            for(int j = x; j < x+len; j++)
                if(map[i][j] != temp)
                    Isunited = false;
        if(Isunited)
            answer[temp+1]++;
        else{
            for(int i = y; i < y+len; i += len/3)
                for(int j = x; j < x+len; j += len/3)
                    div(i, j, len/3);
        }
    }
}
