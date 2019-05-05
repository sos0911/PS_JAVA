package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg10990 {
	 public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 int N=  Integer.parseInt(br.readLine());
		 for(int i=0;i<N;i++){
			 for(int j=0;j<N-i-1;j++)
				 bw.write(" ");
			 bw.write("*");
			 for(int j=0;j<2*i-1;j++)
				 bw.write(" ");
			 if(i != 0)
			 bw.write("*");
			 bw.newLine();
		 }
		 bw.close();
	 }
}
