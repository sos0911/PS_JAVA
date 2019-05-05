package alg_01_2019;
import java.io.*;
import java.util.*;
class point{ // private 제외!
    int y, x;
    public point(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Alg2667 {
    static int[][] map, dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int N;
    static boolean[][] visited;
    static LinkedList<point> inilist = new LinkedList<point>();
    static LinkedList<Integer> answer = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(boolean[] arr : visited)
            Arrays.fill(arr, false);
        String tempS; int temp;
        for(int i = 0; i < N; i++){
            tempS = br.readLine();
            for(int j = 0; j < N; j++){
                temp = tempS.charAt(j) - '0';
                if(temp == 1)
                    inilist.add(new point(i, j));
                map[i][j] = temp;
            }
        }
        bfs();
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i : answer)
            System.out.println(i);
    }
    static void bfs(){
        LinkedList<point> locallist = new LinkedList<point>();
        point temp, temp2; int tempA, nexty, nextx;
        while(!inilist.isEmpty()){
            temp2 = inilist.poll();
            if(visited[temp2.y][temp2.x])
                continue;
            visited[temp2.y][temp2.x] = true;
            tempA = 1;
            locallist.add(temp2);
            while(!locallist.isEmpty()){
                temp = locallist.poll();
                for(int i = 0; i < 4; i++){
                    nexty = temp.y + dir[i][0];
                     nextx = temp.x + dir[i][1];
                    if(nexty < 0 || nexty >= N || nextx < 0 || nextx >= N)
                        continue;
                    if(!visited[nexty][nextx] && map[nexty][nextx] == 1){
                        tempA++;
                        visited[nexty][nextx] = true;
                        locallist.add(new point(nexty, nextx));
                    }
                }
            }
            answer.add(tempA);
        }
    }
}
