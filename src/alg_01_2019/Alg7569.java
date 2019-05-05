/*package alg_01_2019;
import java.util.*;
import java.io.*;

class point{
    private int h, y, x;
    public point(int h, int y, int x){
        this.h = h;
        this.y = y;
        this.x = x;
    }
    int gety(){
        return y;
    }
    int getx(){
        return x;
    }
    int geth(){
        return h;
    }
}
public class Alg7569 {
    static int verofm, horofm, heiofm; // 가로, 세로, 높이
    static int Nofempty = 0, answer; // 빈 공간 개수, 정답
    static int[][][] map;
    static LinkedList<point> bfslist = new LinkedList<point>(); // bfs용 list
    static point[] dir = {new point(1, 0, 0), new point(-1, 0, 0), new point(0, 0, -1), new point(0, 0, 1), new point(0, 1, 0), new point(0, -1, 0)}; // 방향
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        horofm = Integer.parseInt(temp[0]); // x
        verofm = Integer.parseInt(temp[1]); // y
        heiofm = Integer.parseInt(temp[2]); // h
        map = new int[heiofm][verofm][horofm]; // h, y, x;
        int Nofrip = 0;
        for(int i = 0; i < heiofm; i++)
        for(int j = 0; j < verofm; j++){
            temp = br.readLine().split(" ");
            for(int k = 0; k < horofm; k++){
                if(temp[k].equals("-1"))
                    Nofempty++;
                else if(temp[k].equals("1")){
                    bfslist.add(new point(i, j, k)); // list에 익은 토마토 추가
                    Nofrip++;
                }
                map[i][j][k] = Integer.parseInt(temp[k]);
            }
        }
        if(Nofrip == verofm*horofm*heiofm - Nofempty) // 다 익음
            answer = 0;
        else
            answer = bfs(Nofrip);
        System.out.println(answer);
    }
   static int bfs(int Nofrip){ 
        int cycle = -1, eachsize;
        int nexth, nexty, nextx; 
        point temp;
        while(!bfslist.isEmpty()){
            eachsize = bfslist.size(); // 수정
            for(int i = 0; i < eachsize; i++){
                temp = bfslist.poll();
                for(int j = 0; j < 6; j++){
                    nexth = temp.geth() + dir[j].geth();
                    nexty = temp.gety() + dir[j].gety();
                    nextx = temp.getx() + dir[j].getx();
                    if(nexth >= 0 && nexth < heiofm && nexty >= 0 && nexty < verofm && nextx >= 0 && nextx < horofm && map[nexth][nexty][nextx] == 0){ // 다음 칸이 범위 내고 익지 않은 토마토가 있으면 queue 추가
                        Nofrip++;
                        map[nexth][nexty][nextx] = 1;
                        bfslist.add(new point(nexth, nexty, nextx));
                    }
                }
            }
            cycle++;
        }
        if(Nofrip == heiofm*verofm*horofm - Nofempty)
        return cycle;
        else
        return -1;
    }
}
*/
