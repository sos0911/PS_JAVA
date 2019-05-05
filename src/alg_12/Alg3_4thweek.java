package alg_12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alg3_4thweek {
    static long[] inputs;
    static long answer = -1;
    static long tempanswer = 0; // 각 findmixV에서의 임시 답
    static boolean[] visited; // 방문 배열
    static long minSB; // 가장 작은 수보다 작거나 같은 2의 배수 or 0
    static long maxSB; // 가장 큰 수보다 작거나 같은 2의 배수
    public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = new long[Integer.parseInt(br.readLine())];
        for(int i = 0; i < inputs.length; i++)
            inputs[i] = Integer.parseInt(br.readLine());
        Arrays.sort(inputs);
        visited = new boolean[inputs.length];
        Arrays.fill(visited, false);
        long temp = 1;
        int NofU = -1;
        if(inputs[0] < temp)
            minSB = 0;
        else{
            while(temp <= inputs[0]){
                temp = temp << 1;
                 NofU++;   
            }
            minSB = temp >> 1;   
        }
        while(temp <= inputs[inputs.length-1]){
             temp = temp << 1;
             NofU++;   
        }
        maxSB = temp >> 1;
        /*
        System.out.println("minSB : " + minSB);
        System.out.println("maxSB : " + maxSB);
        */
        FindMaxV(maxSB, 0, NofU);
        System.out.println(answer);
    }
    static int BS(long i){ // i보다 크거나 같은 수 중 최저 index를 반환
        int mid;
        int left = 0;
        int right = inputs.length - 1;
        while(right >= left){
            mid = (right + left) / 2;
            if(i == inputs[mid])
                if(mid-1 >= 0 && inputs[mid-1] != i)
                    return mid;
                else
                    right = mid-1;
            else if(i < inputs[mid])
                    right = mid-1;
                else
                    left = mid+1;
        }
        // 같은 값이 없어요..
        return left;
    }
    static void FindMaxV(long SB, int NofC, int NofU){ // SB보다 같거나 크고, SB*2보다 작은 수들 중 최대 1개를 골라 다음 자리로 진행하는 메소드 / NofC는 지금까지 답에 포함시킨 수 개수
        int STindex = BS(SB);
        /*
        System.out.println("Tempanswer : " + tempanswer);
        System.out.println("SB : " + SB);
        System.out.println("STindex : " + STindex);
        System.out.println("answer : " + answer);
        System.out.println("NofUnit : " + NofU);
        System.out.println("NofCount : " + NofC);
        System.out.println("");
        */
        if(SB == 0 || SB == minSB/2)
            if(NofC % 2 == 1){ // 홀수 개
                if(!visited[STindex]){
                    tempanswer = tempanswer ^ inputs[STindex];
                    if(answer < tempanswer)
                        answer = tempanswer;
                        return;
                }
                else
                    return;
            }
            else{
                    if(answer < tempanswer)
                        answer = tempanswer;
                        return;
            }     
                    
        if((tempanswer >> NofU) % 2 == 0) // 이 자리에 1이 필요함
            if(visited[STindex]) // 이 자리에 1을 가진 수가 없다.
                 FindMaxV(SB/2, NofC, NofU-1);
            else{
                int endI = BS(SB*2)-1;
                for(int j = 1; j <= endI+1 - STindex; j += 2){
                    for(int k = 0; k < j; k++){
                        tempanswer = tempanswer ^ inputs[endI-k];
                         visited[STindex-k] = true;
                    }
                    FindMaxV(SB/2, NofC+j, NofU-1);
                    for(int k = 0; k < j; k++){
                        tempanswer = tempanswer ^ inputs[endI-k];
                         visited[STindex-k] = false;
                    }
                }
                
                /*for(int i = STindex; i < BS(SB*2); i++){
                tempanswer = tempanswer ^ inputs[i];
                visited[i] = true;
                 FindMaxV(SB/2, NofC+1, NofU-1);
                tempanswer = tempanswer ^ inputs[i]; // 같은 수를 한번 더 xor하면 원 상태로 돌아간다.     
                visited[i] = false;
                }*/
            }
        else// 이 자리에는 1이 필요하지 않다.
            FindMaxV(SB/2, NofC, NofU-1);
    }
}

/*
10000
01000
01100
01010
*/