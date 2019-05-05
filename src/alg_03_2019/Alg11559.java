package alg_03_2019;
import java.io.*;
import java.util.*;
class point11559{
    int y, x;
    public point11559(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Alg11559 {
    static char[][] map = new char[12][6]; // 0-
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited = new boolean[12][6];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 12; i++)
        map[i] = br.readLine().toCharArray();
        int answer = 0;
          while(bfs()){
              answer++;
          }
        System.out.println(answer);
    }
    static boolean bfs(){ // 모든 점에 대해 findrel 시도
        // 현재 상태에서 지울 뿌요가 있는가를 찾는다
        // 현재 상태는 중력을 받은 상태라고 가정
      //  System.out.println("bfs started");
        boolean check2 = false;
        for(boolean[] arr : visited)
            Arrays.fill(arr, false); // 방문 초기화
        for(int i = 0; i < 12; i++)
            for(int j = 0; j < 6; j++)
                if(map[i][j] != '.' && !visited[i][j])
                    if(findrel(new point11559(i, j))){
                        /*  for(char[] c : map){
            System.out.print(c);
        System.out.println("");
        } */
                        check2 = true;
                    }
        drop(); // 상태 갱신(중력)
        return check2;
    }
    static boolean findrel(point11559 start){ // 해당 색상의 최대 인접 수가 4 이상이면 다 .으로 바꿈
        int answer = 1; char col = map[start.y][start.x];
        LinkedList<point11559> bfsQ = new LinkedList<point11559>();
        LinkedList<point11559> ans = new LinkedList<point11559>(); // 좌표들 모음
        bfsQ.add(start);
        visited[start.y][start.x] = true;
        int nexty, nextx;
        while(!bfsQ.isEmpty()){
            point11559 temp = bfsQ.poll();
            ans.add(temp); // 답 추가
            for(int i = 0; i < 4; i++){
                nexty = temp.y + dir[i][0];
                nextx = temp.x + dir[i][1];
                if(nexty >= 0 && nexty < 12 && nextx >= 0 && nextx < 6 && !visited[nexty][nextx] && map[nexty][nextx] == col){ 
                    // 범위 내 / 방문x / 색상동일
                    bfsQ.add(new point11559(nexty, nextx));
                 visited[nexty][nextx] = true;
                    answer++;
                }
            }
        }
      //  System.out.println("찾는 글자 : " + col);
       // System.out.println("인접한 글자 수 :" + answer);
        if(answer >= 4){
         for(point11559 p : ans)
            map[p.y][p.x] = '.'; // . 변환
         return true;   
        }
        else
            return false;
    }
    static void drop(){ // 중력에 따르게 각 열마다 갱신
        for(int j = 0; j < 6; j++){
      StringBuilder sb = new StringBuilder();
        for(int i = 11; i >= 0; i--)
            if(map[i][j] != '.')
            sb.append(map[i][j]);
        int len = sb.length();
         for(int i = 0; i < 12; i++)
            if(i < len)
                map[11-i][j] = sb.charAt(i);
            else
                map[11-i][j] = '.';
        }
    }
}
/*
메소드가 3개는 필요한데?

1. 현재 상태에서 없어질 구간들 bfs 탐색
2. 구간들을 없앰
3. 그만큼 아래로 땡기는 메소드

while(bfs() != 0)
..

bfs() -> 제일 아래 줄을 탐색해서 
해당 색깔 탐색하여 4개 이상이면 .으로 고침 (연쇄는 +1)

아래로 땡기는건
각 열을 봐서 
제일 아래 줄이 .이 아니다? -> pass

제일 아래 줄이 .이다?> -시행
글자 나올때까지 올라가고 글자들 있는 만큼 내리면됨
어차피 .들 말고 위에 있는 글자들은 붙어 있으니까 앞에 짤라서 [] 통째로 붙이면됨

연쇄 반환

while절 종료 :: answer 증가가 x
*/