package alg_09;
import java.util.Scanner;

public class AlgBackjoon { 
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
        int NofTC = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < NofTC; i++){
            int heightofG = sc.nextInt();
            int widthofG = sc.nextInt();
            sc.nextLine();
            
            char[][] chargrid = new char[heightofG][widthofG];
            for(int j = 0; j < heightofG; j++){
            String temp = sc.nextLine();
            for(int k = 0; k < temp.length(); k++)
                chargrid[j][k] = temp.charAt(k);
            }
            
            int it = 0; // 뒤집을 때 쓰는 iterator, half iterator
            char tempN;
            for(int j = 0; j < heightofG; j++){
            while(it < widthofG/2){
                tempN = chargrid[j][it];
                chargrid[j][it] = chargrid[j][widthofG-1-it];
                chargrid[j][widthofG-1-it] = tempN;
                it++;
            }
                it = 0; // 초기화
            }
                
            for(int j = 0; j < heightofG; j++){
                for(int k = 0; k < widthofG; k++){
                    System.out.print(chargrid[j][k]);       
                }
                System.out.println("");
            }
            
        }
    }
}