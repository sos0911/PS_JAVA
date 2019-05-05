package alg_04_2019;
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
			// 꼼수를 써봅시다.
			int rep = f%c != 0? (f/c+1)*p : (f/c)*p;
			 int one = rep/p+(rep/p)*c/f, temp; // 첫번째 사람이 먹는 치킨수
			 bw.write("rep : " + rep+"\n");
			  int two = rep/p, leftc = (rep/p)*c;
			  while(leftc >= f){
				 temp = leftc/f;
				two += temp;
				leftc %= f;
				leftc += temp*c;
			 }
			 int ans = (m/p)*c;
			 if(m-rep >= 0)
				 ans += (two-one)*((m-rep)/p) + (m-rep+1)/(f-c);
			 bw.write("two-one : " + (two-one) + " remain : " + ((m-rep)/p)+"\n"+ " add : " + (m-rep+1)/(f-c)+"\n");
			 bw.write("newA : " + ans+"\n");
			 // TLE
			 one = m/p+(m/p)*c/f; 
			 two = m/p; int leftc2 = (m/p)*c;
			 while(leftc2 >= f){
				 temp = leftc2/f;
				two += temp;
				leftc2 %= f;
				leftc2 += temp*c;
			 }
			 bw.write("TLEA : " + (two-one)+"\n");
		 }
		 bw.close();
	 }
}
/*
1 1000000 1000 999
*/