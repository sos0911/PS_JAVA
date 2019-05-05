package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg1806 {
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sti = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(sti.nextToken());
		int S = Integer.parseInt(sti.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>(N); // 지금까지 사용한 수들
		int sum=0,ans=300000,st=0,idx=0; // 시작 i, 끝 i
		sti=new StringTokenizer(br.readLine());
		// 왔다갔다 반복하면서 구해보자
		while(idx != N){
			// 끝점을 늘린다
		while(sum < S && idx < N){
			int temp = Integer.parseInt(sti.nextToken());
			list.add(temp);
			sum += temp;
			idx++;	
		}
			// 시작점을 늘린다
		while(sum >= S && st < N){
			sum -= list.get(st);
			st++;
		}
			ans = Math.min(ans, idx-st+1);
		}
		if(st==0 && sum < S){
			System.out.println("0");
		return;	
		}
		System.out.println(ans);
	}
}
