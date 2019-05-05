package alg_03_2019;
import java.io.*;
import java.util.*;

// 학생들 번호 : 0 - 24
public class Alg1941 {
    static int answer = 0;
    static int Tvisited, nowv = 0; // 목표 방문치 / 현재 방문치 (in dfs)
    static int NofS = 0, cnt = 0; // dfs 내 parameter
    static char[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        for(int i = 0; i < 5; i++)
            map[i] = br.readLine().toCharArray();
        comb(0, -1, 0);
        System.out.println(answer); // 1이 나와ㅗ야 함..
    }
    static void comb(int ccnt, int lastI, int visited){ // 조합을 만듦
        if(ccnt == 7){
            Tvisited = visited;
            nowv = 0; NofS = 0; cnt = 1;
            int st = Integer.numberOfTrailingZeros(visited); // 탐색을 시작할 학생 번호
            nowv += (1 << st);
            if(map[st/5][st%5] == 'S')
                NofS = 1;
                dfs(st);
        }
        for(int i = lastI+1; i < 25; i++)
            comb(ccnt+1, i, visited + (1<<(i)));
    }
    static void dfs(int now){ // 공주들(visited)가 연결되었고 Y가 4 이상인지 확인
        if(cnt == 7 && NofS >= 4){
            answer++;
            return;
        }
        for(int i = 0; i < 4; i++){
            int nexty = now/5 + dir[i][0];
            int nextx = now%5 + dir[i][1];
            if(nexty >= 0 && nexty < 5 && nextx >= 0 && nextx < 5 && (nowv & (1 << (nexty*5 + nextx))) == 0 && (Tvisited & (1 << (nexty*5 + nextx))) > 0){ // 다음 칸이 범위 내고 방문한 칸이 아니고 찾아야 하는 칸이면
                nowv += (1 << (nexty*5 + nextx)); // 방문 체크
                cnt++;
            if(map[nexty][nextx] == 'S')
                NofS++;
            dfs(nexty*5 + nextx);
            }
        }
    }
}
