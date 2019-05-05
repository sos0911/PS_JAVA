package alg_03_2019;
import java.io.*;
import java.util.*;
class Info1937{
    int y, x, val;
    public Info1937(int y, int x, int val){
        this.y = y;
        this.x = x;
        this.val = val;
    }
}
public class Alg1937 {
      public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int N = Integer.parseInt(br.readLine());
          Info1937[] input = new Info1937[N*N]; // 0 -
          // 2차원을 1차원으로 핀다는 느낌으로
          int[] dp = new int[N*N];
          // dp[i] = input[i]를 마지막으로 쓴 최장 생존 일수
          int rep = 0;
          StringTokenizer st;
          for(int i = 0; i < N; i++){
              st = new StringTokenizer(br.readLine());
              for(int j = 0; j < N; j++)
                  input[rep++] = new Info1937(i, j, Integer.parseInt(st.nextToken()));
          }
          Arrays.sort(input, (info1, info2) -> Integer.compare(info1.val, info2.val)); // val 오름차순 정렬
          Arrays.fill(dp, 1); // 최소 1일 생존
          for(int i = 0; i < N*N; i++)
              for(int j = 0; j < i; j++)
                 if((input[j].y == input[i].y && Math.abs(input[j].x - input[i].x) == 1) || (input[j].x == input[i].x && Math.abs(input[j].y - input[i].y) == 1)) // 인접한 타일이면 ㄱ
                     dp[i] = Math.max(dp[i], dp[j]+1);
          int ans = -1;
          for(int i = 0; i < N*N; i++)
              ans = Math.max(ans, dp[i]);
          System.out.println(ans);
      }
}
