package backjoonalg;
import java.util.Scanner;
public class Alg14888 {
    static int Nofn; // 수 개수
    static int[] numbers; // 수들
    static int[] Nofop = new int[4]; // 연산자 개수 (+, -, x, /)
    static int max = -1100000000, min = 1100000000; // long?
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Nofn = Integer.parseInt(sc.nextLine());
        numbers = new int[Nofn];
        String[] temp = sc.nextLine().split(" ");
        for(int i = 0; i < Nofn; i++)
        numbers[i] = Integer.parseInt(temp[i]);
        temp = sc.nextLine().split(" ");
        for(int i = 0; i < 4; i++)
        Nofop[i] = Integer.parseInt(temp[i]);
        setOper(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void setOper(int operN, int result){ // 사용한 숫자들의 수, 지금까지 만든 결과
        if(operN == Nofn){ // 숫자 다 사용
           if(result > max)
            max = result;
        if(result < min)
            min = result;
         return;   
        }
        for(int i = 0; i < 4; i++)
            if(Nofop[i] != 0){
                 Nofop[i]--;
                 if(i == 0){
               setOper(operN+1, result + numbers[operN]);
                 }
                if(i == 1)
                 setOper(operN+1, result - numbers[operN]);
                if(i == 2)
               setOper(operN+1, result * numbers[operN]);
                 if(i == 3)
                if(result < 0)
                setOper(operN+1, -(Math.abs(result)/numbers[operN]));
                else
                 setOper(operN+1, result / numbers[operN]);
                Nofop[i]++;
            }
    }
}
