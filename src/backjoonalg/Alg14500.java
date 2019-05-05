package backjoonalg;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Alg14500 {
    static int[][] map;
    static int answer = -1; // 최종 답
    static int tempA = 0; // 각 단계에서 쓰일 임시답
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; // 방향
    static boolean[][] visited; // 방문 배열
    static int Hofm, Wofm;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Hofm = Integer.parseInt(st.nextToken());
        Wofm = Integer.parseInt(st.nextToken());
        map = new int[Wofm][Hofm]; // 0,0부터 시작(x,y)
        visited = new boolean[Wofm][Hofm];
        for(boolean[] v : visited)
            Arrays.fill(v, false);
        for(int i = 0; i < Hofm; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < Wofm; j++)
                map[j][i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < Hofm; i++)
            for(int j = 0; j < Wofm; j++)
                FindminV(j, i, 0); // (0,0)부터
        System.out.println(answer);
    }
    static void FindminV(int x, int y, int length){ // (x,y), 지금까지 완성한 length. 한 step당 한 조각을 이어붙인다.
         if(length == 4){
            if(tempA > answer)
                answer = tempA;
            return; // 종료
        }
        if(x < 0 || x >= Wofm || y < 0 || y >= Hofm)
            return; // 종료
        if(visited[x][y])
            return; // 종료
      
        
        for(int i = 0; i < 4; i++){
            tempA += map[x][y];
            visited[x][y] = true;
            if(length == 1)
                FindspS(x, y, 0, -1); // 5번째 조각도 찾아보기
            FindminV(x + dir[i][0], y + dir[i][1], length+1);
            tempA -= map[x][y];
            visited[x][y] = false;
        }
    }
    static void FindspS(int x, int y, int rep, int lastI){ // 두 조각을 찾아 이어야 한다.
        if(rep == 2){
             if(tempA > answer)
                answer = tempA;
            return; // 종료
        }
        
        for(int i = lastI+1; i < 4; i++)
            if(x + dir[i][0] >= 0 && x + dir[i][0] < Wofm && y + dir[i][1] >= 0 && y + dir[i][1] < Hofm && !visited[x + dir[i][0]][y + dir[i][1]]){
            tempA += map[x + dir[i][0]][y + dir[i][1]];
            FindspS(x, y, rep+1, i);
            tempA -= map[x + dir[i][0]][y + dir[i][1]];
            }
    }
}
