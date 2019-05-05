package alg_04_2019;
import java.io.*;
import java.util.*;
class Info1377{
	int ind, val;
	public Info1377(int ind, int val){
		this.ind = ind;
		this.val = val;
	}
}
public class Alg1377 {
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Info1377[] input = new Info1377[N]; // 0-
		for(int i=0;i<N;i++)
			input[i] = new Info1377(i+1, Integer.parseInt(br.readLine()));
		Arrays.sort(input, (i1, i2) -> Integer.compare(i1.val, i2.val));
		int ans = 1;
		for(int i=0;i<N;i++)
			ans = Math.max(ans, input[i].ind-i);
		System.out.println(ans);
	}
}
