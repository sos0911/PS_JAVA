package alg_11;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Collections;

class Point{
    private int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    int getX(){
        return x;
    }
    
    int getY(){
        return y;
    }
}

public class Alg2_5thweek{ // 도전 중 문제 :: 2583 (영여)
    static boolean[][] visited; // visited가 true인 애들은 방문하지 않았거나 직사각형에 속한 타일들이다.
    static int height, width, NumofRecs; // 모눈종이의 높이와 너비, 직사각형 개수
    static int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int NumofRemaindA = 0; // 나눠진 구역들의 수를 저장
 public static void main(String[] args) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     LinkedList<Integer> AreaofRecs = new LinkedList<Integer>(); // 사각형들의 넓이를 저장
     StringTokenizer st = new StringTokenizer(br.readLine());
     height = Integer.parseInt(st.nextToken());
     width = Integer.parseInt(st.nextToken());
     NumofRecs = Integer.parseInt(st.nextToken());
     visited = new boolean[width][height]; // 제일 왼쪽 아래 모눈종이 타일을 (0,0)으로 생각
     
     for(boolean[] i : visited)
     Arrays.fill(i, false);
     for(int i = 0; i < NumofRecs; i++){
         st = new StringTokenizer(br.readLine());
         Point leftdown = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
         Point rightup = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1); // 오른쪽 위 좌표는 -1씩 제해야 함
         for(int j = leftdown.getX(); j <= rightup.getX(); j++)
             for(int k = leftdown.getY(); k <= rightup.getY(); k++)
                 visited[j][k] = true; // 이 영역은 직사각형의 타일들이다.
     }
     for(int i = 0; i < width; i++)
         for(int j = 0; j < height; j++)
             if(!visited[i][j]){
                 AreaofRecs.add(SearchArea(i, j));
                 NumofRemaindA++;
             }
     
     Collections.sort(AreaofRecs); // 오름차순 정렬
     bw.write(String.valueOf(NumofRemaindA) + "\n");
     for(int i : AreaofRecs)
         bw.write(i + " ");
     
     bw.close();
 }
    
    static int SearchArea(int x, int y){ // 남는 공간 넓이 탐색 메소드
        if((x < 0 || x >= width) || (y < 0 || y >= height) || visited[x][y])
            return 0;
        
        visited[x][y] = true;
        int answer = 1; // 최소한 답은 자기 자신을 포함하므로 1부터 시작
        for(int i = 0; i < 4; i++)
            answer += SearchArea(x + directions[i][0], y + directions[i][1]);
        
        return answer;
    }
}
