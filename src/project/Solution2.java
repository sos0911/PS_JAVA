package project;
import java.util.*;
import java.io.*;
class Solution2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Noftc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int k = 1; k <= Noftc; k++){
			st =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
       	boolean[] Isprime = new boolean[N+1]; // - 10000
			Arrays.fill(Isprime, true);
			// using eratenatos
			int stn = (int)Math.sqrt(N);
			for(int i = 2; i <= stn; i++){
				if(Isprime[i])
				for(int j = 2*i; j <= N; j += i)
					Isprime[j] = false;
			}
			ArrayList<Integer> prime = new ArrayList<Integer>(); // prime
			int primelen = 0;
			for(int i = 1; i <= N; i++)
				if(Isprime[i]){
					prime.add(i);
					primelen++;
				}
			int L = Integer.parseInt(st.nextToken());
			int[] input = new int[L];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < L; i++)
				input[i] = Integer.parseInt(st.nextToken());
			// find remain using binarysearch
			boolean[] visited = new boolean[primelen]; // 0-
			ArrayList<Integer> answer = new ArrayList<Integer>();// prime used in encrypt
			int[][] answer2 = new int[L][2]; // save two prime for one L
			int temp;
			for(int i = 0; i < L; i++){
				for(int j = 0; j < primelen; j++)
					if(input[i]%prime.get(j) == 0 && (temp =  Collections.binarySearch(prime, input[i]/prime.get(j))) >= 0){
						if(!visited[j]){
							answer.add(prime.get(j));
								visited[j] = true;
						}
						if(!visited[temp]){
							answer.add(input[i]/prime.get(j));
							visited[temp] = true;
						}
						answer2[i][0] = prime.get(j);
						answer2[i][1] = input[i]/prime.get(j);
						break; // find ans
					}
			}
			Collections.sort(answer);
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < L-1; i++)
				for(int j = 0; j < 2; j++)
					if(answer2[i][j] == answer2[i+1][0] || answer2[i][j] == answer2[i+1][1]){
						sb.append((char)(Collections.binarySearch(answer, answer2[i][j^1]) + 'A'));
					break;	
					}
			if(answer2[L-1][0] == answer2[L-2][0] || answer2[L-1][0] == answer2[L-2][1]){
				sb.append((char)(Collections.binarySearch(answer, answer2[L-1][0]) + 'A'));
				sb.append((char)(Collections.binarySearch(answer, answer2[L-1][1]) + 'A'));
			}
			else{
				sb.append((char)(Collections.binarySearch(answer, answer2[L-1][1]) + 'A'));
				sb.append((char)(Collections.binarySearch(answer, answer2[L-1][0]) + 'A'));
			}
			bw.write("Case #" + k + ": " + sb.toString() + "\n");
		}
		bw.close();
	}
}
