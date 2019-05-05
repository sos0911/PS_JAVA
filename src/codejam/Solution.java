package codejam;
import java.io.*;
import java.util.*;
public class Solution {
	static int[] atree, btree;
	static int[] ainput, binput; // has maxV in each section
	static int[] emerge=new int[100001];
	static int min=Integer.MIN_VALUE;
	// tc: noftc*(4n+n*4logn*logn) = 8*(400000+400000*400)
	 public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 int noftc=Integer.parseInt(br.readLine());
		 StringTokenizer st;
		 for(int i=1;i<=noftc;i++){
			 st=new StringTokenizer(br.readLine());
			 int n=Integer.parseInt(st.nextToken());
			 int k=Integer.parseInt(st.nextToken());
			 ainput=new int[n+1]; // 1-
			 binput=new int[n+1]; //1-
			 int temp=n;
			 while((temp&(temp-1))!=0)
				 temp+=(temp&-temp);
			 atree=new int[temp*2];
			 btree=new int[temp*2];
			  st=new StringTokenizer(br.readLine());
			 for(int j=1;j<=n;j++)
				 ainput[j]=Integer.parseInt(st.nextToken());
			 init(1, 1, n, atree, ainput); // init
			   st=new StringTokenizer(br.readLine());
			  for(int j=1;j<=n;j++)
				 binput[j]=Integer.parseInt(st.nextToken());
			 init(1, 1, n, btree, binput);
			 int ans=0;
			 // find Li for p1 ans p2
			 for(int j=1;j<=n;j++){
				 int lia,ria,lib,rib; // 4 binsearch
				 int lo,hi,mid;
			 	lo=emerge[ainput[j]]+1;hi=j;
				 while(lo<=hi){
					 mid=(lo+hi)/2;
					 int a=query(mid,j,1,n,1,atree);
					 int b=query(mid,j,1,n,1,btree);
					 if(a==ainput[j] && b<=ainput[j]+k)
						 // move left
						 hi=mid-1;
					 else
						 lo=mid+1;
				 }
				 lia=lo;
				lo=j;hi=n;
				 while(lo<=hi){
					 mid=(lo+hi)/2;
					 int a=query(j,mid,1,n,1,atree);
					 int b=query(j,mid,1,n,1,btree);
					 if(a==ainput[j] && b<=ainput[j]+k)
						 // move right
						 lo=mid+1;
					 else
						 hi=mid-1;
				 }
				 ria=hi;
				  // find lib,rib for p1, p3
				 lo=emerge[ainput[j]]+1;hi=j;
				 while(lo<=hi){
					 mid=(lo+hi)/2;
					 int a=query(mid,j,1,n,1,atree);
					 int b=query(mid,j,1,n,1,btree);
					 if(a==ainput[j] && b<ainput[j]-k)
						 // move left
						 hi=mid-1;
					 else
						 lo=mid+1;
				 }
				 lib=lo;
				lo=j;hi=n;
				 while(lo<=hi){
					 mid=(lo+hi)/2;
					  int a=query(j,mid,1,n,1,atree);
					 int b=query(j,mid,1,n,1,btree);
					 if(a==ainput[j] && b<ainput[j]-k)
						 // move right
						 lo=mid+1;
					 else
						 hi=mid-1;
				 }
				 rib=hi;
				 //bw.write("lia : "+lia+" ria : "+ria+" lib : "+lib+" rib : " + rib+"\n");
				 ans+=(j-lia+1)*(ria-j+1)-(j-lib+1)*(rib-j+1);
				 //bw.write("cur ans : " + ans+"\n");
				 emerge[ainput[j]]=j; // write last index that value emerge in A
			 }
			 bw.write("Case #"+i+": "+ans+"\n");
			 Arrays.fill(emerge, 0); // reinitiate
		 }
				 bw.close();
	 }
	static int init(int node, int nleft, int nright, int[] tree, int[] input){
		if(nleft==nright)
			return tree[node]=input[nleft];
		int mid=(nleft+nright)/2;
		return tree[node]=Math.max(init(node*2, nleft, mid, tree, input), init(node*2+1, mid+1, nright, tree, input));
	}
	static int query(int left, int right, int nleft, int nright, int node, int[] tree){
		// return maxv in section
		if(right<nleft || nright<left)
			return min;
		if(left<=nleft && nright<=right)
			return tree[node];
		int mid=(nleft+nright)/2;
		return Math.max(query(left, right, nleft, mid, node*2, tree), query(left, right, mid+1, nright, node*2+1, tree));
	}
}
