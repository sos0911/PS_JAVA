package alg_04_2019;
import java.io.*;
import java.util.*;

public class Alg10797 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i = 0; i < 5; i++)
			if(N == Integer.parseInt(st.nextToken()))
				ans++;
		System.out.println(ans);
	}
}
