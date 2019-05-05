package alg_01_2019;
import java.io.*;
public class Alg1912 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N+1]; // index 1 - N
        int[] tempi = new int[N+1]; // index i을 포함한 구간 1 - i까지 사용하여 가장 큰 합을 저장
        String[] temp = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < N+1; i++){
            input[i] = Integer.parseInt(temp[i-1]);
         tempi[i] = Math.max(tempi[i-1] + input[i], input[i]); // 연속해서 i를 쓰느냐 i부터 새로 시작하느냐를 결정
            if(tempi[i] > max)
                max = tempi[i];
        }
        System.out.println(max);
    }
}
