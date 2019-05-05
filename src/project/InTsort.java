package project;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class InTsort {
    
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Nofinput = Integer.parseInt(br.readLine());
         int[] howMinputs = new int[10001]; // 10000까지 저장하기 위한 크기 지정. 0으로 자동 초기화?
        for(int i = 0; i < Nofinput; i++)
           howMinputs[Integer.parseInt(br.readLine())]++;
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1 ; i <= 10000; i++){ // 1 - 10000까지
            while(howMinputs[i] != 0){
              bw.write(String.valueOf(i) + "\n");
            // bw.flush();
                howMinputs[i]--;
            }
        }
        br.close();
        bw.close();
    }
}
