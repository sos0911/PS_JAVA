package alg_03_2019;
import java.io.*;
import java.util.*;
class Info6593{
    int h, y, x;
    public Info6593(int h, int y, int x){
        this.h = h;
        this.y = y;
        this.x = x;
    }
}
public class Alg6593 {
    // 다익스트라 or bfs인데 O(V + E)이 훨씬 낫지 ㅎㅎ
    // 어차피 map에 각 TC마다 덮어씌우므로 초기화x
    static char[][][] map; // map
    static int L, R, C;
    static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        map = new char[30][30][30]; // 0부터 시작
        while(true){
            st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0)
                break;
            String temp;
            Info6593 start = new Info6593(-1 ,-1 ,-1);
        for(int i = 0; i < L; i++){
            for(int j = 0; j < R; j++){
                temp = br.readLine();
                for(int k = 0; k < C; k++){
                    map[i][j][k] = temp.charAt(k);
                    if(map[i][j][k] == 'S')
                        start = new Info6593(i, j, k);
                }
            }
            temp = br.readLine(); // 줄 개행
        }
            int answer = bfs(start); // start 넘겨줌
            if(answer == -1)
                 bw.write("Trapped!\n");
            else
                bw.write("Escaped in " + answer + " minute(s).\n");
        }
        bw.close();
    }
    static int bfs(Info6593 start){
        // 못 찾으면 -1
        LinkedList<Info6593> bfsQ = new LinkedList<Info6593>();
        bfsQ.add(start);
        boolean[][][] visited = new boolean[L][R][C]; // 0부터, false 초기화
        boolean FindA = false;
        int cost = 0, befrep = 1, afrep = 0, answer = 0; // 걸리는 시간
            outerloop:
            while(!bfsQ.isEmpty()){
                for(int j = 0; j < befrep; j++){
                Info6593 temp = bfsQ.poll();
                for(int i = 0; i < 6; i++){
                    int nexth = temp.h + dir[i][0];
                    int nexty = temp.y + dir[i][1];
                    int nextx = temp.x + dir[i][2];
                    if(nexth >= 0 && nexth < L && nexty >= 0 && nexty < R && nextx >= 0 && nextx < C && !visited[nexth][nexty][nextx]){
                        if(map[nexth][nexty][nextx] == '.'){
                        bfsQ.add(new Info6593(nexth, nexty, nextx));
                     visited[nexth][nexty][nextx] = true;   
                        afrep++;
                    }
                        else if(map[nexth][nexty][nextx] == 'E'){
                            FindA = true;
                            break outerloop;
                        }
                    }
                }
            }
                befrep = afrep;
                afrep = 0;
                answer++;
            }
        if(!FindA)
            return -1;
        else
        return answer+1;
    }
}
