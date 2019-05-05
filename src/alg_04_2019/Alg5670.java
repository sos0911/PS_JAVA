package alg_04_2019;
import java.io.*;
import java.util.*;
class trie5670{
	trie5670[] children;
	int[] cnt; // solo. 메모리 초과 날까?
	int nofway;
	boolean ter;
	// ter도 결국 필요한가봄
	public trie5670(){
		children=new trie5670[26]; // a-z
		ter=false;
		nofway=0;
		cnt=new int[26];
	}
	void insert(String tar, int idx){
		if(idx==tar.length())
			ter=true;
		else{
			int next=tar.charAt(idx)-'a';
			cnt[next]++;
			if(children[next]==null){
				children[next]=new trie5670();
				nofway++;
			}
			children[next].insert(tar, idx+1);	
		}
	}
	int judge(String tar, int idx){ // ㅅㅂ 이게 문제
		// tar을 검색할 때 누르는 키 수 반환
		// 주의! nofway==1이라 하여 지나간 단어가 1개라는 뜻은 아니다.
		// 대신 solo는 계속 간 후에 봐야 하네
		if(idx==tar.length())
			return 0;
		else{
			int next=tar.charAt(idx)-'a';
			if(cnt[next]==1)
				return 1;
			if(nofway>1 || ter)
				return children[next].judge(tar, idx+1)+1;
			else
				return children[next].judge(tar, idx+1);
		}
	}
}
public class Alg5670 {
	static int ans;
	public static void main(String[] args) throws IOException{
		// trie 
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String temp;
		while((temp=br.readLine()) != null){
			int n=Integer.parseInt(temp);
			String[] input=new String[n]; // 0-
			trie5670 trie=new trie5670(); // root
			int ans=0;
			for(int i=0;i<n;i++)
				trie.insert((input[i]=br.readLine()), 0);
			for(int i=0;i<n;i++)
				if(trie.nofway==1 && n!=1)
					ans+=trie.judge(input[i], 0)+1;
				else
						ans+=trie.judge(input[i], 0);
			bw.write(String.format("%.2f", ans/(float)n)+"\n");
		}
		bw.close();
	}
}
/*
5
cysxvjjxratkmozev(5)
cysxvjjxratkmozep(5)
cysp (3)
cy (1)
cysxvjjx(3)
*/