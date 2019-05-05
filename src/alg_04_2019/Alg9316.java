package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg9316 {
	 public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		 int N=Integer.parseInt(br.readLine());
		 for(int i=1;i<=N;i++)
			 bw.write("Hello World, Judge "+i+"!\n");
		 bw.close();	 
	 }
}
