package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg1275 {
	static long[] tree;
	static int[] input;
	static int N, Q;
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		tree=new long[N+1]; // 1-
		input=new int[N+1]; // 1- for update...
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			input[i] = Integer.parseInt(st.nextToken());
			update(i, input[i]);
		}
		for(int i=1;i<=Q;i++){
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			bw.write(x>y? query(x)-query(y-1) + "\n" :query(y)-query(x-1) + "\n");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); // 오버플로우 날걸? ㅎㅎ
			// 형변환을 주의하자!! int, int형끼리 계산한걸 long형에 담는다 해도
			// 오버플로우된 값이 long형에 저장되어서 적어도 한 개를 long형으로 담은 후
			// 연산해야 한다.
			 bw.write("test : " + (b-input[a]) + "\n");
			update(a, b-input[a]);
			input[a] = (int)b;
		}
		bw.close();
	}
	static void update(int i, long val){
		while(i <= N){
			tree[i] += val;
			i += (i&-i);
		}
	}
	static long query(int i){
		long ans = 0;
		while(i > 0){
			ans += tree[i];
			i -= (i&-i);
		}
		return ans;
	}
}
