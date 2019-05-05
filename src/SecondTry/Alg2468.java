package SecondTry;
import java.util.*;
import java.io.*;
class point{
    int y, x;
    public point(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Alg2468 {
    static int[][] map;
    static int N;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int min = 101, max = -1;
        map = new int[N+1][N+1]; // index 1부터
        visited = new boolean[N+1][N+1]; // index 1부터
        for(int i = 1; i < N+1; i++)
            for(int j = 1; j < N+1; j++){
                map[i][j] = sc.nextInt();
             if(map[i][j] > max)
                 max = map[i][j];
            if(map[i][j] < min)
                min = map[i][j];
            }
        int answer = -1;
        for(int i = min-1; i < max; i++){
            answer = Math.max(answer, bfs(i));
            for(boolean[] arr : visited)
            Arrays.fill(arr, false);
        }
        System.out.println(answer);
    }
    static int bfs(int stn){
        LinkedList<point> bfsQ = new LinkedList<point>();
        int answer = 0;
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                if(range(i, j) && !visited[i][j] && map[i][j] > stn){
                    bfsQ.add(new point(i, j));
                    visited[i][j] = true;
                    answer++;
                    while(!bfsQ.isEmpty()){
                        point temp = bfsQ.poll();
                        int nexty, nextx;
                        for(int k = 0; k < 4; k++){
                            nexty = temp.y + dir[k][0];
                            nextx = temp.x + dir[k][1];
                            if(range(nexty, nextx) && !visited[nexty][nextx] && map[nexty][nextx] > stn){
                                bfsQ.add(new point(nexty, nextx));
                            visited[nexty][nextx] = true;
                            }
                        }
                    }
                }
        return answer;
    }
    static boolean range(int y, int x){
        return (y > 0 && y < N+1 && x > 0 && x < N+1)? true : false;
    }
}
