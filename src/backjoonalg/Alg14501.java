package backjoonalg;
import java.util.Scanner;
import java.util.Arrays;

public class Alg14501 {
    static int[] dp; // index일까지 잡을 때 가능한 최대 이익 저장
    static int[][] input;
    static int N;
    public static void main(String[] args){ // 완전 탐색부터 해보자..
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        Arrays.fill(dp, -1);
        input = new int[N][2]; // index 0부터 사용
        for(int i = 0; i < N; i++){
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            sc.nextLine();
        }
         dp = new int[N+1]; // index 1부터 사용
        if(input[0][0] == 1) // 기저 사례 저장
            dp[1] = input[0][1];
        else
            dp[1] = 0;
        System.out.println(FindMaxO(N, N-1));
    }
    static int FindMaxO(int endd, int startI){ // 상담을 endd까지 잡을 때 최대 이익을 반환. 각 단계마다 가용 가능한 input[] index는 0~startI까지임
    if(endd == 1) // 기저 사례
        return dp[1];
        
    if(dp[endd] != -1)
        return dp[endd];
    else{
         while(startI >= 0 && startI + input[startI][0] > endd) // 한도 내에서 조건에 맞는 상담 하나를 찾는다.
             startI--;
        if(startI == -1) // 모든 상담이 조건에 맞지 않는다.
            return 0;
        else
        return dp[endd] = input[startI][1] + FindMaxO(startI, startI-1);
        }
        
    }
}
