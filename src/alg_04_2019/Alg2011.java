package alg_04_2019;
import java.io.*;
import java.util.*;

public class Alg2011 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		input = '0' + input; // input[1]에서 시작하게끔
		int len = input.length();
		final int mod = 1000000;
		int[] dp = new int[len]; // input[1]부터 시작, 1 - N
		// dp[i] = input[i]까지 봤을 때 최대 가짓수
		dp[0] = 1; // 편의
		dp[1] = input.charAt(1) == '0'? 0 : 1; // 1자리 
		for(int i = 2; i <= len-1; i++){
			if(input.charAt(i) == '0'){
				if(input.charAt(i-1) < '1' || input.charAt(i-1) > '2'){
					System.out.println("0");
					return;
				}
				else // 이 경우는 앞 암호와 0이 종속적 / (10, 20)
					dp[i] += dp[i-2];
			}
			else{ // 현재 자리가 0이 아님
				dp[i] += dp[i-1];
				if(input.charAt(i-1) != '0'){
				int judge = (input.charAt(i-1) - '0')*10 + (input.charAt(i) - '0');
				if(judge >= 10 && judge <= 26)
					dp[i] += dp[i-2];
				}
			}
			dp[i] %= mod;
		}
		System.out.println(dp[len-1]);
	}
}