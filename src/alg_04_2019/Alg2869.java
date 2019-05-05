package alg_04_2019;
import java.io.*;
import java.util.*;

public class Alg2869 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int ans = (V-B)%(A-B) == 0? (V-B)/(A-B) : (V-B)/(A-B)+1;
		System.out.println(ans);
	}
}
