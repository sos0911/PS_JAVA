package alg_01_2019;
import java.io.*;
import java.util.*;
class Point{
    private int y, x;
    public Point(int y, int x){
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
public class Alg2178_1 { // dfs 썼더니 시간초과.. 시간 복잡도 : dfs > bfs?
    static int Hofm, Wofm;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static LinkedList<Point> queue = new LinkedList<Point>(); // bfs용 queue
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
        queue.add(new Point(0, 0)); // 초기값 세팅
       System.out.println(bfs());
    }
    static int bfs(){
        int answer = 1, eachsize, nexty, nextx;
        Point temp;
        while(!queue.isEmpty()){
            eachsize = queue.size();
            for(int i = 0; i < eachsize; i++){
                temp = queue.poll();
                for(int j = 0; j < 4; j++){
                    nexty = temp.gety() + dir[j][0];
                    nextx = temp.getx() + dir[j][1];
                    if(nexty >= 0 && nexty < Hofm && nextx >= 0 && nextx < Wofm && map[nexty][nextx] == 1 && !visited[nexty][nextx]){
                        if(nexty == Hofm-1 && nextx == Wofm-1) // 목적지 도달
                             return answer+1;
                        visited[nexty][nextx] = true;
                        queue.add(new Point(nexty, nextx));
                    }
                }
            }
            answer++;
        }
        // 큐가 비게 되면 정답을 결국 못 찾는 것인데 여기서는 항상 정답을 찾는다.
        return -1; // error output
    }
}
