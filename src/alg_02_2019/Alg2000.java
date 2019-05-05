/*package alg_02_2019;
import java.util.*;
import java.io.*;
class book implements Comparable<book>{
    int h, w; // height / width
    public book(int h, int w){
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(book b){ // 내림차순 정렬
        if(h < b.h)
            return 1;
        else if(h > b.h)
            return -1;
        else
            return 0;
    }
}
public class Alg2000 {
    static book[] input; // input배열
    static int Nofb; // 책 수
    static int dp[][][][]; 
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Nofb = Integer.parseInt(br.readLine());
        dp = new int[4][901][2101][Nofb]; // 0으로 초기화
        StringTokenizer st;
        for(int i = 0; i < Nofb; i++){
            st = new StringTokenizer(br.readLine());
            input[i] = new book(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(input); // H에 대해 내림차순 정렬
        int answer = Integer.MAX_VALUE;
       answer = Math.min(answer, dfsdp(3, 0, 0, 0));
        System.out.println(answer);
    }
    static int dfsdp(int Nofc, int height, int width, int startI){ // 현 상황에서 남아 있는 책들의 조합에 따라 최소의 추가되는 넓이를 반환
        // 이 메소드에서는 startI를 세 군데에 붙여보고 가장 best인 추가 넓이를 반환
        if(startI == Nofb)
            return 0;
        if(dfsdp[Nofc][height][width][startI] != 0)
            return dfsdp[Nofc][height][width][startI];
        for(int i = 0; i < 3; i++){
            
        }
    }
}
*/
/*
부분 문제 정의

input배열에서 높이 내림차순 sort

dp(int NofS, int H(..), int maxw, int lastI)

2 900 2100 70

nofs : 지금까지 비어 있는 칸의 수
H : 지금까지 완성된 책장의 총 높이 (s1 + s2 + s3)
maxw : 지금까지 완성된 책장의 총 너비
lastI : 지금까지 쓴 input배열의 마지막 인덱스

일때
남은 책들을 조합해서 나오는 결과 중 best를
(변화되는 H값)(변화되는 W값) 형태로 주기
dp default = 0
h값은 -
w값은 +  

ex)


8 10 9 5 4.. 

10 9 5 4 8..

한 책장 칸에서
앞에서 쓰인 책들이 순서 상관없이 같고
그 조합이 세 칸 안에서 순서 상관없이 존재하면
dp 사용가능 (부분 문제)

158760000

4
220 29
195 20
200 9
180 30

지금 상황에서 세 칸에 한 권씩이 적어도 하나씩 들어가
있는지 확인하는 좋은 방법?

세 칸에 책이 각 하나씩 들어가는 순간
그 책장의 높이는 고정된다.

책을 처음에 하나씩 넣고 시작하면 줄이기 가능

======

시간 복잡도:

문제 수 * 문제 푸는데 걸리는 시간

2천만개 * ..
*/