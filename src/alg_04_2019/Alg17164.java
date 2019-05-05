package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg17164 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String input=br.readLine();
		int maxl=-1, curl=1; 
		// R, V, B 카운터
		char[][] counter=new char[26][];
		counter['R'-'A']=new char[]{'V','R'};
		counter['V'-'A']=new char[]{'R','B','V'};
		counter['B'-'A']=new char[]{'V', 'B'};
		for(int i=0;i<input.length()-1;i++){
			boolean check=false;
			for(char a : counter[input.charAt(i)-'A'])
				if(input.charAt(i+1)==a){ // 더 이상 아름답지 않음
					check=true;
					break;
				}
			if(!check)
				curl++;
			else{
		maxl=Math.max(maxl, curl);
		curl=1;
			}
	}
		maxl=Math.max(maxl, curl);
		System.out.println(maxl);
}
}
