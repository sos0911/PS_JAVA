package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg11505 {
	static long[] tree; // segment tree
	static int[] input;
	static int N, M, K;
	static final int mod=1000000007;
	  public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		  StringTokenizer st=new StringTokenizer(br.readLine());
		  N=Integer.parseInt(st.nextToken());
		  M=Integer.parseInt(st.nextToken());
		  K=Integer.parseInt(st.nextToken());
		  int temp = N;
		  while((temp&(temp-1))!=0)
			  temp += (temp&-temp);
		  tree=new long[temp*2];
		  input=new int[N]; // 0-
		  for(int i=0;i<N;i++)
			  input[i]=Integer.parseInt(br.readLine());
			init(1, 0, N-1);
		  for(int i=1;i<=M+K;i++){
			  st=new StringTokenizer(br.readLine());
			  int mode=Integer.parseInt(st.nextToken());
			  if(mode==1){
				int tar=Integer.parseInt(st.nextToken());
				int val=Integer.parseInt(st.nextToken());
				  update(tar-1, 0, N-1, 1, val-input[tar-1]);
				  input[tar-1] = val;
			  }
			  else
				  bw.write(query(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 1, 0, N-1)+"\n");
		  }
		  bw.close();
	  }
	static long init(int node, int nleft, int nright){
		if(nleft == nright)
			return tree[node] = input[nleft];
		int mid=(nleft+nright)/2;
		return tree[node] = (init(node*2, nleft, mid)*init(node*2+1, mid+1, nright))%mod;
	}
	static long update(int i, int left, int right, int node, int diff){ // 수정필요
		// 0으로 update될 때도 생각.
		if(i < left || i > right)
			return tree[node];
		if(left == right)
			return tree[node] += diff;
		else{
			int mid =(left+right)/2;
			return tree[node] = (update(i, left, mid, node*2, diff)*update(i, mid+1, right, node*2+1, diff))%mod;
		}
	}
	static long query(int left, int right, int node, int nleft, int nright){
		if(left <= nleft && nright <= right)
			return tree[node];
		if(left > nright || right < nleft)
			return 1;
		int mid =(nleft+nright)/2;
		return (query(left, right, node*2, nleft, mid)*query(left, right, node*2+1, mid+1, nright))%mod;
	}
}
