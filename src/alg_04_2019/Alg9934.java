package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg9934{
	static ArrayList<ArrayList<Integer>> ans;
	static int[] input;
	public static void main(String[] args) throws IOException{
		// trie 기초문제
	// 모든 빌딩의 번호는 1-2^k이다.
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	int k=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		input=new int[1<<k]; // 노드의 수는 1<<k -1
		ans=new ArrayList<ArrayList<Integer>>(k+1); // 1-
		ans.add(new ArrayList<Integer>()); // 0
		for(int i=1;i<=k;i++)
			ans.add(new ArrayList<Integer>(1<<(i-1))); // 0-
		// k+1번 생성
		for(int i=1;i<(1<<k);i++)
			input[i]=Integer.parseInt(st.nextToken());
		find(1, (1<<k)-1, 1);
		for(int i=1;i<=k;i++){
			for(int j : ans.get(i))
				bw.write(j + " ");
		bw.newLine();	
		}
		bw.close();
	}
	static void find(int lo, int hi, int level){
		ans.get(level).add(input[(lo+hi)/2]);
		if(lo!=hi){
		find(lo, (lo+hi)/2-1, level+1);
		find((lo+hi)/2+1, hi, level+1);
		}
	}
}
