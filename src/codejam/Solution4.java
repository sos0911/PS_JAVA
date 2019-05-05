package codejam;
import java.io.*;
import java.util.*;
public class Solution4 {
	static String[] input;
	static boolean[] visited;
	static int nofw;
	static HashSet<String> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// for tc1. for practice;
		int noftc=Integer.parseInt(br.readLine());
		for(int i=1;i<=noftc;i++){
			list=new HashSet<>();
			nofw=Integer.parseInt(br.readLine());
			input=new String[nofw+1]; // 1-
			visited=new boolean[nofw+1];
			for(int j=1;j<=nofw;j++)
				input[j]=br.readLine();
			System.out.println("Case #"+i+": "+dfs(1));
		}
	}
	static int dfs(int curindex){
		// return maxv in pairs
		// need to find pair of input[curindex]
		if(curindex==nofw+1)
			return 0;
		int ans=0; // maxv
		if(visited[curindex])
			ans=Math.max(ans, dfs(curindex+1));
		else{
			int len=input[curindex].length();
			for(int i=0;i<len;i++){
				String temp=input[curindex].substring(i, len);
				if(list.contains(temp)) // suffix already used in other pair
					continue;
				for(int j=curindex+1;j<=nofw;j++)
					if(!visited[j] && input[j].endsWith(temp)){
						visited[curindex]=true;
						visited[j]=true;
						list.add(temp);
						ans=Math.max(ans, 2+dfs(curindex+1));
						visited[curindex]=false;
						visited[j]=false;
						list.remove(temp);
					}
			}
		}
		return ans;
	}
}
