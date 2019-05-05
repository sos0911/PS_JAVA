package backjoonalg;
import java.io.*;

public class Alg14890 {
    static boolean[] visited; // 이미 경사로를 논 곳을 구분
    static int N, L;
    static int[][] map; // (y,x)
    static int answer = 0; // 답
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        L = Integer.parseInt(temp[1]);
        map = new int[N][N]; // index 0부터 사용
        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(temp[j]);
        }
        for(int i = 0; i < N; i++){ // 행은 왼쪽에서 오른쪽, 열은 위에서 아래로 볼것
            FindWay(0, i, 0, 0, false);
             FindWay(1, i, 0, 0, false);   
        }
        System.out.println(answer);
    }// row col 
    static void FindWay(int mode, int index, int tgI, int currunL, boolean underway){ // tgI와 tgI+1을 비교
         if(underway && currunL+1 >= L){ // 공사 종료
            currunL = -1;
            underway = false;
        }
        if(underway && L - currunL > N-tgI) // 기저 사례 2
            return;
         if(tgI == N-1){ // 기저 사례
                answer++;
                return;
         }
        int diff;
        if(mode == 0) // 행
            diff = map[index][tgI] - map[index][tgI+1];
        else
            diff = map[tgI][index] - map[tgI+1][index];
            if(Math.abs(diff) >= 2) //  차이가 2 이상
                return;
            else if(Math.abs(diff) == 1){
                if(diff > 0){ // 현재 위치가 다음 것보다 더 높음
                    if(!underway)
                        if(mode == 0)
                    FindWay(0, index, tgI+1, 0, true);
                        else
                    FindWay(1, index, tgI+1, 0, true);
                    else{
                        if(currunL+1 >= L)
                            if(mode == 0)
                    FindWay(0, index, tgI+1, 0, false);
                        else
                     FindWay(1, index, tgI+1, 0, false);        
                        else
                            return;
                    }
                }
                else{ // 낮음
                    if(!underway && currunL+1 >= L) // 경사로 길이 충족
                        if(mode == 0)
                    FindWay(0, index, tgI+1, 0, false);
                        else
                     FindWay(1, index, tgI+1, 0, false);      
                    else
                    return;
                }
            }
            else{ // 차이가 0
                if(underway)
                    if(mode == 0)
                FindWay(0, index, tgI+1, currunL+1, true);
                    else
                FindWay(1, index, tgI+1, currunL+1, true);
                else
                    if(mode == 0)
               FindWay(0, index, tgI+1, currunL+1, false);
                    else
                 FindWay(1, index, tgI+1, currunL+1, false);
            }
        }   
    }
