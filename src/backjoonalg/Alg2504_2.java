package backjoonalg;
import java.util.Arrays;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Alg2504_2 { // 2504번(미완)
 
    static Stack<Character> st; // global stack
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean Isthereerror = false; // Isthereerror
        int answer = 0; // 최종 답
        st = new Stack<Character>();
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++){
            char temp = input.charAt(i);
            if(temp == '(' || temp == '[')
                st.push(temp);
            else{ // ) or ] 
                if(st.empty()){
                   bw.write(String.valueOf(0));
                    bw.close();
                    return;
                }
                 if(temp == ')'){
                     if(st.peek() == '('){ // 바로 붙어있는 () 한쌍
                         st.pop();
                      st.push('2');   
                     }
                  else{ // 쌍이 바로 붙어 있지 않거나 애초부터 잘못된 문자열
                      if(ManageException('[', '(', 2) == -1)
                      Isthereerror = true;
                  }
                 }
                else{ // ']'
                    if(st.peek() == '['){ // 바로 붙어있는 () 한쌍
                         st.pop();
                      st.push('3');   
                     }
                  else{ // 쌍이 바로 붙어 있지 않거나 애초부터 잘못된 문자열
                   if(ManageException('(', '[', 3) == -1)
                      Isthereerror = true;
                  }
                }
            }
            if(Isthereerror)
            break;
        }
          if(Isthereerror)
            bw.write(String.valueOf(0));
        else{
        while(!st.empty()){
         if(st.peek() == '(' || st.peek() == '['){// [[.... 이 예외 처리를 해줘야 함
          bw.write(String.valueOf(0));
                    bw.close();
                    return;
         }
             // stack에 숫자밖에 없음
            answer += st.pop() - '0';
        }
        bw.write(String.valueOf(answer));
        }
        bw.close();
    }
    static int ManageException(char wrongC, char expectedC, int value){ // 예외 상황 처리 메소드(떨어진 쌍 & 잘못된 문자열). // 올 수 있는 top은 '(', '[', '숫자'
        int answer = 0;
        while(!st.empty()){ // '[)' 또는 '(]'
        char top = st.peek();
        if(top == wrongC)
            return -1;
        else{
            if(top == expectedC){ // '(2)' 또는 '[3]'
            st.pop();
            answer *= value;
            st.push((char)(answer + '0'));
            break;
        }
        else // '23' 같은 경우
            answer += st.pop() - '0';
         }
        }
         return answer;    
    }
}