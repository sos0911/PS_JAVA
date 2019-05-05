package backjoonalg;
import java.util.*;

public class Alg14502 {
    static int Hofm, Wofm;
    static int[][] map;
    static int answer = -1, tempA; // 답 변수, FindmaxV() 저장 임시답
    static int Nofone = 0; // 기존 벽의 개수
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 방향
    static boolean[][] visited; // 방문 배열(dfs)
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Hofm = sc.nextInt();
        Wofm = sc.nextInt();
        map = new int[Wofm][Hofm];
        visited = new boolean[Wofm][Hofm];
        for(boolean[] a : visited) 
        Arrays.fill(a, false); 
        for(int i = 0; i < Hofm; i++){
            for(int j = 0; j < Wofm; j++){
                 map[j][i] = sc.nextInt();
                if(map[j][i] == 1)
                    Nofone++;
            }
            sc.nextLine();
        }
        FindThreeW(0, 0, 0);
        System.out.println(answer);
    }
    static void FindThreeW(int x, int y, int NofW){
        if(y == Hofm)
            return;
        if(NofW == 3){ // 세개의 벽을 다 세움
            if((tempA = Hofm*Wofm - (FindmaxV(0, 0) + 3 + Nofone)) > answer)
                answer = tempA;
            for(boolean[] a : visited) 
        Arrays.fill(a, false); 
            return;
        }
        
        if(x != 0 || (x == 0 && y == 0))
            for(int i = x; i < Wofm; i++)
                if(map[i][y] == 0){
                    map[i][y] = 1;
                 if(i == Wofm-1)
                     FindThreeW(0, y, NofW+1);
                    else
                     FindThreeW(i+1, y, NofW+1);
                    map[i][y] = 0; // 원상복귀 
                }
        
            for(int j = y+1; j < Hofm; j++)
                for(int i = 0; i < Wofm; i++)
                if(map[i][j] == 0){
                    map[i][j] = 1;
                 if(i == Wofm-1)
                     FindThreeW(0, j, NofW+1);
                    else
                     FindThreeW(i+1, j, NofW+1);
                    map[i][j] = 0; // 원상복귀 
                }
    }
    static int FindmaxV(int x, int y){ // 현 상태의 map에서 virus 살포 지역 산출
        int eachA = 0;
        for(int i = y; i < Hofm; i++)
            for(int j = x; j < Wofm; j++)
                if(map[j][i] == 2 && !visited[j][i])
                    eachA += dfs(j, i);
        return eachA;     
    }
    static int dfs(int x, int y){ // 그 점에서 virus가 퍼지는 구역 산출
        if(x < 0 || x >= Wofm || y < 0 || y >= Hofm)
            return 0;
        if(map[x][y] == 1)
            return 0;
        if(visited[x][y])
            return 0;
        
        int area = 0;
        for(int i = 0; i < 4; i++){
            visited[x][y] = true;
            area += dfs(x + dir[i][0], y + dir[i][1]);
        }
        return area + 1;
    }
}
