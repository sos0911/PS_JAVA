package SecondTry;
import java.io.*;
import java.util.*;
public class Alg13199 {
	
	 public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int noftc = Integer.parseInt(br.readLine());
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 StringTokenizer st;
		 for(int i=0;i<noftc;i++){
			 st = new StringTokenizer(br.readLine());
			 int p = Integer.parseInt(st.nextToken());
			 int m = Integer.parseInt(st.nextToken());
			 int f = Integer.parseInt(st.nextToken());
			 int c = Integer.parseInt(st.nextToken());
			 int one = m/p+(m/p)*c/f, temp; // 첫번째 사람이 먹는 치킨수
			 int two = m/p, leftc = (m/p)*c;
			 int loopn = 0;
			 while(leftc >= f){
				 temp = leftc/f;
				two += temp;
				leftc %= f;
				leftc += temp*c;
				 loopn++;
			 }
			 bw.write("loopn : " + loopn +"\n");
			 bw.write((two-one)+"\n");
		 }
		 bw.close();
	 }
}
