package alg_01_2019;
import java.util.*;
import java.io.*;

public class Alg1022 {
    public static void main(String[] args) throws IOException{
         Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] map; 
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 오위왼아
        int[] coord = new int[4]; // (r1, c1), (r2, c2)
        int max = -1;
          for(int i = 0; i < 4; i++){
              coord[i] = sc.nextInt();
            max = Math.max(Math.abs(coord[i]), max);
          }
        map = new int[coord[2] - coord[0]+1][coord[3] - coord[1]+1];  
        int sty = max, stx = max, val = 1, rep = 1, stn = 2, ins = 1;// 출발점, 단계값, 반복수, 기준수, 기준수 증가수
        int dirI = 0; // dir배열 index
        while(sty != max*2 || stx != max*2 + 1){
            if(sty >= max+coord[0] && sty <= max+coord[2] && stx >= max+coord[1] && stx <= max+coord[3]) // 범위 내 숫자라면 출력
            map[sty-max-coord[0]][stx-max-coord[1]] = val; // ㅅㅂ 이쪽이 문제네
            if(val == stn){
                dirI = (dirI+1) % 4; // 방향 전환
                stn += ins;
                rep++;
                if(rep == 2){
                    ins++;
                  rep = 0; // 초기화   
                }
            }
            sty += dir[dirI][0]; stx += dir[dirI][1]; // 다음 좌표 결정
            val++; // 단계값 증가
        }
        int maxN = -1;
        for(int i = 0; i <= coord[2] - coord[0]; i++)
            for(int j = 0; j <= coord[3] - coord[1]; j++)
                maxN = Math.max(maxN, map[i][j]); // 최대수 뽑기
        int maxlen = String.valueOf(maxN).length() + 1;
      for(int i = 0; i <= coord[2] - coord[0]; i++){
            for(int j = 0; j <= coord[3] - coord[1]; j++)
                if(j == 0)
                     bw.write(String.format("%" + (maxlen-1) + "d", map[i][j]));
          else
                bw.write(String.format("%" + maxlen + "d", map[i][j]));
         bw.newLine();   
        }
        bw.close();
    }
}