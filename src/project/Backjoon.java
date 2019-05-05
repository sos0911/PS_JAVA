package project;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Backjoon{ // 진행중 문제 : 골드바흐의 추측 (9020번)
    // main idea : 12 같이 6+6으로 되는 수는 5 + 7부터 시작 / 14 같이 7+7으로 되는 수는 7 + 7부터 시작. 1씩 +- 해보면서 찾아낸다
    
    public static void main(String[] args) throws IOException{
        
        boolean[] Isthatprime = new boolean[10001]; // 0 - 10000
        Arrays.fill(Isthatprime, true);
        Isthatprime[0] = false;
          Isthatprime[1] = false;
        int iterator = (int)Math.sqrt((double)10000);
        for(int i = 2; i <= iterator; i++)
            for(int j = i*i; j <= 10000; j += i)
                Isthatprime[j] = false;
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Nofinput = Integer.parseInt(br.readLine());
        for(int i = 0; i < Nofinput; i++){
            int input = Integer.parseInt(br.readLine());
            int oneside = input/2;
            if(Isthatprime[oneside])
                bw.write(String.valueOf(oneside) + " " + String.valueOf(oneside));
            else{
                if(oneside % 2 == 0)
                    oneside++;
                else
                    oneside += 2;
                while(!Isthatprime[oneside] || !Isthatprime[input-oneside]){
                    oneside += 2;
                }
                   bw.write(String.valueOf(input-oneside) + " " + String.valueOf(oneside));
            }
            bw.newLine();
        }
        bw.close();
    }
}