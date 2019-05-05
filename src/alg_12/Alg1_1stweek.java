package alg_12;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Alg1_1stweek { // 1027번 고층 건물 도전중
    
    static int[] Buildings; // 각 건물의 높이
    static int[] ValueofBuildings; // 각 건물에서 보이는 건물 갯수
    static int NofBuildings;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        NofBuildings = Integer.parseInt(br.readLine());
        Buildings = new int[NofBuildings]; // 각 빌딩의 높이를 저장
        ValueofBuildings = new int[NofBuildings]; // 각 빌딩마다 보이는 빌딩의 개수를 저장하는 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < NofBuildings; i++)
            Buildings[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(ValueofBuildings, 0);
        int max = -1;
        for(int i = 0; i < NofBuildings; i++)
            if((ValueofBuildings[i] = eachside(i)) > max)
                max = ValueofBuildings[i];
        bw.write(max + "\n");
        bw.close();
    }
    
    static int eachside(int target){ // target의 왼쪽, 오른쪽으로 훝으면서 각 빌딩의 양쪽에서 보이는 빌딩의 개수를 구한다.
        int answer = 0;
        int iofLastvB = target; // 초기 값 : target
      // 먼저 이 건물까지 오기 전 가장 최근의 visible한 건물을 찾아야 한다.
        for(int i = target-1; i >= 0; i--){
            if(Buildings[iofLastvB] < Buildings[target]){
                if(Buildings[i] >= Buildings[iofLastvB]){
                    answer++; iofLastvB = i;// visible
                }
                else if((double)(Buildings[iofLastvB] - Buildings[target])/(target - iofLastvB) < (double)(Buildings[i] - Buildings[iofLastvB])/(iofLastvB - i)){
                     answer++; iofLastvB = i;// visible
                }
            }
            else{
                 if(Buildings[iofLastvB] == Buildings[target]){
                if(Buildings[i] > Buildings[iofLastvB] || iofLastvB == target){
                   answer++; iofLastvB = i;// visible
                }
                 }
            else{ // lastVB의 높이가 시작점보다 높음
                if((double)(Buildings[iofLastvB] - Buildings[target])/(target - iofLastvB) < (double)(Buildings[i] - Buildings[iofLastvB])/(iofLastvB - i)){
                    answer++; iofLastvB = i;// visible
                }
            }
        }
        }
        iofLastvB = target; // 초기화
         for(int i = target+1; i < NofBuildings; i++){
            if(Buildings[iofLastvB] < Buildings[target]){
                if(Buildings[i] >= Buildings[iofLastvB]){
                    answer++; iofLastvB = i;// visible
                }
                else if((double)(Buildings[iofLastvB] - Buildings[target])/(iofLastvB - target) < (double)(Buildings[i] - Buildings[iofLastvB])/(i - iofLastvB)){
                     answer++; iofLastvB = i;// visible
                }
            }
            else{
                if(Buildings[iofLastvB] == Buildings[target]){
                if(Buildings[i] > Buildings[iofLastvB] || iofLastvB == target){
                   answer++; iofLastvB = i;// visible
                }
                 }
            else{ // lastVB의 높이가 시작점보다 높음
                if((double)(Buildings[iofLastvB] - Buildings[target])/(iofLastvB - target) < (double)(Buildings[i] - Buildings[iofLastvB])/(i - iofLastvB)){
                    answer++; iofLastvB = i;// visible
                }
            }
        }
        }
        return answer;
    }
}

