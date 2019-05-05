package backjoonalg;
import java.io.*;
import java.lang.*;

public class Alg1373 {
    static StringBuilder answer = new StringBuilder(333339);
    static int[] pow = {1, 2, 4};
    static String inputs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        inputs = br.readLine();
        int len = inputs.length();
        int startI = 0;
        if(len % 3 == 1){
            cal(0, 1);
         startI += 1;   
        }
        else if(len % 3 == 2){
            cal(0, 2);
         startI += 2;   
        }
        for(int i = startI; i < len-1; i += 3)
            cal(i, 3);
        bw.write(answer.toString());
        bw.close();
    }
    static void cal(int i, int len){
        int tempsum = 0;
            for(int j = 0; j < len; j++)
                tempsum += (inputs.charAt(i+j) - '0')*pow[len-j-1];
        answer.append(tempsum);
    }
}
