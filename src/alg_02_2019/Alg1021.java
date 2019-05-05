package alg_02_2019;
import java.util.*;
public class Alg1021 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] tar = new int[M]; // 큐 안의 초기 상대적 위치들 저장
        for(int i = 0; i < M; i++)
            tar[i] = sc.nextInt();
        int answer = 0;
        for(int i = 0; i < M; i++){
            if(tar[i] == 1){ // 바로 뽑기 가능
                for(int j = i+1; j < M; j++)
                    tar[j]--;
                N--;
            continue;
            }
            if((N % 2 == 0 && tar[i] >= N/2+1) || (N%2 == 1 && tar[i] > N/2+1)){ // 오른쪽
                    for(int j = i+1; j < M; j++)
                        tar[j] = (tar[j]+N-tar[i]) % N;   
                    answer += N-tar[i]+1;
            }
                else{ // 왼쪽
                    for(int j = i+1; j < M; j++)
                        tar[j] = tar[j] - tar[i] <= 0? N+tar[j]-tar[i] : tar[j] - tar[i];   
                    answer += tar[i]-1;
                    }
            N--; // 하나씩 빼므로
        }
        System.out.println(answer);
    }
}
