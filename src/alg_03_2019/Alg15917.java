package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg15917 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Q = Integer.parseInt(br.readLine());
        for(int i = 0; i < Q; i++){
            int temp = Integer.parseInt(br.readLine());
            if((temp & -temp) == temp) // &연산자 우선순위에 주의
               bw.write("1\n");
            else
                bw.write("0\n");
        }
        bw.close();
    }
}
