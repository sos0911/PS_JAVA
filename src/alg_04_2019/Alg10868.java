package alg_04_2019;
import java.io.*;
import java.util.*;
// 펜윅2개?
// https://tkql.tistory.com/69
// 뭐 어떻게 한건지.. 포기하고 세그로 풀어보자 ㅆㅂ.
public class Alg10868 {
	static int N, M;
	static int[] tree, input; // segment tree.
	static final int maxv = Integer.MAX_VALUE;
		public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st=new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M =  Integer.parseInt(st.nextToken());
			int temp = N;
			while((temp & temp-1) != 0)
				temp -= (temp&-temp);
			tree = new int[temp*4];
			input = new int[N]; //0-
			for(int i=0;i<N;i++) // 모두 입력받은 후에야 init 가능
				input[i] = Integer.parseInt(br.readLine());
			init(1, 0, N-1);
			for(int i=0;i<M;i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				bw.write(query(a-1, b-1, 1, 0, N-1)+"\n");
			}
			bw.close();
}
	static int init(int node, int nleft, int nright){ // initiate process
		if(nleft == nright) // leaf node
			return tree[node] = input[nleft];
		int mid = (nleft+nright)/2;
		int leftv = init(node*2, nleft, mid);
		int rightv = init(node*2+1, mid+1, nright);
		return tree[node] = Math.min(leftv, rightv);
	}
	static int query(int left, int right, int node, int nleft, int nright){
		// node는 input[nleft] - input[nright]까지 담당한다.
		if(left > nright || right < nleft) // 겹침x
			return maxv;
		if(left <= nleft && nright <= right)
			return tree[node];
		int mid = (nleft+nright)/2;
		return Math.min(query(left, right, node*2, nleft, mid), query(left, right, node*2+1, mid+1, nright));
	}
}
/*
 1 5 3 2 4
(1 2 3 4 5)


 4 2 3 5 1
(1 2 3 4 5)


3-5 구간에 대해 최소값을 알고 싶다면,

tree1[3](3) + tree2[2](5-4)
*/
