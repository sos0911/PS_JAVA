package alg_02_2019;
import java.io.*;
import java.util.*;
public class Alg1107 {
    
    public static void main(String[] args) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String des = br.readLine(); // 목적지 채널
        StringBuilder possim = new StringBuilder(); // 숫자패드로 이동할 채널
        int Nofmal = Integer.parseInt(br.readLine()); // 고장난 버튼 수
        if(Nofmal == 10){ // 숫자가 모두 고장남 > ++..
            System.out.println(Math.abs(Integer.parseInt(des) - 100));
         return;   
        }
        ArrayList<Integer> malf = new ArrayList<Integer>(Nofmal);
        String[] tempS = br.readLine().split(" ");
         int temp, check = 0;
        for(int i = 0; i < Nofmal; i++){
            temp = Integer.parseInt(tempS[i]);
            if(temp == 0 || temp == 1)
                check++;
            malf.add(Integer.parseInt(tempS[i]));
        }
        if(check == 2)
            malf.add(10); // 0과 1 둘 다 고장이므로 10도 고장
        for(int i = 0; i < des.length(); i++){
            boolean Ismal = false; // 해당 자리가 고장났는가?
            temp = des.charAt(i) - '0'; // 목적지의 해당 자리수
            for(int j : malf)
                if(temp == j){
                    Ismal = true;
                    break;
                }
            if(!Ismal) // 해당 자리 고장 안남
                possim.append(temp);
            else{ // 고장나서 가장 가까운 멀쩡한 숫자패드를 찾아야 함
                int mind = 15, chN = -1, rep; // 숫자 간 차이, 쓸 숫자
                    rep = i == 0 ? 11 : 10; // 첫번쨰 숫자면 0-10, 아니라면 0-9
                    for(int j = 0; j < rep; j++){
                        boolean Ismal2 = false; // 지금 대용으로 쓸 숫자가 고장났는가?
                        for(int k : malf)
                            if(j == k){ 
                                Ismal2 = true;
                                break;
                            }
                        if(Ismal2) // 고장난 숫자라면 pass
                            continue;
                        if(Math.abs(temp - j) < mind){
                            mind = Math.abs(temp - j);
                         chN = j;   
                        }
                    }     
                possim.append(chN);
            }
        }
        int possiN = Integer.parseInt(possim.toString());
        System.out.println("possiN : " + possiN);
        System.out.println(Math.min(String.valueOf(possiN).length() + Math.abs(possiN - Integer.parseInt(des)), Math.abs(Integer.parseInt(des) - 100)));
    }
}
/*
100 -> 5457

근데 6, 7, 8번 단추 고장

이 상태에서 숫자패드를 조작하야
5457번에 가장 가까운 채널로 이동 후
+, -를 이용하여 움직여야 함

큰 자리부터 우선권이 있으므로
5455번 -> +1 +1 => 6번

자리를 보고 있는데 고장x
-> 그대로 넣는다

자리를 보고 있는데 그 자리가 고장났다 -->
위아래로 1++씩 증가시키면서 안 고장난 자리를
찾아 넣는다.

0에 도달하면 그떄부턴 위로만 탐색
모든 버튼이 고장났으면 Math.abs(des - 100);

도출된 결과에서 결과 vs abs값 중 작은 걸 출력

==================

목적지 : 999
고장난 것 : 9
1000 간 다음 -1
*/