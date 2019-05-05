package alg_02_2019;
import java.io.*;
public class Alg10253 {
    
    public static void main(String[] args) throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Noftc = Integer.parseInt(br.readLine());
        int a, b, c; String[] temp;
        for(int i = 0; i < Noftc; i++){
        temp = br.readLine().split(" ");
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);
            while(a != 1){
                c = b/a + 1;
                a = a*c - b;
                b *= c;
                for(int j = a; j >= 2; j--)
                    if(a % j == 0 && b % j == 0){
                        a /= j; 
                        b /= j;
                    }
            }
            bw.write(b + "\n");
        }
        bw.close();
    }
}
