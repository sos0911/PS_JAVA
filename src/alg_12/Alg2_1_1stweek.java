package alg_12;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Alg2_1_1stweek { // 5386번 도전 중
                
    public static void main(String[] args) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int NofTC = Integer.parseInt(br.readLine());
        for(int i = 0; i < NofTC; i++){
            int answer = -1; // 최종 답
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Nofcoin = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
           if(K % 2 == 1)
              answer = Nofcoin % 2;
            else{ // k는 짝수
                int key = Nofcoin % (K+1);
               if(key == K)
                   answer = K;
                else if(key == 0)
                    answer = 0;
                else
                    answer = key % 2;   
            }
            bw.write(answer + "\n");
        }
        bw.close();
    }
}
