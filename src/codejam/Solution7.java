package codejam;
import java.io.*;
import java.util.*;
public class Solution7 {
	 public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer sti=new StringTokenizer(br.readLine());
		 int noft=Integer.parseInt(sti.nextToken());
		  int f=Integer.parseInt(sti.nextToken());
		 for(int i=1;i<=noft;i++){
			 LinkedList<Integer> list=new LinkedList<Integer>();
			 StringBuilder ans=new StringBuilder();
			boolean[] visited=new boolean[5];
				 int stn=4*3*2*1;
			 for(int j=1;j<120;j++)
				 list.add(j); // insert candidate
			 for(int j=1;j<5;j++){
				 int[] cnt=new int[5]; // A-E
				 char[] st=new char[120]; // 1-119
				 for(int k : list){
					 System.out.println(5*(k-1)+j);
					 st[k]=br.readLine().charAt(0); // write C of the index 
					 cnt[st[k]-'A']++; // count what C appeared
				 }
				  char ansC;
				 for(int k=0;k<5;k++)
					 if(!visited[k] && cnt[k]!=stn){
						 ans.append((char)(k+'A')); // answer C found
						ansC=(char)(k+'A');
						 visited[k]=true;
					 }
					//list.removeIf(mem -> st[mem]!=ansC);
				 stn/=(5-j);
			 }
			for(int j=0;j<5;j++)
				if(!visited[j])
					ans.append((char)(j+'A'));
			 System.out.println(ans.toString());
			 if(br.readLine().charAt(0)=='N') // error
				 return;
		 }
	 }
}
