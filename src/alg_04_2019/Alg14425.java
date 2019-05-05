package alg_04_2019;
import java.io.*;
import java.util.*;
class trienode{
	trienode[] children = new trienode[26];
	// a-z
	boolean terminal; // 여기서 끝나는 문자열이 있는가?
	public trienode(){
		terminal = false;
	}
	void insert(String tar, int curind){
		if(curind == tar.length())
			terminal=true;
		else{
			int next=tar.charAt(curind)-'a';
			if(children[next] == null)
				children[next]=new trienode();
			children[next].insert(tar, curind+1);
		}
	}
	trienode find(String tar, int curind){
		if(curind == tar.length())
			return this; // 되나? C++에서는 되는데
		int next=tar.charAt(curind)-'a';
		if(children[next] == null)
			return null;
		return children[next].find(tar, curind+1);
	}
}
public class Alg14425 {
	// trie 예제
	// tc : 500*10000+10000*500
	 public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st=new StringTokenizer(br.readLine());
		 int N=Integer.parseInt(st.nextToken());
		 int M=Integer.parseInt(st.nextToken());
		 trienode trie = new trienode(); // root 생성
		 for(int i=0;i<N;i++)
			 trie.insert(br.readLine(), 0); // 삽입
		 int ans=0;
		 // 어떤 문자열이 오면 그 길이 M에 선형 비례하여 찾아낸다.
		 trienode temp; // 참조변수
		 for(int i=0;i<M;i++)
			 // 노드가 존재하고 그 문자열이 input에 실제로 존재하면 ans++
			 if((temp=trie.find(br.readLine(), 0)) != null && temp.terminal==true)
				 ans++;
		 System.out.println(ans);
	 }
}
