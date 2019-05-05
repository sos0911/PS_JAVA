package alg_04_2019;
import java.io.*;
import java.util.*;
class Info3163{
	int id, time;
	public Info3163(int id, int time){
		this.id = id;
		this.time = time;
	}
}
public class Alg3163 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Noftc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < Noftc; i++){
			st= new StringTokenizer(br.readLine());
			int nofa = Integer.parseInt(st.nextToken());
			ArrayList<Info3163> list = new ArrayList<Info3163>(nofa); // 개미 id, time
			ArrayList<ArrayList<Integer>> posi = new ArrayList<ArrayList<Integer>>(2); // 개미들 위치 저장 (왼쪽, 오른쪽)
			for(int j = 0; j < 2; j++)
				posi.add(new ArrayList<Integer>(nofa));
			int len = Integer.parseInt(st.nextToken());
			int tark = Integer.parseInt(st.nextToken());
			int pos, id;
			for(int j = 0; j < nofa; j++){
				st= new StringTokenizer(br.readLine());
				pos = Integer.parseInt(st.nextToken());
				id = Integer.parseInt(st.nextToken());
				if(id > 0)
					posi.get(1).add(len-pos+1); // posi안에 절댓값 0은 x
				else
					posi.get(0).add(pos+1);
				list.add(new Info3163(id, -1));
			}
			Collections.sort(posi.get(0)); // 오름
			Collections.sort(posi.get(1), (n1, n2) -> Integer.compare(n2, n1)); // 내림
			// 묶고 정렬한다.
			int osize = posi.get(0).size(), tsize= posi.get(1).size();
			for(int j = 0; j < osize; j++)
				list.get(j).time = posi.get(0).get(j);
			for(int j = osize; j < nofa; j++)
				list.get(j).time = posi.get(1).get(j-osize);
			Collections.sort(list, (n1,n2) -> Integer.compare(n1.time, n2.time) == 0? Integer.compare(n1.id, n2.id) : Integer.compare(n1.time, n2.time));
			System.out.println(list.get(tark-1).id);
		}
	}
}
