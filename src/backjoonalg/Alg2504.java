package backjoonalg;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Alg2504 { // 제타위키의 힘을 빌렸읍니다,,
    static String input;
    static Stack<Character> st;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new Stack<Character>();
         input = br.readLine();
     bw.write(String.valueOf(SearchValue()));
              bw.close();
    }
    
    static int SearchValue() throws IOException{
        int cur = 1;
        int sum = 0;
        for(int i = 0; i < input.length(); i++){
            switch(input.charAt(i)){
                case '(' : 
                    st.add('(');
                    cur *= 2;
                    break;
                case '[' : 
                    st.add('[');
                    cur *= 3;
                    break;
                case ')' : 
                    if(st.empty() || st.peek() != '(')
                        return 0;
                    if(input.charAt(i-1) == '(')
                        sum += cur;
                    st.pop();
                    cur /= 2;
                    break;
                case ']' : 
                    if(st.empty() || st.peek() != '[')
                        return 0;
                    if(input.charAt(i-1) == '[')
                        sum += cur;
                    st.pop();
                    cur /= 3;
                    break;
            }
        }
        if(!st.empty())
            return 0;
        return sum;
    }
}
