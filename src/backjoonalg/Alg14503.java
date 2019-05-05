package backjoonalg;
import java.io.*;
import java.util.*;

public class Alg14503 {
    static int curdir; // 현재 방향
    static int[] stpos = new int[2]; // (y,x), 현재 위치
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // 방향(북동남서)
    static int Hofm, Wofm;
    static int[][] map; // map
    static int answer = 0; // 답
    static boolean[][] visited; // 방문배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        Hofm = Integer.parseInt(temp[0]);
        Wofm = Integer.parseInt(temp[1]);
        visited = new boolean[Hofm][Wofm];
        for(boolean[] a : visited)
        Arrays.fill(a, false);
        map = new int[Hofm][Wofm]; // (y,x)이며 (0,0)부터 시작
        temp = br.readLine().split(" ");
        stpos[0] = Integer.parseInt(temp[0]);
        stpos[1] = Integer.parseInt(temp[1]);
        curdir = Integer.parseInt(temp[2]);
        for(int i = 0; i < Hofm; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < Wofm; j++)
                map[i][j] = Integer.parseInt(temp[j]);
        }
       cleanup(stpos[0], stpos[1]);
        System.out.println(answer);
    }
    static void cleanup(int y, int x){ // 청소 시뮬레이션. 메소드당 동서남북 한 칸씩 본다
        boolean Finds = false; // while문에서 청소할 공간을 찾았는가?
        if(!visited[y][x]){
        answer++;
        visited[y][x] = true;
        }
        int i = (curdir == 0? 3 : curdir-1);
        int backdir = Findback(curdir);
        int wrep = 0;
         while(wrep != 4){
            curdir = i; // 현재 방향 수정
            if(map[y + dir[i][0]][x + dir[i][1]] == 0 && !visited[y + dir[i][0]][x + dir[i][1]]){
                Finds = true;
                break;
            }
            if(i == 0)
                i = 4;
            i--;
            wrep++;
        }
        if(Finds)
            cleanup(y + dir[curdir][0], x + dir[curdir][1]);
        else if(map[y + dir[backdir][0]][x + dir[backdir][1]] != 1)
            cleanup(y + dir[backdir][0], x + dir[backdir][1]);
}
    static int Findback(int begindir){// begindir의 뒷 방향을 구함
        int backdir = -1;
         switch(begindir){
            case 0 :
                backdir = 2;
                break;
            case 1 : 
                backdir = 3;
                break;
            case 2 :
                backdir = 0;
                break;
            case 3 :
                backdir = 1;
                break;
            default:
        }
        return backdir;
    }
}
