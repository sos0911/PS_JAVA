package backjoonalg;
import java.util.*;
public class Alg1676 {
    
     public static void main(String[] srgs){ // 진행중..
         int[] digit = new int[1002]; // 각 자리의 자릿수(index 1 = 1001)
         Arrays.fill(digit, -1); // 초기화
         digit[1] = 1; // 1!
        Scanner sc = new Scanner(System.in);
         int FirstZin = 0, answer = 0; // 아직 0이 없으므로
         String temp;
         int N = sc.nextInt();
         for(int i = 2; i <= N; i++){ // i!을 만듦
             for(int j = 1; j < 1002; j++){
                 if(digit[j] == -1) // 건드릴 필요가 없는 자릿수에 도달하면 skip*(여기가 문제)
                     break;
                 temp = String.valueOf(digit[j] *= i);
                 int templen = temp.length();
                 if(templen > 1) // 10 이상 > carry 발생
                    for(int k = 0; k < templen; k++)
                            digit[j+templen-1-k] += temp.charAt(k) - '0';
             } // i! 빌딩 완료
             while(digit[FirstZin+1] == 0){
                 answer++;
                 FirstZin++;
             }
             int l = 1;
             while(digit[l] != -1){
                 System.out.print(digit[l] + " ");
              l++;   
             }
             System.out.println("");
         }
     System.out.println(answer);    
    } 
}
