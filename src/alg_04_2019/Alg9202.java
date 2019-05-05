package alg_04_2019;
import java.io.*;
import java.util.*;
class trie9202{
	boolean ter;
	trie9202[] children;
	public trie9202(){
		ter=false;
		children=new trie9202[26];
	}
	void insert(String tar, int idx){
		if(idx==tar.length())
			ter=true;
		else{
		int next=tar.charAt(idx)-'A';
		if(children[next]==null)
			children[next]=new trie9202();
			children[next].insert(tar, idx+1);
		}
	}
	boolean find(String tar, int idx){ // 사전 단어 찾으면 true
		if(idx==tar.length())
			return ter? true : false;
		else{
			int next=tar.charAt(idx)-'A';
			if(children[next]==null) // 사전에 없음이 바로 판명
				return false;
			else
				return children[next].find(tar, idx+1);
		}
	}
}
public class Alg9202 {
	static char[][] map=new char[4][];
	static trie9202 trie=new trie9202();
	static int[][]dir={{-1,0},{1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	static int[] sctable={0, 0, 0, 1, 1, 2, 3, 5, 11}; // 점수표
	static String max; // ans for each grid
	static int score,nofw;
	public static void main(String[] args) throws IOException{
		// trie 
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int w=Integer.parseInt(br.readLine());
		for(int i=0;i<w;i++)
			trie.insert(br.readLine(), 0);
		br.readLine();
		int nofb=Integer.parseInt(br.readLine());
		for(int i=0;i<nofb;i++){
			score=0; nofw=0; max=""; // 초기화
			for(int j=0;j<4;j++)
				map[j]=br.readLine().toCharArray();
			for(int j=0;j<4;j++)
				for(int k=0;k<4;k++)
					dfs(1, 1<<(j*4+k), j, k, Character.toString(map[j][k])); // 시작 위치에서 가능한 단어조합을 찾음
			// 시작 지점은 이미 방문된 것으로 처리
			bw.write(score + " " + max + " " + nofw+"\n");
			if(i!=nofb-1)
			br.readLine();
		}
		bw.close();
	}
	static void dfs(int cnt, int visited, int y, int x, String cur){
		// 조사할 위치 (y,x), 현재까지 완성한 단어 cur
		if(cnt==9)
			return;
		else{
			if(trie.find(cur, 0)){ // 사전 단어를 찾음
				if(cur.length()>max.length())
					max=cur;
				else if(cur.length()==max.length() && cur.compareTo(max)<0)
					max=cur;
				score+=sctable[cur.length()];
				nofw++;
			}
			for(int i=0;i<8;i++){
				int nexty=y+dir[i][0];
				int nextx=x+dir[i][1];
				if(nexty>=0 && nexty<4 && nextx>=0 && nextx<4 && (visited&(1<<(nexty*4+nextx)))==0){
					dfs(cnt+1, visited|(1<<(nexty*4+nextx)), nexty, nextx, cur.concat(Character.toString(map[nexty][nextx])));
				}
			}
		}
	}
}
