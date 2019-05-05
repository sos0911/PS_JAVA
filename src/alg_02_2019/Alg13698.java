package alg_02_2019;
import java.io.*;
public class Alg13698 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] order = {{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}}; //A B C D E F command
         int[] answer = {1, 4}; // small, big
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++){
            int com = input.charAt(i) - 'A';
            for(int j = 0; j < 2; j++)
                if(answer[j] == order[com][0])
                    answer[j] = order[com][1];
                else if(answer[j] == order[com][1])
                    answer[j] = order[com][0];
        }
        for(int i : answer)
            System.out.println(i);
    }
}
