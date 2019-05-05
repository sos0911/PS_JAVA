package alg_03_2019;
import java.io.*;
import java.util.*;
class point2573{
    int y, x, deval; // 줄어들 값
    public point2573(int y, int x, int deval){
        this.y = y;
        this.x = x;
        this.deval = deval;
    }
}
public class Alg2573 {
    static LinkedList<point2573> ice = new LinkedList<point2573>(); // 현재 빙산들 위치와 줄어들 값 저장
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] map; // 단위 년마다의 상태
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); int tempi;
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                if((tempi = Integer.parseInt(st.nextToken())) != 0)
                    ice.add(new point2573(i, j, -1)); // 빙산 위치 저장
                map[i][j] = tempi;
            }
        }
        // input은 한덩어리
        int answer = 0;
        Iterator<point2573> itr;
        boolean check = true;
       do{
           answer++;
           itr = ice.iterator();
             while(itr.hasNext())
                 itr.next().deval = 0; // 줄어드는 값 초기화
           itr = ice.iterator();
             while(itr.hasNext()){
                 point2573 temp = itr.next();
               for(int i = 0; i < 4; i++){
                   int nexty = temp.y + dir[i][0];
                   int nextx = temp.x + dir[i][1];
                   if(map[nexty][nextx] == 0)
                       temp.deval++;
               }
             }
            itr = ice.iterator();
           while(itr.hasNext()){
               point2573 temp = itr.next();
              if(map[temp.y][temp.x] - temp.deval <= 0){
                  itr.remove();
                  map[temp.y][temp.x] = 0;
              }
               else
                map[temp.y][temp.x] -= temp.deval;
           }
       }
        while(!ice.isEmpty() && (check = Isone(ice.getFirst()))); // 빙산이 남아 있고 한 덩어리인 한 반복
        if(!check)
        System.out.println(answer);
        else // 두 덩어리 이상이다가 바로 녹아버린 
            System.out.println(0);
    }
    static boolean Isone(point2573 start){ // 한 덩어리면 true
       boolean[][] visited = new boolean[N][M];
        LinkedList<point2573> bfsQ = new LinkedList<point2573>();
        bfsQ.add(start);
        visited[start.y][start.x] = true;
        while(!bfsQ.isEmpty()){
            point2573 temp = bfsQ.poll();
             for(int i = 0; i < 4; i++){
                   int nexty = temp.y + dir[i][0];
                   int nextx = temp.x + dir[i][1];
                   if(map[nexty][nextx] != 0 && !visited[nexty][nextx]){
                       bfsQ.add(new point2573(nexty, nextx, -1)); // -1은 의미x
                       visited[nexty][nextx] = true;
                   }
               }
        }
       for(point2573 p : ice)
           if(!visited[p.y][p.x])
               return false;
        return true;
    }
}
