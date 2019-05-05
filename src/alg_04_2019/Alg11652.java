package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg11652 {
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
		ArrayList<Long> list = new ArrayList<Long>(N);
		for(int i=0;i<N;i++)
			list.add(Long.parseLong(br.readLine()));
		Collections.sort(list, (l1, l2) -> -Long.compare(l1, l2));
		long ans = list.get(0), curN = list.get(0); // 현재 가장 큰 수, 현재 수
		int st = 1, cur = 0; // 가장 큰 수가 나온 횟수, 지금 숫자 횟수
		for(int i=1;i<N;i++){
			if(list.get(i) == ans)
				st++;
			else if(list.get(i) == curN)
				cur++;
			else{
				curN = list.get(i);
				cur = 1;
			}
			if(cur == st) // 가장 큰 수가 바뀜
				ans = curN;
		}
		System.out.println(ans);
	}
}
