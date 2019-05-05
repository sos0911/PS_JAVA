package alg_03_2019;
import java.io.*;
import java.util.*;
class point5212{
    int y, x;
    public point5212(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Alg5212 {
    static char[][] map;
    static int N, M;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] check; // true면 .으로 바꿈
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        check = new boolean[N][M];
        LinkedList<point5212> xlist = new LinkedList<point5212>();
        for(int i = 0; i < N; i++){
           String temp = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = temp.charAt(j);
             if(map[i][j] == 'X')   
                 xlist.add(new point5212(i, j));
            }
        }
        Iterator<point5212> itr = xlist.iterator();
        while(itr.hasNext()){
            point5212 temp = itr.next();
            int tempa = 0;
            for(int i = 0; i < 4; i++){
                int nexty = temp.y + dir[i][0];
                int nextx = temp.x + dir[i][1];
                if(nexty < 0 || nexty >= N || nextx < 0 || nextx >= M)
                    tempa++;
                else if(map[nexty][nextx] == '.')
                    tempa++;
            }
            if(tempa >= 3)
                check[temp.y][temp.x] = true;
        }
        itr = xlist.iterator();
        while(itr.hasNext()){
            point5212 temp = itr.next();
            if(check[temp.y][temp.x]){
                map[temp.y][temp.x] = '.';
            }
        }
        int xl = 0, xr = M-1, yl = 0, yr = N-1;
        outerloop:
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(map[i][j] == 'X'){
                    yl = i;
                    break outerloop;
                }
        outerloop:
        for(int i = N-1; i >= 0; i--)
            for(int j = 0; j < M; j++)
                if(map[i][j] == 'X'){
                    yr = i;
                   break outerloop;
                }
        outerloop:
         for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                if(map[j][i] == 'X'){
                    xl = i;
                    break outerloop;
                }
        outerloop:
         for(int i = M-1; i >= 0; i--)
            for(int j = 0; j < N; j++)
                if(map[j][i] == 'X'){
                    xr = i;
                    break outerloop;
                }
        for(int i = yl; i <= yr; i++){
            for(int j = xl; j <= xr; j++)
                bw.write(map[i][j] + "");
            bw.newLine();
        }     
        bw.close();
    }
}
