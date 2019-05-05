package alg_02_2019;
import java.util.*;
import java.io.*;
class Info2{
    int y, x, rep;
    public Info2(int y, int x, int rep){ // 좌표와 현재 말행동 가능한 K번
        this.y = y;
        this.x = x;
        this.rep = rep;
    }
}
public class Alg1600 {
    static int K, W, H;
    static int[][] map;
    static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    static int[][] dir2 = {{-1,-2}, {-1, 2}, {-2, -1}, {-2, 1}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H+1][W+1]; // index 1부터
        for(int i = 1; i < H+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < W+1; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs(new Info2(1, 1, K)));
    }
    static int bfs(Info2 start){
        LinkedList<Info2> bfsQ = new LinkedList<Info2>();
        boolean[][][] visited = new boolean[H+1][W+1][K+1]; // 0 - K번 left
        bfsQ.add(start);
        visited[1][1][K] = true;
        int befrep = 1, nextrep = 0, answer = 0;
        while(!bfsQ.isEmpty()){
            for(int j = 0; j < befrep; j++){
            Info2 temp = bfsQ.poll();
            if(temp.y == H && temp.x == W)
                return answer;
            for(int i = 0; i < 4; i++){
                int nexty = temp.y + dir[i][0];
                int nextx = temp.x + dir[i][1];
                if(nexty > 0 && nexty <= H && nextx > 0 && nextx <= W && !visited[nexty][nextx][temp.rep] && map[nexty][nextx] != 1){ // 범위 내에다 미방문
                bfsQ.add(new Info2(nexty, nextx, temp.rep));
                    nextrep++;
                    visited[nexty][nextx][temp.rep] = true;                   
                    }
                }
            if(temp.rep > 0) // 말처럼 가능
                 for(int i = 0; i < 8; i++){
                int nexty = temp.y + dir2[i][0];
                int nextx = temp.x + dir2[i][1];
                if(nexty > 0 && nexty <= H && nextx > 0 && nextx <= W && !visited[nexty][nextx][temp.rep-1] && map[nexty][nextx] != 1){ // 범위 내에다 미방문
                bfsQ.add(new Info2(nexty, nextx, temp.rep-1));
                     nextrep++;
                    visited[nexty][nextx][temp.rep-1] = true;                 
                    }
                }
            }
            befrep = nextrep;
            nextrep = 0;
            answer++;
            }
        return -1;
        }
    }
