package alg_04_2019;
import java.io.*;
import java.util.*;
class trie5052{
	boolean ter; // 여기서 끝나는 단어가 있나?
	boolean pass; // 지나간 단어가 있나?
	trie5052[] children;
	public trie5052(){
		ter=false;
		pass=false;
		children=new trie5052[10];//0-9
	}
	boolean insert(String tar, int idx){ // 넣다가 ter=true인 게 나오면 false
		// 끝까지 잘 넣었으면 true
		if(ter==true) // 여기서 끝나든 아니든 ter=true면 no
			return false;
		if(idx==tar.length()){
			ter=true;
			if(pass==true) // 자신이 끝나는데 여길 지나간 단어가 있음
				return false;
			else
			return true; // 성공적으로 넣음
		}
		else{
		int next=tar.charAt(idx)-'0';
		if(children[next] == null)
			children[next]=new trie5052();
			pass=true; // 어떤 단어가 이 노드에 도달하고 넘어가므로
		return children[next].insert(tar, idx+1);
		}
	}
}
public class Alg5052 {
	public static void main(String[] args) throws IOException{
		// trie 기초문제
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int noftc=Integer.parseInt(br.readLine());
		for(int i=0;i<noftc;i++){
			boolean check=false;
			trie5052 trie=new trie5052(); //root생성
			int n=Integer.parseInt(br.readLine());
			for(int j=0;j<n;j++)
				if(!check){
				if(!trie.insert(br.readLine(), 0)){
					bw.write("NO\n");
					check=true;
				}
				}
				else
					br.readLine();
			if(!check)
			bw.write("YES\n");
		}
		bw.close();
	}
}
// https://ncpc.idi.ntnu.no/ncpc2007/ test sets