package alg_05_2019;
import java.io.*;
import java.util.*;
class cood{
	int z, y, x;
	public cood(int z, int y, int x){
		this.z=z;
		this.y=y;
		this.x=x;
	}
}
class Alg16985{
	static int[][][] map=new int[6][6][6]; // 탐색할 3차원 맵
	static int[][][] input=new int[6][6][6]; // input. begin from 1
	static boolean[] visited=new boolean[6]; // 1-
	static int ans=Integer.MAX_VALUE;
	static int[][] dir={{-1,0,0}, {1,0,0}, {0,1,0}, {0,-1,0}, {0,0,1},{0,0,-1}};
	// 방향
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=1;i<6;i++)
			for(int j=1;j<6;j++){
				st=new StringTokenizer(br.readLine());
			for(int k=1;k<6;k++)
			input[i][j][k]=Integer.parseInt(st.nextToken());
			}	
		combgen(0); // map에다가 조합 생성
		System.out.println(ans==Integer.MAX_VALUE? -1 : ans);
	}
	static void combgen(int cnt){ // cnt: 생성 완료된 판 개수
		if(cnt==5){
			System.out.println("Test:");
				for(int i=1;i<6;i++){
					for(int j=1;j<6;j++){
					for(int k=1;k<6;k++)
						System.out.print(map[i][j][k]+" ");
						System.out.println("");	
					}
					System.out.println("");	
				}
			if(map[1][1][1]!=0&&map[5][5][5]!=0)
				ans=Math.min(ans, bfs()); // 탐색 실행
			return;	
		}
		for(int i=1;i<6;i++)
			if(!visited[i]){
				visited[i]=true;
			int[][] temp=new int[6][6]; // temp
			for(int j=1;j<6;j++)
				System.arraycopy(input[cnt+1][j], 1, map[cnt+1][j], 1, 5); // 원본 복사
			for(int j=1;j<5;j++){
				combgen(cnt+1);
				for(int k=1;k<6;k++)
				for(int z=1;z<6;z++)
					temp[6-z][k]=map[cnt+1][k][z]; // 90도 회전
				for(int k=1;k<6;k++)
				System.arraycopy(temp[k], 1, map[cnt+1][k], 1, 5);
				// 회전시킨 것 집어넣음
			}
			visited[i]=false;
			}
	}
	static int bfs(){ // map에서 최단거리 찾음
	// 한 단계 탐색 시 거리 +1
	// (1,1,1)->(5,5,5)
		LinkedList<cood> queue=new LinkedList<>();
		queue.add(new cood(1,1,1)); // 시작점
		boolean[][][] visited=new boolean[6][6][6];
		int be=1, af=0, ans=0;
		while(!queue.isEmpty()){
			for(int j=0;j<be;j++){
			cood cur=queue.poll();
				if(cur.z==5&&cur.y==5&&cur.x==5)
					return ans;
			for(int i=0;i<6;i++){
				int nextz=cur.z+dir[i][0];
				int nexty=cur.y+dir[i][1];
				int nextx=cur.y+dir[i][2];		
				if(nextz>0&&nextz<6&&nexty>0&&nexty<6&&nextx>0&&nextx<6&&!visited[nextz][nexty][nextx]&&map[nextz][nexty][nextx]==1){
				queue.add(new cood(nextz, nexty, nextx));
					visited[nextz][nexty][nextx]=true;
					af++;
				}
			}
		}
			be=af;
			af=0;
			ans++;
		}
		return Integer.MAX_VALUE; // impossi. 수정 필요
	}
}