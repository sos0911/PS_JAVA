package SecondTry;
import java.io.*;
import java.util.*;
class paper{
    int y, x;
    public paper(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Alg2643{
     // tc : O(NlogN + N^2)
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Nofp = Integer.parseInt(br.readLine());
        paper[] input = new paper[Nofp]; // 0 - 
        int[] dp = new int[Nofp]; // 0 - 
        StringTokenizer st;
        for(int i = 0; i < Nofp; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(y < x){
                int temp = x;
                x = y;
                y = temp;
            }
            input[i] = new paper(y, x);
        }
        // 상대적 크기 역순으로 정렬 
        // 결과가 =< 0이면 그대로 놓고 > 0 이면 바꿈 
        Arrays.sort(input, (paper p1, paper p2) -> Integer.compare(p1.y, p2.y) != 0? Integer.compare(p1.y, p2.y) : Integer.compare(p1.x, p2.x));
        for(int i = 0; i < Nofp; i++)
            System.out.print(input[i].y + "/" + input[i].x + " ");
        System.out.println(""); 
        for(int i = 0; i < Nofp; i++){
            dp[i] = 1; // 자기 자신
            for(int j = 0; j < i; j++) // 색종이 i가 색종이 j에 포함되어야 함
                if(input[i].y >= input[j].y && input[i].x >= input[j].x)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
         for(int j = 0; j < Nofp; j++)
             System.out.print(" dp/" + j + " :: " + dp[j]);
            System.out.println("");
        }
        int max = -1;
        for(int i = 0; i < Nofp; i++)
            max = Math.max(max, dp[i]);
        System.out.println(max);
    }
}
/*
dp[] : 처음에 쓴 색종이 index가 i일때 쌓은 최대장수
(범위 : 0 - i)

for(j = 0 - i) 
조건맞으면
dp[i] = Math.max(dp[i], dp[j] + 1)
*/