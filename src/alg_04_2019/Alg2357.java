package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg2357 {
	static int[] maxtree, mintree, input;
	static int N, M;
	static final int maxv = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 최소값 트리, 최대값 트리
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int temp = N;
		while((temp & temp-1) !=0) // 2의 배수 전까지
			temp -= (temp&-temp);
		maxtree=new int[temp*4];
		mintree=new int[temp*4];
		input=new int[N+1]; //1-
		for(int i=1;i<=N;i++)
			input[i] = Integer.parseInt(br.readLine());
		maxinit(1, 1, N);
		mininit(1, 1, N);
		for(int i=1;i<=M;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(minquery(a, b, 1, 1, N) + " " + maxquery(a, b, 1, 1, N) + "\n");
		}
		bw.close();
	}
	static int maxinit(int node, int nleft, int nright){
		if(nleft == nright)
			return maxtree[node] = input[nleft];
		int mid = (nleft+nright)/2;
		int hl = maxinit(node*2, nleft, mid);
		int hr = maxinit(node*2+1, mid+1, nright);
		return maxtree[node] = Math.max(hl, hr);
	}
	static int mininit(int node, int nleft, int nright){
		if(nleft == nright)
			return mintree[node] = input[nleft];
		int mid = (nleft+nright)/2;
		int hl = mininit(node*2, nleft, mid);
		int hr = mininit(node*2+1, mid+1, nright);
		return mintree[node] = Math.min(hl, hr);
	}
	static int maxquery(int left, int right, int node, int nleft, int nright){
		if(right < nleft || nright < left)
			return -maxv;
		if(left <= nleft && nright <= right)
			return maxtree[node];
		int mid = (nleft+nright)/2;
		return Math.max(maxquery(left, right, node*2, nleft, mid), maxquery(left, right, node*2+1, mid+1, nright));
	}
	static int minquery(int left, int right, int node, int nleft, int nright){
		if(right < nleft || nright < left)
			return maxv;
		if(left <= nleft && nright <= right)
			return mintree[node];
		int mid = (nleft+nright)/2;
		return Math.min(minquery(left, right, node*2, nleft, mid), minquery(left, right, node*2+1, mid+1, nright));
	}
}
