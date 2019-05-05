package codejam;
import java.io.*;
import java.util.*;

public class Solution2{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int noftc=Integer.parseInt(br.readLine());
        for(int i=1;i<=noftc;i++){
            StringBuilder A=new StringBuilder();
             StringBuilder B=new StringBuilder();
             String N=br.readLine();
			if(N.charAt(0)-'0'==4){ // handle first digit
                 A.append(2);
                B.append(2);   
             }
             else{
                 A.append(0);
                 B.append(N.charAt(0)-'0');
             }
             for(int j=1;j<N.length();j++)
             if(N.charAt(j)-'0'==4){
                 A.append(2);
                B.append(2);   
             }
             else{
                 B.append(0);
                 A.append(N.charAt(j)-'0');
             }
             bw.write("Case #"+i+": "+A.toString().replaceAll("^0+","")+" "+B.toString().replaceAll("^0+","")+"\n");
        }
        bw.close();
    }
}