package alg_04_2019;
import java.io.*;
import java.util.*;
class Info1476{
	long s,t,gcd;
	public Info1476(long s, long t, long gcd){
		this.s=s;
		this.t=t;
		this.gcd=gcd;
	}
}
public class Alg1476 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//x의 범위가 헷갈린다. long형으로 둬야겠다..
		//곱셈의 역원 범위를 모르기 때문
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int E=sc.nextInt();
		int S=sc.nextInt();
		int M=sc.nextInt();
		long temp=15*28*19;
		// mod 15에 대한 SM 역원을 구함
		long ans=temp/15*xgcd(temp/15, 15).s*E+temp/28*xgcd(temp/28,28).s*S+temp/19*xgcd(temp/19,19).s*M;
		// 역원은 무조건 0 이상으로 구하자.
		System.out.println(ans%temp==0? temp:ans%temp);
	}
	static Info1476 xgcd(long a, long b){
		// extended uclid
		//as+bt=gcd(a,b)=1
		// a>=b, s를 구한다.
		ArrayList<Long>s=new ArrayList<>();
		s.add((long)1); s.add((long)0);
		ArrayList<Long>t=new ArrayList<>();
		t.add((long)0); t.add((long)1);
		ArrayList<Long>r=new ArrayList<>();
		r.add(a); r.add(b);
		ArrayList<Long>q=new ArrayList<>();
		q.add(a/b);
		while(true){
			if(r.get(r.size()-2)%r.get(r.size()-1)==0)
				break;
			r.add(r.get(r.size()-2)%r.get(r.size()-1));
			s.add(s.get(s.size()-2)-s.get(s.size()-1)*q.get(q.size()-1));
			t.add(t.get(t.size()-2)-t.get(t.size()-1)*q.get(q.size()-1));
			q.add(r.get(r.size()-2)/r.get(r.size()-1));
		}
		return new Info1476((s.get(s.size()-1)+b)%b, t.get(t.size()-1), r.get(r.size()-1));
	}
}
