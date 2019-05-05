package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg8981 {
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			input[i] = Integer.parseInt(st.nextToken());
		int[] answer = new int[N];
		answer[0] = input[0];
		int nextI = (input[0])%N;
		if(answer[nextI] != 0)
				while(answer[nextI] != 0)
					nextI = (nextI+1)%N;
		for(int i=1;i<N;i++){
			answer[nextI] = input[i];
			nextI = (nextI+answer[nextI])%N;
			if(i == N-1)
				continue;
			if(answer[nextI] != 0)
				while(answer[nextI] != 0)
					nextI = (nextI+1)%N;
		}
		System.out.println(N);
		for(int i : answer)
			System.out.print(i + " ");
	}
}
/*
for(int j : answer) // check
			System.out.print(j + " ");
			System.out.println("");
			*/
/*
5
5 5 5 5 5
*/