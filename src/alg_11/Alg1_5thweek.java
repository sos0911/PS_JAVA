package alg_11;
import java.util.Scanner;

public class Alg1_5thweek { // 1977번 완전제곱수 도전 중
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        int N = Integer.parseInt(sc.nextLine());
        int possibleM = (int)Math.sqrt(Double.valueOf(M));
        int standardN = (M == possibleM)? M : possibleM + 1; // 같지 않다면 x.yyy 에서 y가 0이 아닌 상태임
        int answer = 0;
        int temp, min = 10001; // min만 초기화
        while((temp = (int)Math.pow(standardN, 2)) >= M && temp <= N){
            answer += temp;
            if(temp < min)
                min = temp;
            standardN++;
        }
        if(answer == 0){
            System.out.println("-1");
            return;
        }
        else{
            System.out.println(answer);
            System.out.println(min);
    }
}
}