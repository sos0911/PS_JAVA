package programmers;
import java.io.*;
import java.util.*;
class repN {
	static ArrayList<LinkedList<Integer>> list;
    public static int solution(int N, int number) {
        list = new ArrayList<LinkedList<Integer>>(9);
		 for(int i=0;i<9;i++)
			 list.add(new LinkedList<Integer>());
		 list.get(1).add(N);
        String stN = String.valueOf(N);
		 if(N == number)
             return 1;
		 for(int i=2;i<9;i++){
			for(int j=1;j<i;j++){
				for(int one : list.get(j))
					for(int two : list.get(i-j)){
                        if(j <= i/2){
						if(one*two == number)
                            return i;
						list.get(i).add(one*two);
							if(one+two == number)
                            return i;
						list.get(i).add(one+two);
                        }
                        if(two != 0){
                        if(one/two == number)
                            return i;
						list.get(i).add(one/two);
                        }
							if(one-two == number)
                            return i;
						list.get(i).add(one-two);
					}
			}
             list.get(i).add(Integer.parseInt(stN += N));
		 }
        return -1;
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println(solution(sc.nextInt(), sc.nextInt()));
		for(int i=1;i<9;i++){
			for(int j : list.get(i))
				System.out.print(j + " ");
		System.out.println("");	
		}
	}
}