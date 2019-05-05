package SecondTry;
import java.io.*;
import java.util.*;
public class Alg1475 {
	
	 public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int[] num = new int[10]; // 0-9
		 String input = br.readLine();
		 int len = input.length();
		 for(int i=0;i<len;i++)
			 num[input.charAt(i)-'0']++;
		 int max = 0;
		 for(int i=0;i<10;i++){
			 if(i == 6 || i == 9)
				 continue;
			 max = Math.max(max, num[i]);
		 }
		 int stn = (num[6]+num[9])%2 == 0?  (num[6]+num[9])/2 : (num[6]+num[9])/2+1;
		 max = Math.max(max, stn);
		 System.out.println(max);
	 }
}
