package backjoonalg;
import java.util.Scanner;

public class Alg1038 {
    static int dp[] = new int[11]; // 1자리 - 10자리(index 1부터)
    static int[] number; // 정답 수
    static int Nofdigit, index, N; // 탐색할 숫자의 자릿수와 로테이션 인덱스 초기화
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp[1] = 10;
        for(int i = 2; i < 11; i++)
            dp[i] = dp[i-1]*(11-i)/i; // dp값 세팅
        int temp = 0;
        for(int i = 1; i < 11; i++)
            if((temp += dp[i]) > N){
                Nofdigit = i;
             break;   
            }
        if(Nofdigit == 0){
            System.out.println("-1");
         return;
        }
        index = temp - dp[Nofdigit];
        number = new int[Nofdigit];
        MakeN(0, 10); // 0 - 9이므로
    }
    static void MakeN(int Nofcom, int lastI){ // 내림차순으로 숫자를 만든다.
        if(Nofcom == Nofdigit){
            if(index == N)
                for(int i : number)
                    System.out.print(i);
            index++;
            return;
        }
        for(int i = 0; i < lastI; i++){
            number[Nofcom] = i;
            MakeN(Nofcom+1, i);
        }
    }
}

/*
브루트 포스 ::
각 단계(자리 숫자를 정해줌)마다 0부터 숫자를 차례대로 만들며
(내림차순)
가능한 모든 내림차순 조합을 다 해봤으면
자리를 하나 늘려 계속 진행 
*/