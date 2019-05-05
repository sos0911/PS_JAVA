package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg3653 {
	static int N, M;
	static int[] tree=new int[200002]; // n+M+1
	static int[] pos=new int[100001]; // 각 영화의 현재 높이를 저장
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Noftc = Integer.parseInt(br.readLine());
		StringTokenizer st; int temp;
		for(int i=0;i<Noftc;i++){
			st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			for(int j=1;j<=N;j++){
				pos[j] = N-j+1; // 1층부터 시작해야 함(팬윅이 1~)
				update(j, 1); 	
			}
			st = new StringTokenizer(br.readLine());
			int top = N; // 현재 책이 있는 최고 위치
			for(int j=1;j<=M;j++){
				temp = Integer.parseInt(st.nextToken());
				bw.write(query(pos[temp]+1) + " ");
				update(pos[temp], 0); // 해당 위치 책 없앰
				pos[temp] = (top++)+1; // 여기가 문제구만
				update(pos[temp], 1); // 해당 위치 책++
			}
			bw.newLine();
			Arrays.fill(tree, 0); // 이거 필요없잖아?
		}
		bw.close();
	}
	// tree의 용량은 N+M
	static int query(int i){
		int ans = 0;
		while(i <= N+M){
			ans += tree[i];
			i += (i&-i);
		}
		return ans;
	}
	static void update(int i, int check){
		if(check == 0)
		while(i > 0){
			tree[i]--;
			i -= (i&-i);
		}
		else
			while(i > 0){
			tree[i]++;
			i -= (i&-i);
			}
	}
}
