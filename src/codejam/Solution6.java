package codejam;
import java.io.*;
import java.util.*;
public class Solution6 {
	static String[] perm;
	static boolean[] Isthere;
	static StringBuilder cur;
	static boolean[] dfsvisit;
	static int index;
	 public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer sti=new StringTokenizer(br.readLine());
		 int t=Integer.parseInt(sti.nextToken());
		 int f=Integer.parseInt(sti.nextToken());
		 for(int i=1;i<=t;i++){
			 perm=new String[120]; //0-
			 Isthere=new boolean[120]; //0-
			 cur=new StringBuilder();
			 dfsvisit=new boolean[5];
			 index=0;
			 dfs(0); // generate perm
			 //for(int j=0;j<120;j++)
				// System.out.println(perm[j]);
			 for(int j=1;j<2;j++){ // 119
				 boolean[] visited=new boolean[5];
				 StringBuilder sb=new StringBuilder();
				 for(int k=1;k<5;k++){
					System.out.println(5*(j-1)+k);
				char input=br.readLine().charAt(0);
					 visited[input-'A']=true;
					 sb.append(input);
				 }
				 for(int k=0;k<5;k++)
					 if(!visited[k])
						 sb.append((char)(k+'A'));
				 for(int k=0;k<120;k++)
					 if(sb.toString().equals(perm[k]))
						 Isthere[k]=true;
			 }
			 // two remains
			 int idx1=-1, idx2=-1;
			 for(int k=0;k<120;k++)
				 if(!Isthere[k]){
					 if(idx1==-1)
						 idx1=k;
			 		else
						idx2=k;
				 }
			int diff=Math.abs(idx1-idx2); int q=-1, st=-1;
			 if(diff<=6){
				 q=593;
				 st=2;
			 }
			 else if(diff<=24){
				 q=592;
				st=1;	 
			 }
			 else{
				 q=591;
				st=0;	 
			 }
			 StringBuilder last=new StringBuilder();
			 for(int k=0;k<3;k++){
				 System.out.println(q+k);
				 last.append(br.readLine().charAt(0));
			 }
			 if(perm[idx1].substring(st, st+3).equals(last.toString()))
				 System.out.println(perm[idx2]);
			 else
				 System.out.println(perm[idx1]);
		 }
	 }
	static void dfs(int cnt){
		if(cnt==5){
			perm[index++]=cur.toString();
			return;
		}
		for(int i=0;i<5;i++)
			if(!dfsvisit[i]){
				dfsvisit[i]=true;
				cur.append((char)(i+'A'));
				dfs(cnt+1);
				cur.deleteCharAt(cur.length()-1);
				dfsvisit[i]=false;
			}
	}
}
