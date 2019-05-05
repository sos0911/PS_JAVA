package alg_03_2019;
import java.io.*;
import java.util.*;
class point2151{
    int y, x, Nofm, dir; // 좌표와 거울의 개수, 방향(0123-좌우하상)
    public point2151(int y, int x, int Nofm, int dir){
        this.y = y;
        this.x = x;
        this.Nofm = Nofm;
        this.dir = dir;
    }
}
public class Alg2151 {
    static char[][] map;
    static int N;
    static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N]; // 0 - 
        point2151 start = new point2151(-1, -1, -1, -1); // initial v
        for(int i = 0; i < N; i++){ // 입력
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                char tar = temp.charAt(j);
                if(tar == '#') // 시작 방향 정함
                    start = new point2151(i, j, 0, -1);
                map[i][j] = tar; 
            }
        }
        if(N == 1)
            System.out.println(0);
        else
       System.out.println(bfs(start));
    }
    static int bfs(point2151 start){ // 다른 #까지의 경로 중 조건에 맞는 경로 중 가장 적게 꺾이는 경로에서 답 찾아 출력
        LinkedList<point2151> bfsQ = new LinkedList<point2151>();
        int[][][] visited = new int[N][N][4]; // 각 방향 접근 시 그 지점을 거쳐가는 경로 중 가장 작은 거울 수를 거쳐야만 통과 가능
        for(int[][] arr1 : visited)
            for(int[] arr2 : arr1)
                Arrays.fill(arr2, 3000); // 초기값 채우기
        for(int j = 0; j < 4; j++){
        bfsQ.add(new point2151(start.y, start.x, 0, j));
            visited[start.y][start.x][j] = 0;
        }
        int answer = 3000;
        while(!bfsQ.isEmpty()){ // 가능한 경로가 없을 때까지 반복
                point2151 temp = bfsQ.poll();
                if(map[temp.y][temp.x] == '#' && (temp.y != start.y || temp.x != start.x)){
                    answer = Math.min(answer, temp.Nofm);
                   // System.out.println("answer 갱신됨 : " + answer);
                    continue;
                }
                if(map[temp.y][temp.x] != '*'){
                    int nexty = temp.y + dir[temp.dir][0];
                    int nextx = temp.x + dir[temp.dir][1];
                    if(nexty >= 0 && nexty < N && nextx >= 0 && nextx < N && temp.Nofm < visited[nexty][nextx][temp.dir]){ // 범위 내고 거울 수 down
                bfsQ.add(new point2151(nexty, nextx, temp.Nofm, temp.dir));
                       // System.out.println("visited : " + nexty + " " + nextx);
                    visited[nexty][nextx][temp.dir] = temp.Nofm;
                }
                }
                if(map[temp.y][temp.x] == '!') // 거울 설치 가능
                    for(int j = 0; j < 4; j++){
                         int nexty = temp.y + dir[j][0];
                    int nextx = temp.x + dir[j][1];
                        if(nexty >= 0 && nexty < N && nextx >= 0 && nextx < N && temp.Nofm+1 < visited[nexty][nextx][j] && j != temp.dir && j != (temp.dir^1)){ // 범위 내고 방문 x
                             // 방향은 원래 방향과 반대 방향 제외
                    bfsQ.add(new point2151(nexty, nextx, temp.Nofm+1, j));
                          //  System.out.println("visited : " + nexty + " " + nextx);
                             visited[nexty][nextx][j] = temp.Nofm + 1;
                        }
                    }
            }
        return answer;
    }
}

/*
오는 방향이 x면

(거울 만날 때)

다음 방향이 자기 자신과 x+1 /2 + x+1 % 2 인거 빼고 bfs 넣기
*/
/*
와 ㅅㅂ
한 경로에서 같은 거울을 두 번 타는 경우도 고려해야함?? 
*/
/*
틀린tc..
8
***#****
*!.!..!*
*......*
*..*...*
*!!....*
*.!!..!*
*......*
***#****

>> 4
*/