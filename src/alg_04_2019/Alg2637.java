package alg_04_2019;
import java.io.*;
import java.util.*;
class Info2637{
	int num, cnt;
	public Info2637(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}
public class Alg2637 {
	static ArrayList<ArrayList<Info2637>> list;
	static int[] ans;
	static int N, M;
	public static void main(String[] args) throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<ArrayList<Info2637>>(); // 각 부품 넘버에 대한 리스트
		for(int i = 0; i <= N; i++)
			list.add(new ArrayList<Info2637>());
		StringTokenizer st;
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Info2637(b, c));
		}
		ans = new int[N+1]; // 1 -
		// 재귀로 돌리자.
		Findcnt(N, 1);
		for(int i = 1; i <= N; i++)
			if(ans[i] != 0)
				bw.write(i + " " + ans[i] + "\n");
		bw.close();
	}
	static void Findcnt(int tar, int stnum){ // tar번 부품에서 재귀로 찾음
		if(list.get(tar).isEmpty()) // 요게 기본 부품임
			ans[tar] += stnum;
		else
			for(Info2637 temp : list.get(tar))
				Findcnt(temp.num, stnum*temp.cnt);
	}
}
