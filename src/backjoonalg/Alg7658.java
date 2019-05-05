package backjoonalg;
import java.util.*;

public class Alg7658 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Nofp = sc.nextInt();
        int[][] inputs = new int[Nofp][2];
        int[] rank = new int[Nofp]; // input 순서를 따른다.
        Arrays.fill(rank, 1);
        for(int i = 0; i < Nofp; i++){
            inputs[i][0] = sc.nextInt(); // 키
            inputs[i][1] = sc.nextInt(); // 몸무게
        }
        for(int i = 0; i < Nofp; i++)
            for(int j = i+1; j < Nofp; j++){
                if(inputs[i][0] - inputs[j][0] < 0 && inputs[i][1] - inputs[j][1] < 0)
                   rank[i]++;
                if(inputs[i][0] - inputs[j][0] > 0 && inputs[i][1] - inputs[j][1] > 0)
                    rank[j]++;
            }
        for(int i : rank)
            System.out.print(i + " ");
    }
}
