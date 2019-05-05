package backjoonalg;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Alg9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int NofTC = Integer.parseInt(br.readLine());
        for(int i = 0; i < NofTC; i++){
            boolean IstheCpossi = true; // 이 case는 가능한가?
           Stack<Character> st = new Stack<Character>();
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++){
                if(input.charAt(j) == '(')
                    st.push(input.charAt(j));
                else{
                    if(st.empty()){
                        IstheCpossi = false;
                        break;
                    }
                    else
                        st.pop();
            }
        }
            if(st.empty() && IstheCpossi)
                 bw.write("YES\n");
            else
                 bw.write("NO\n");
    }
 bw.close();   
}
}
