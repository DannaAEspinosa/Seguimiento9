package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynomial {

	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		ArrayList<Long>results= new ArrayList<>();
		int numCases=sc.nextInt();
		for(int i=0; i<numCases; i++) {
			int A=sc.nextInt();
			int B=sc.nextInt();
			int C=sc.nextInt();
			long K=sc.nextLong();
			
			results.add((binsearch(A,B,C,K)));
		}
		
		for(Long r:results) {
			System.out.println(r);
		}
	}
	
	public static long binsearch(int a, int b, int c ,long goal) {
		
		long found=-1;
		if(c>=goal) {
			return 0;
		}

		long inicio=1;
		long fin=(int) Math.ceil(Math.sqrt(goal));
			
		while(inicio<=fin) {
			
			long pMedio=(inicio+fin)/2;
			
			long total=poly(a,b,c,pMedio);
			long lastMid=poly(a,b,c,pMedio-1);
			
			if (total>=goal && lastMid<goal) {
				found=pMedio;
				break;
				
			}else if(total<goal){
				inicio=pMedio+1;
				
			}else {
				fin=pMedio-1;
			}	
		}
		return found;	
	}
	
	public static long poly(int a, int b, int c, long x) {
		long result=(a*x*x)+(b*x)+c;
		return result;
	}
}