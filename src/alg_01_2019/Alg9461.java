package alg_01_2019;
import java.io.*;
public class Alg9461 {
    
    public static void main(String[] args) throws IOException{
        long[] p = new long[101]; // index 1 - 100
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        p[4] = 2;
        p[5] = 2;
        for(int i = 6; i <= 100; i++)
            p[i] = p[i-1] + p[i-5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Noftc = Integer.parseInt(br.readLine());
            
        for(int i = 0; i < Noftc; i++)
            System.out.println(p[Integer.parseInt(br.readLine())]);
    }
}
