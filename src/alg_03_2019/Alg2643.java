package alg_03_2019;
import java.io.*;
import java.util.*;
class paper{
    int y, x;
    public paper(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Alg2643 {
     // tc : O(NlogN + N^2)
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Nofp = Integer.parseInt(br.readLine());
        paper[] input = new paper[Nofp]; // 0 - 
        int[] dp = new int[Nofp]; // 0 - 
        StringTokenizer st;
        for(int i = 0; i < Nofp; i++){
            st = new StringTokenizer(br.readLine());
            input[i] = new paper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // 상대적 크기 역순으로 정렬 
        // 결과가 =< 0이면 그대로 놓고 > 0 이면 바꿈 
       Arrays.sort(input, (paper p1, paper p2) -> ((p1.y < p2.y && p1.x < p2.x) || (p1.y < p2.x && p1.x < p2.y) || (p1.y == p2.y && p1.x < p2.x) || (p1.y < p2.y && p1.x == p2.x) || (p1.y == p2.x && p1.x < p2.y) || (p1.y < p2.x && p1.x == p2.y))? 1 : -1);
        for(int i = 0; i < Nofp; i++)
            System.out.print(input[i].y + "/" + input[i].x + " ");
        System.out.println(""); 
        for(int i = 0; i < Nofp; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++) // 색종이 i가 색종이 j에 포함되어야 함
                if((input[i].y <= input[j].y && input[i].x <= input[j].x) || (input[i].y <= input[j].x && input[i].x <= input[j].y))
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        }
        for(int j = 0; j < Nofp; j++)
             System.out.print(" dp/" + j + " :: " + dp[j]);
            System.out.println("");
        int max = -1;
        for(int i = 0; i < Nofp; i++)
            max = Math.max(max, dp[i]);
        System.out.println(max);
    }
}
// dp[i] : 가장 위에 있는 종이가 input[i]일때 최대 장수
// dp[i]의 초기세팅값은 자기 자신이므로 1