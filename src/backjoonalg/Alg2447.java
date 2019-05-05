package backjoonalg;
import java.util.Scanner;
import java.io.*;
public class Alg2447 {  // 별 찍기 - 2447번
    static String[] BES; // 이전 단계 답
    static String[] AES; // 현재 단계 답
    static String[] STN = {"*"};
    public static void main(String[] args) throws IOException{ // 결과에서 null을 없애면 된다ㅜㅜ
            Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = sc.nextInt();
        SetForm(N);
        for(String a : AES){
            bw.write(a + "\n");
        }
        bw.close();
    }
        static void SetForm(int N){
            if(N == 1){
              AES = STN;
             return;   
            }
            SetForm(N/3);
            BES = AES;
            AES = new String[N];
            for(int i = 0; i < N; i++)
                AES[i] = new String("");
          for(int i = 0; i < N/3; i++)
                  for(int k = 0; k < 3; k++)
              AES[i] += BES[i];
        for(int i = N/3; i < 2*N/3; i++){
                 AES[i] += BES[i-(N/3)];
             for(int j = 0; j < N/3; j++)
                AES[i] += " ";
                AES[i] += BES[i-(N/3)];
            }
             for(int i = 2*N/3; i < N; i++)
              for(int j = 0; j < 3; j++)
                   AES[i] += BES[i-(2*N/3)];
        
    }
}
