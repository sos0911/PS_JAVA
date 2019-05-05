package alg_02_2019;
import java.util.*;
import java.io.*;
public class Alg1024 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int L = Integer.parseInt(temp[1]);
       for(int i = L; i <= 100; i++){
           if(i % 2 == 1 && N % i == 0){ // 수열이 홀수개고 그 중앙의 수가 N/L일때 정답
               if(N/i - i/2 >= 0){
               for(int j = N/i - i/2; j <= N/i + i/2; j++)
                   bw.write(j + " ");
                   bw.close();
                return;   
               }
           }
           else if(i % 2 == 0 && N % i != 0 && (N*2) % i == 0 && (N*2)/i == (N/i)*2 + 1){// 수열이 짝수개고 최중앙의 인접한 수 두 개의 중간이 N/L일때 정답
               if(N/i - (i/2-1) >= 0){
               for(int j = N/i - (i/2-1); j <= N/i + i/2; j++)
                   bw.write(j + " ");
                   bw.close();
            return;   
               }
           }
       }
        bw.write("-1");
        bw.close();
       }
    }