package alg_04_2019;
import java.io.*;
import java.util.*;

public class Alg7578 {
	static int N;
	static int[] Ainput;
	static int[] tree; // 펜윅, root가 n인 트리
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Ainput = new int[1000001];
		tree=new int[N+1]; // 1-
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
			Ainput[Integer.parseInt(st.nextToken())] = i;
		st = new StringTokenizer(br.readLine()); int temp, temp2;
		long ans = 0;
		for(int i=1;i<=N;i++){
			temp = Integer.parseInt(st.nextToken());
			temp2 = Ainput[temp];
			ans += query(temp2+1); // 자신보다 큰 index가 나온 횟수를 찾음
			update(temp2); // 이 index가 나왔다는 표시
		}
		System.out.println(ans);
	}
	static long query(int i){
		long qans = 0;
		while(i <= N){
			qans += tree[i];
			i += (i&-i);
		}
		return qans;
	}
	static void update(int i){
		while(i > 0){
			tree[i]++;
			i -= (i&-i);
		}
	}
}
