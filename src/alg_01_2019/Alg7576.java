/*package alg_01_2019;
import java.io.*;
import java.util.*;
class point{
    private int y, x;
    public point(int y, int x){
        this.y = y;
        this.x = x;
    }
    int gety(){
        return y;
    }
    int getx(){
        return x;
    }
}
public class Alg7576 {
    static int Wofm, Hofm;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 방향
    static LinkedList<point> bfslink = new LinkedList<point>(); // bfs용 queue
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        Wofm = Integer.parseInt(temp[0]); 
        Hofm = Integer.parseInt(temp[1]); 
        map = new int[Hofm][Wofm]; // (y, x)
        int Nofripped = 0, Nofnripped = 0; // 익은 토마토 수, 안 익은 토마토 수
        for(int i = 0; i < Hofm; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < Wofm; j++){
                if(temp[j].equals("1")){
                    Nofripped++;
                    bfslink.add(new point(i, j));
                }
                if(temp[j].equals("0"))
                    Nofnripped++;
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        if(Nofnripped == 0) // 다 익었으면
            System.out.println("0");
        else
       System.out.println(bfs(Nofripped, Hofm*Wofm - (Nofripped+Nofnripped))); 
    }
    static int bfs(int Nofripped, int Nofempty){ 
        int cycle = -1, eachsize;
        int nexty, nextx; 
        point temp;
        while(!bfslink.isEmpty()){
            eachsize = bfslink.size();
            for(int i = 0; i < eachsize; i++){
                temp = bfslink.poll();
                for(int j = 0; j < 4; j++){
                    nexty = temp.gety() + dir[j][0];
                    nextx = temp.getx() + dir[j][1];
                    if(nexty >= 0 && nexty < Hofm && nextx >= 0 && nextx < Wofm && map[nexty][nextx] == 0){ // 다음 칸이 범위 내고 익지 않은 토마토가 있으면 queue 추가
                        Nofripped++;
                        map[nexty][nextx] = 1;
                        bfslink.add(new point(nexty, nextx));
                    }
                }
            }
            cycle++;
        }
        if(Nofripped == Hofm*Wofm - Nofempty)
        return cycle;
        else
        return -1;
    }
}
*/