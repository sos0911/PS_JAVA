package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg1789 {
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String maxs = "4294967295";
		long max = Long.parseLong(maxs);
		while(true){
		long S = (long)(Math.random()*max)+1;
		long n1 = (long)Math.sqrt(2*S); long temp;
			long inin1 = n1;
		while(S-(temp = n1*(n1+1))/2 <= n1)
			n1--;
		int n2 = (int)Math.sqrt(2*S);
			int inin2 = n2;
			// 주의 :: int*int일때 결과가 int형을 넘는 결과이면 오버플로우가 일어납니다.
			// 자료형 하나 이상을 long에 박아주세요..
		while(S-(temp = n2*(n2+1))/2 <= n2)
			n2--;
		if(n1 != n2){
			System.out.println("dif detected :: n1 : " + n1 + " n2 : " + n2);
			System.out.println("inin1 : " + inin1 + " inin2 : " + inin2);
			break;
		}
		}
	}
}
