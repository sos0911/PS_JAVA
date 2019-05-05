package alg_02_2019;
import java.io.*;
public class Alg2749 {
    static long[][] input = {{1,1}, {1,0}};
    static int stN = 1000000007;
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if(N > 1){
        long[][] temp = Makepow(N-1); // temp의 (0,0)이 답
            System.out.println(temp[0][0]);
        }
        else
            System.out.println(N);
    }
      static long[][] Makepow(long rep){ // input^N-1 결과를 answer에 저장하여 참조값 return
        long[][] answer, temp;
        if(rep == 1)
         return answer = input;
         temp = Makepow(rep/2); // 이 시점에서 temp에 수행 결과 저장
        if(rep % 2 == 0)
         answer = Makepromul(temp, temp);
        else
            answer = Makepromul(Makepromul(temp, temp), input);
        return answer;
    }
    static long[][] Makepromul(long[][] A, long[][] B){ // A*B 결과행렬 참조값을 return
        long[][] answer = new long[2][2]; 
        for(int i = 0; i < 2; i++)
              for(int j = 0; j < 2; j++){
                  for(int k = 0; k < 2; k++)
                      answer[i][j] += (A[i][k]*B[k][j])%stN;
               answer[i][j] %= stN;   
              }
        return answer;
    }
}