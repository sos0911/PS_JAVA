package alg_10;
import java.util.Scanner;

public class Alg2_4thweek {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seq = "1"; // 수열은 무조건 1부터 시작한다.
        Backtracking(N, seq);
    }
    
    static int Backtracking(int N, String seq){
        if(Isthatbadseq(seq)) // 만약 지금까지의 수열이 나쁜수열일 때
            return -1;
        if(seq.length() == N){ // 수열을 완성함
            System.out.println(seq);
            return 0;   
        }
        
        for(int i = 1; i <= 3; i++){
            seq = seq.concat(String.valueOf(i));
            if(Backtracking(N, seq) == 0) // 지금 수열에서 하나 추가한 게 정답일 경우
            return 0; // 종료
            
            seq = seq.substring(0, seq.length()-1); // 하나 추가한 게 나쁜수열이므로 다시 되돌아감. 다음 for문으로
        }
        return -1; // 1,2,3 중 아무 것도 붙이지 못할 경우
    }
    
    static boolean Isthatbadseq(String seq){
        for(int i = 0; i < seq.length()/2; i++)
            if(seq.substring(seq.length()-1-i, seq.length()).equals(seq.substring(seq.length()-2-i*2, seq.length()-1-i)))
                return true;
        return false;
    }
}
