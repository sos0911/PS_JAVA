package project;
import java.util.*;
import java.io.*;
class Solution3{
    public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Noftc = Integer.parseInt(br.readLine());
		for(int l = 1; l <= Noftc; l++){
		int N = Integer.parseInt(br.readLine());
			String[] input = new String[N];
			boolean[] check = new boolean[N]; // 이미 pair로 묶여짐?
			for(int i=0;i<N;i++)
				input[i] = new StringBuilder(br.readLine()).reverse().toString();
			Arrays.sort(input);
			int ans = 0;
			for(int i = 0; i < N; i++){
				if(check[i])
					continue;
				int ilen = input[i].length();
				for(int j = i+1; j < N; j++){
					int minl = Math.min(ilen, input[j].length());
					for(int k=1;k<=minl;k++)
						if(input[i].substring(0, k).equals(input[j].substring(0, k))){
							check[i] = true; check[j] = true;
							ans += 2;
							break;
						}
				}
					
			}
		}
	}
}
