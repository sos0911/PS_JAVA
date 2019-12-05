package alg_05_2019;
import java.io.*;
import java.util.*;
public class Alg16986 {
	static int[][] anti; // 상성표
	static int nofs, maxw; // 손동작수, 승수
	static int[][] future=new int[2][20];// 손동작 순서
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		nofs=Integer.parseInt(st.nextToken());
		maxw=Integer.parseInt(st.nextToken());
		anti=new int[nofs+1][nofs+1]; // 1-
		visited=new boolean[nofs+1]; // 1-
		for(int i=1;i<=nofs;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=nofs;j++)
				anti[i][j]=Integer.parseInt(st.nextToken());
		}
		for(int j=0;j<2;j++){
			st=new StringTokenizer(br.readLine());
		for(int i=0;i<20;i++)
			future[j][i]=Integer.parseInt(st.nextToken());
		}
		if(dfs(0, 0, 0, 0, 0, 1))
			System.out.println(1);
		else
			System.out.println(0);
	}
	static boolean dfs(int j, int g, int m, int gi, int mi, int fight){
		// 지금까지 이긴 승수들이 pm, i붙은건 지금 사용할 친구들 index
		// 이길 수 있는지 찾아봄
		// 무조건 지우가 누군가와 붙는 경우만 따짐
		// 지경/경민/민지(123)
		if(j==maxw)
			return true;
		if(g==maxw||m==maxw)
			return false;
		
			if(fight==1){ // 지경
				for(int i=1;i<=nofs;i++)
					if(!visited[i]){
						visited[i]=true;
			if(anti[i][future[0][gi]]>1){
				if(dfs(j+1,g,m,gi+1,mi,3))
					return true;
			}
			else{
				if(dfs(j,g+1,m,gi+1,mi,2))
					return true;
			}
					visited[i]=false;
				}
		}
			else if(fight==2){ // 경민
			if(anti[future[0][gi]][future[1][mi]]>1){
				if(dfs(j,g+1,m,gi+1,mi+1,1))
					return true;
			}
			else{
				if(dfs(j,g,m+1,gi+1,mi+1,3))
					return true;
			}
		}
		else{ // 민지
			for(int i=1;i<=nofs;i++)
				if(!visited[i]){
						visited[i]=true;
			if(anti[future[1][gi]][i]>1){
				if(dfs(j,g,m+1,gi,mi+1,2))
					return true;
			}
			else{
				if(dfs(j+1,g,m,gi,mi+1,1))
					return true;
			}
						visited[i]=false;
				}
		}
		return false; // 못찾음
	}
}
