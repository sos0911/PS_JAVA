package alg_05_2019;
import java.io.*;
import java.util.*;
class point{
	int y, x;
	public point(int y, int x){
		this.y=y;
		this.x=x;
	}
}
class Info{
	ArrayList<point> blank=new ArrayList<>();
	// 빈칸 좌표 저장
	int area;
	public Info(ArrayList<point> blank, int area){
		this.blank=blank;
		this.area=area;
	}
}
class Alg16988{
	static int[][] map;
	static int N, M, ans=0;
	static int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	static boolean[][] visited2; // setrock
	static ArrayList<Info> list=new ArrayList<>(1000*1000);
	// deque?
	// 영역들 가장자리 빈칸 수와 조건 충족 시 영역 넓이 저장
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			map[i][j]=Integer.parseInt(st.nextToken());
		}
		visited=new boolean[N][M]; // 사전조사 v
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(map[i][j]==2&&!visited[i][j])
					bfs(new point(i, j));
		// 현재 map에서는 이미 충족된 곳은 없다.
		visited2=new boolean[N][M];
		setrock(0, 0, 0); // 가능성이 있는 곳에 돌을 놔봄
		System.out.println(ans);
	}
	static void setrock(int cnt, int plus, int curi){
		if(cnt==2){
			ans=Math.max(ans, plus);
			return;
		}
		for(int i=curi;i<list.size();i++){
			int add=0;
			ArrayList<point> blank=list.get(i).blank;
			// 해당 구역의 빈칸 좌표
			boolean[] fi=new boolean[blank.size()];
			for(int j=0;j<blank.size();j++){
				point temp=blank.get(j);
				if(!visited2[temp.y][temp.x]){
					add++;
					fi[j]=true;
					visited2[temp.y][temp.x]=true;
				}
			}
			if(cnt+add<=2)
				setrock(cnt+add, plus+list.get(i).area, i+1);
			// 처음 발견된 빈칸은 다시 제자리로
			for(int j=0;j<blank.size();j++)
				if(fi[j])
				visited2[blank.get(j).y][blank.get(j).x]=false;
		}
		// 지금 값 이후로 조건만족x
		ans=Math.max(ans, plus);
	}
	static void bfs(point st){
		// 해당 구역의 넓이와 빈칸 좌표 저장
		LinkedList<point> queue=new LinkedList<>();
		visited[st.y][st.x]=true;
		queue.add(st);
		ArrayList<point> blank=new ArrayList<>();
		int area=1;
		boolean error=false;
		while(!queue.isEmpty()){
			point temp=queue.poll();
			for(int i=0;i<4;i++){
				int nexty=temp.y+dir[i][0];
				int nextx=temp.x+dir[i][1];
				if(nexty>=0&&nexty<N&&nextx>=0&&nextx<M&&!visited[nexty][nextx]){
					if(map[nexty][nextx]==2){
						area++;
						visited[nexty][nextx]=true;
						queue.add(new point(nexty, nextx));
					}
					else if(map[nexty][nextx]==0){
						if(blank.size()<2)
							blank.add(new point(nexty, nextx));
						else
							error=true;
					}
				}
			}
		}
		if(!error)
			list.add(new Info(blank, area)); // 빈칸 2개 아래 영역만 포함
	}
}

/*
일부 경계선을 공유하면 어쩌지


 111
0021
120
121
121
121
 1

경계선 중 빈칸이 2개 이상 ::
어차피 해당안됨

경계선 중 빈칸이 2개이하::
ㄱㅊ

빈칸이 2개까지 나오는 경우에 한해 0을 queue에 넣어서 탐색을 한다.

*/