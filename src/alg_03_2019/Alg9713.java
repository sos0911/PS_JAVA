package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg9713 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] sum = new int[101]; // 1 - 100
        int temp = 0;
        for(int i = 1; i <= 100; i++)
            sum[i] = (temp += i%2 == 1? i : 0); 
        int Noftc = Integer.parseInt(br.readLine());
        for(int i = 0; i < Noftc; i++)
            bw.write(sum[Integer.parseInt(br.readLine())] + "\n");
        bw.close();
    }
}
