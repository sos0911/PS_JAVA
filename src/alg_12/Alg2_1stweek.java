package alg_12;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Alg2_1stweek {
    static int Nofcoinofeachcase;
    static int Kofeachcase;
    static int answer = -1; // 답으로 쓰일 변수
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int NofTC = Integer.parseInt(br.readLine());
        for(int i = 0; i < NofTC; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Nofcoinofeachcase = Integer.parseInt(st.nextToken());
            Kofeachcase = Integer.parseInt(st.nextToken());
            boolean IsturnofFirst = true; // 첫 번쨰 사람의 턴인가?
            if(FindminV(Nofcoinofeachcase, IsturnofFirst))
                bw.write(answer + "\n");
            else
                bw.write("0\n");
        }
        bw.close();
    }
    
    static boolean FindminV(int Nofcoin, boolean IsturnofFirst){
        boolean Isthaterror = false; // 에러 검출을 위한 boolean
        
        if(Nofcoin == 0){
            if(IsturnofFirst)
                return false;
            else
                return true;
        }
        if(Kofeachcase == 1){
            if(Nofcoinofeachcase % 2 == 1){
                answer = 1;
                return true;
            }
        else
            return false;
        }
        for(int i = 1; i <= Nofcoin; i *= Kofeachcase){
            if(IsturnofFirst)
                IsturnofFirst = false;
            else
                IsturnofFirst = true;
            if(FindminV(Nofcoin - i, IsturnofFirst) == false){ // 탐색 중에 불가능한 경우가 나옴
                if(!IsturnofFirst){// 상대방의 턴일 때 모든 경우에 pass되어야 하므로
                    Isthaterror = true;
                break; // 찾는 숫자 이전의 숫자가 잘못되었으므로 return false
                }
                else // 첫번째 사람의 턴일 때
                    continue; // 이 숫자는 안되므로 다음 숫자를 찾아본다.
            }
            else{ // 함수 결과가 true(가능한 경우)
                if(!IsturnofFirst)
                    continue;
                else{ // 첫번째 사람의 턴일 떄 특정 숫자를 선택했더니 가능한 경우가 생김
                    if(Nofcoinofeachcase == Nofcoin) // 처음 가져오는 금화량 선택 중인 메소드
                    answer = i; // answer 저장
                    return true;
                }
            }
        }
        if(!IsturnofFirst)
            if(!Isthaterror)// 상대방 턴에서 모든 가능한 경우가 통과되었다.
                return true;
       return false; // false 반환(첫번째 사람의 턴일 떄 모든 경우 탐색 + 상대방 턴일 때 불가능 상황 발생)      
    }
}
