package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg7469 {
	// ***** segment tree
	static ArrayList<ArrayList<Integer>> tree;
	// 각 노드마다 그 구간을 정렬한 결과를 저장(using mergeS)
	static int[] input;
	static int n, m;
	static ArrayList<Integer> tar;
	 public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		 StringTokenizer st=new StringTokenizer(br.readLine());
		 n=Integer.parseInt(st.nextToken());
		 m=Integer.parseInt(st.nextToken());
		 input=new int[n+1]; // 1-
		 int temp=n;
		 while((temp&(temp-1))!=0)
			 temp += (temp&(-temp));
		 tree=new ArrayList<ArrayList<Integer>>(temp*2);
		 for(int i=0;i<temp*2;i++)
			 tree.add(new ArrayList<Integer>());
		 st=new StringTokenizer(br.readLine());
		 for(int i=1;i<=n;i++)
			 input[i] = Integer.parseInt(st.nextToken());
		 init(1, n, 1);
		 // 전처리 완료
		 for(int z=0;z<m;z++){
			  st=new StringTokenizer(br.readLine());
			 int i=Integer.parseInt(st.nextToken());
			 int j=Integer.parseInt(st.nextToken());
			 int k=Integer.parseInt(st.nextToken());
			 tar=new ArrayList<Integer>();
				 query(i, j, 1, n, 1); 
			 // 구간 내 정렬된 부분 배열들의 index를 가져옴
			/* System.out.println("tar :: ");
			 for(int p : tar)
				 System.out.print(p + " ");
			System.out.println("");
			 for(int p : tar){
				 System.out.println("tree : " + p);
				 for(int p2 : tree.get(p))
					 System.out.print(p2 + " ");
			 System.out.println("");
			 } */
			 int lo=0, hi=n-1;
			 while(lo<=hi){
				 int mid=(lo+hi)/2;
				 int val=count(tar,tree.get(1).get(mid), k-1);
				// System.out.println("mid : " + mid + " val : " + val);
				 // 어차피 tree[1]에는 모든 수들이 오름차순으로 정렬되었다.
				 // 이 식이 아니라면 lower, upper 사용하여 특정
				 // mid보다 작은 값의 개수를 셈
				 if(val==k-1){
					 bw.write(tree.get(1).get(mid)+"\n");
					 break;
				 }
				 else if(val>k-1)
					 hi=mid-1;
				 else
					 lo=mid+1;
				// System.out.println("lo : " + lo + " hi : " + hi);
			 }
		 }
		 bw.close();
	 }
	static int count(ArrayList<Integer> tar, int mid, int stn){
		// tar 내 포함된 tree[index] 에서 mid보다 작은 수의 개수를 반환
		int ans = 0; boolean check = false;
		for(int ind : tar){
			int temp=Collections.binarySearch(tree.get(ind), mid);
			// 수가 이 구간 내에 있다 = bins가 적어도 한번은 0 이상 리턴
			if(temp>=0){
				ans+=temp;
			if(!check)	
				check = true;
			}
			else
				ans+=-(temp+1);
			//System.out.println("ans : " + ans);
		}
		if(ans == stn && !check) // 수를 늘려야 함
			return -1;
		else
			return ans;
	}
	static void query(int left, int right, int nleft, int nright, int node){
		// 해당 구간의 수를 저장한 tree의 index를 추출
		if(left <= nleft && nright <= right){
			tar.add(node);
			return;
		}
		if(right < nleft || nright < left)
			return;
		query(left, right, nleft, (nleft+nright)/2, node*2);
		query(left, right, (nleft+nright)/2+1, nright, node*2+1);
	}
	static void merges(int node, ArrayList<Integer> A, ArrayList<Integer> B){
		// tree[node]에 두 개를 합친다.
		int alen=A.size(), blen=B.size();
		int aind=0, bind=0;
		while(aind < alen && bind < blen)
			if(A.get(aind) > B.get(bind))
				tree.get(node).add(B.get(bind++));
		else
			tree.get(node).add(A.get(aind++));
		if(aind < alen) // 다 안씀
			while(aind<alen)
				tree.get(node).add(A.get(aind++));
		if(bind < blen) // 다 안씀
			while(bind<blen)
				tree.get(node).add(B.get(bind++));
	}
	static ArrayList<Integer> init(int nleft, int nright, int node){
		if(nleft == nright){
			tree.get(node).add(input[nleft]);
			return tree.get(node);
		}
			merges(node, init(nleft, (nleft+nright)/2, node*2), init((nleft+nright)/2+1, nright, node*2+1));
		return tree.get(node);
	}
}
/*
3 10
-129439731 -871827100 -64049111
2 2 1
1 2 2
2 3 1
1 1 1
1 3 3
2 3 2
1 2 1
3 3 1
1 3 1
1 3 2
*/