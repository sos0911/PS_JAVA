package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg2091 {
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] dp = new int[10001][4]; // x원을 이루는 최대 동전 수를 저장
		int[] way = {1, 5, 10 ,25};
		int[] input = new int[4];
		for(int[] arr : dp)
			Arrays.fill(arr, -1);
		for(int i=0;i<4;i++)
			dp[0][i] = 0;
		int x = Integer.parseInt(st.nextToken());
		for(int i=0;i<4;i++)
			input[i] = Integer.parseInt(st.nextToken());
		int temp, sum, sum2;
		for(int i=1;i<=x;i++){
			for(int k=0;k<4;k++){
				if((temp = i-way[k]) < 0)
					continue;
			sum = dp[temp][0]+dp[temp][1]+dp[temp][2]+dp[temp][3];
			sum2 = dp[i][0]+dp[i][1]+dp[i][2]+dp[i][3];
			if(dp[temp][k] < input[k] && sum != -4 && sum+1 > sum2) // 만들기 가능,참조자가 유효할때, 동전 수가 더 많을 때
				for(int j=0;j<4;j++){
					if(j != k)
					dp[i][j] = dp[temp][j];
					else
					dp[i][j] = dp[temp][j]+1;
				}
			}
		}
		/*
		for(int i=0;i<=x;i++){
			System.out.print("dp :: " + i + " :: ");
			for(int j : dp[i])
				System.out.print(j + " ");
		System.out.println("");	
		}
		*/
		if(dp[x][0] != -1)
		System.out.println(dp[x][0] + " " + dp[x][1] + " " + dp[x][2] + " " + dp[x][3]);
		else
			System.out.println("0 0 0 0");
	}
}
/*
50 3 2 1 2
*/