/*package SecondTry;
import java.io.*;
public class Alg1022_1 {
    class point{
        int y, x;
        public point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        point p1 = new point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        point p2 = new point(Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
        int[][] map = new int[Math.abs(p1.y - p2.y)][Math.abs(p1.x - p2.x)];
        point cur = new point(0, 0), des = new point(p1.y, p1.x); // 현재 좌표, 목적지
        int[] ins = {1, 2, 3, 4, 5, 6, 7, 8}; // 반시계 방향으로 도는 초기 증가값
        // 이제 (0,0)에서 stp까지 가야함
      while(cur.y != des.y || cur.x != des.x) // 방향에 맞춰 나아가기
            if(stp.y < 0 && stp.x < 0)
            
        
            
        
        
    }
}
*/
/*
출력할 map만 딱 만들어놓고
규칙을 통해 답들을 찾아나가야 한다..
범위 중 
(0,0)에서 가장 가까운 좌표로 가서 시작한다. 
각 방향으로 뻗어 나갈 때 증가치는 
+8씩 증가
*/
