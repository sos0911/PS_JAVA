package alg_02_2019;
import java.io.*;
public class Alg1547 {
    
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ball = 1;
        int Nofrot = Integer.parseInt(br.readLine());
        String[] temp; int a, b;
        for(int i = 0; i < Nofrot; i++){
        temp = br.readLine().split(" ");
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);
            if(ball == a)
                ball = b;
            else if(ball == b)
                ball = a;
        }
        System.out.println(ball);
    }
}
