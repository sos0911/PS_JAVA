package alg_01_2019;
import java.util.*;

public class Alg9521 {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
        String A = sc.nextLine(); String B = sc.nextLine();
        int lenA = A.length(); int lenB = B.length();
        int[][] LCSA = new int[lenA+1][lenB+1]; // index 0 - lenA,lenB / 가장자리 0으로 초기화
        String[][] index = new String[lenA+1][lenB+1]; // LCS를 구하는 지표가 되는 배열
        // A가 y축, B가 X축이다. null로 초기화됨
        for(int i = 1; i <= lenA; i++)
            for(int j = 1; j <= lenB; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){  
                    LCSA[i][j] = LCSA[i-1][j-1]+1;
                 index[i][j] = "dia";   
                }
                else{
                    LCSA[i][j] = Math.max(LCSA[i-1][j], LCSA[i][j-1]);
                 if(LCSA[i][j] == LCSA[i-1][j])
                     index[i][j] = "top";
                    else
                    index[i][j] = "left";
                }
            }
        StringBuilder sb = new StringBuilder();
        int y = lenA; int x = lenB;
        while(index[y][x] != null){
            if(index[y][x] == "dia"){ // 이 때만 서로 공통인 글자가 나오므로 append.
                sb.append(A.charAt(y-1));
                    y--; x--;   
            }
            else if(index[y][x] == "top")
                y--;
            else
                x--;
        }
        System.out.println(LCSA[lenA][lenB]);
        System.out.println(sb.reverse().toString());
    }
}