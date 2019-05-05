package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg9654 {
	public static void main(String[] args) throws IOException{
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		// string.format 이용
		bw.write("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n");
		bw.write(String.format("N2 Bomber      Heavy Fighter  Limited    %-10s\n", "21"));
		bw.write(String.format("J-Type 327     Light Combat   Unlimited  %-10s\n", "1"));
		bw.write(String.format("NX Cruiser     Medium Fighter Limited    %-10s\n", "18"));
		bw.write(String.format("N1 Starfighter Medium Fighter Unlimited  %-10s\n", "25"));
		bw.write(String.format("Royal Cruiser  Light Combat   Limited    %-10s\n", "4"));
		bw.close();
	}
}
