package codejam;
import java.io.*;
import java.util.*;
public class Solution6IO {
	static String[] perm=new String[121];
	static StringBuilder cur=new StringBuilder(); // used in generating comb
	static boolean[] dfsvisit=new boolean[5]; // used in dfs
	static int index=1;
	 public static void main(String[] args) throws IOException{
			 PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("IO.txt"))));
		 dfs(0);
		 // gernerate comb
		 pw.println(1 +" "+ 1);
		 int stn=5*4*3*2*1;
		 for(int k=0;k<4;k++){
		 for(int i=2;i<=stn;i++) // 0-119
			pw.println(perm[i].charAt(k));
			stn/=(5-k);	 
		 }
		 pw.close();
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
