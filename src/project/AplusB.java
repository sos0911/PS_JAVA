package project;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AplusB {
    
    public static void main(String[] args) throws IOException{
        
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int NofTC = Integer.parseInt(br.readLine());
        for(int i = 1; i < NofTC+1; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
     bw.write("Case #" + i + ": " + a + " + " + b + " = " + (a + b) + "\n");
        }
        bw.close();
    }
}
