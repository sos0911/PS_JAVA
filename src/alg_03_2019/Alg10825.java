package alg_03_2019;
import java.io.*;
import java.util.*;
class people{
	String name;
	int kor, eng, math;
	public people(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}
public class Alg10825 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		people[] input = new people[N]; // 0 -
		StringTokenizer st;
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			input[i] = new people(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(input, (p1, p2) -> 
				   Integer.compare(p1.kor, p2.kor) != 0 ? -Integer.compare(p1.kor, p2.kor) : Integer.compare(p1.eng, p2.eng) != 0? Integer.compare(p1.eng, p2.eng) : Integer.compare(p1.math, p2.math) != 0 ? -Integer.compare(p1.math, p2.math) : p1.name.compareTo(p2.name));
		for(people p : input)
			bw.write(p.name + "\n");
		bw.close();
}
}