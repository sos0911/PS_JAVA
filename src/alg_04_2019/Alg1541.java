package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg1541 {
	
		public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
			input = input + "-"; // 편의
			int len = input.length(), ans = 0, temps = 0;
			int lastI = -1; boolean Isplus = true; // 현재 부호
			for(int i = 0; i < len; i++){
				if(input.charAt(i) == '-' || input.charAt(i) == '+'){
					temps += Integer.parseInt(input.substring(lastI+1, i));
					lastI = i;
				}
				if(input.charAt(i) == '-'){ // 지금까지 쌓은 숫자들 반영
					if(Isplus){
						ans += temps;
					Isplus = false;	
					}
					else
						ans -= temps;
					temps = 0;
				}
			}
			System.out.println(ans);
		}
}
