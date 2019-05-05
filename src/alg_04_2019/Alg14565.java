package alg_04_2019;
import java.io.*;
import java.util.*;
class Info{ // struct
	long s, t, gcd;
	public Info(long s, long t, long gcd){
		this.s=s;
		this.t=t;
		this.gcd=gcd;
	}
}
public class Alg14565 {
	// ㅈㄴ 불편함 C++로 옮겨타야지
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// way of google code jam 
		// 답의 범위는 0- n-1이다.
		// 덧셈역은 N-A
		// 곱셈역이 문제네여
		// mod : n as+pt=1
		long N=sc.nextLong();
		long A=sc.nextLong();
		Info ans=xgcd(N, A);
		if(ans.gcd!=1)
			System.out.println((N-A)+" "+(-1));
		else
			System.out.println((N-A)+" "+(ans.t+N)%N);
	}
	static Info xgcd(long a, long b){
		// extended uclid way
		// 최종 정보 반환
		// as+bt=gcd(a,b)에서 t를 구하면 된다.
		// gcd(a,b)==1이어야 역원을 구할 수 있겠네.
		// 역원이 음수가 될 수도 있으니 주의
		// 무조건 n과 a는 서로소여야 역원이 존재
		// 고로 gcd(a,n)=1이 아니면 바로 -1
		ArrayList<Long> s=new ArrayList<>();
		s.add((long)1); s.add((long)0);
		ArrayList<Long> t=new ArrayList<>();
		t.add((long)0); t.add((long)1);
		ArrayList<Long> r=new ArrayList<>();
		r.add(a); r.add(b);
		ArrayList<Long> q=new ArrayList<>();
		q.add(a/b);
		while(true){
			if(r.get(r.size()-2)%r.get(r.size()-1)==0)
				break;
			r.add(r.get(r.size()-2)%r.get(r.size()-1));
			s.add(s.get(s.size()-2)-s.get(s.size()-1)*q.get(q.size()-1));
			t.add(t.get(t.size()-2)-t.get(t.size()-1)*q.get(q.size()-1));
			q.add(r.get(r.size()-2)/r.get(r.size()-1));
		}
		return new Info(s.get(s.size()-1), t.get(t.size()-1), r.get(r.size()-1));
	}
}
