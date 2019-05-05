package alg_02_2019;
import java.util.*;
import java.io.*;
class Info{ // bfs용 struct
    int y, x;
    boolean broken;
    public Info(int y, int x, boolean broken){
        this.y = y;
        this.x = x;
        this.broken = broken;
    }
}
public class Alg2206 {
    static int N, M;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temps = br.readLine().split(" ");
        N = Integer.parseInt(temps[0]);
        M = Integer.parseInt(temps[1]);
        map = new int[N+1][M+1]; // index 1부터
        for(int i = 1; i < N+1; i++){
            String temp = br.readLine();
            for(int j = 1; j < M+1; j++)
                map[i][j] = temp.charAt(j-1) - '0';
        }
        System.out.println(bfs(new Info(1, 1, false)));
    }
    static int bfs(Info info){
        LinkedList<Info> bfsQ = new LinkedList<Info>();
        boolean[][][] visited = new boolean[N+1][M+1][2]; // index 1부터, false로 초기화
        int answer = 1;
        int nexty, nextx, befrep = 1, nextrep = 0;
        bfsQ.add(info);
        while(!bfsQ.isEmpty()){
            for(int k = 0; k < befrep; k++){
            Info temp = bfsQ.poll();
            if(temp.y == N && temp.x == M)
                return answer;
            for(int i = 0; i < 4; i++){
                nexty = temp.y + dir[i][0];
                nextx = temp.x + dir[i][1];
                if(nexty > 0 && nexty <= N && nextx > 0 && nextx <= M && !visited[nexty][nextx][judge(temp.broken)])
                if(map[nexty][nextx] == 0){
                    bfsQ.add(new Info(temp.y + dir[i][0], temp.x + dir[i][1], temp.broken));
                    visited[nexty][nextx][judge(temp.broken)] = true;
                    nextrep++;
                }
                else if(!temp.broken){
                    bfsQ.add(new Info(temp.y + dir[i][0], temp.x + dir[i][1], true));
                visited[nexty][nextx][0] = true; // 벽을 처음 부숨
                 nextrep++;   
                }
            } 
        }
            befrep = nextrep;
            nextrep = 0;
            answer++;
    }
    return -1; // 여기까지 오면 길이 없다는 뜻
}
    static int judge(boolean b){
        return b? 1 : 0;
    }
}
