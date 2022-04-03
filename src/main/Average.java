package main;

import java.util.Arrays;
import java.util.Scanner;

public class Average {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int numArray=sc.nextInt();
		int numbers []= new int[numArray];
		for(int i=0; i<numArray; i++) {
			int number=sc.nextInt();
			numbers[i]=number;
		}
		sc.nextLine();
		int numCases=sc.nextInt();
		int cases[]= new int [numCases];
		for(int i=0; i<numCases; i++) {
			int casek=sc.nextInt();
			cases[i]=casek;
		}
		
		for(int i=0; i<numArray-1;i++) {
			numbers[i+1]+=numbers[i];
		}
		
		for(int i=0; i<numArray;i++) {
			numbers[i]/=i+1;
		}
		
		for(int i=0; i<cases.length;i++){
			System.out.println(binsearch(numbers,cases[i]));
		}
	}
	public static int binsearch(int arr[], int goal) {
		Arrays.sort(arr);
			
			int found=0;;
			int inicio=0;
			int fin=arr.length-1;
			
			while(inicio<=fin) {
				int pMedio=(inicio+fin)/2;
				int valuePMedio=arr[pMedio];
				
				if (valuePMedio<goal) {
					found=pMedio+1;
					inicio=pMedio+1;				
				}else {
					fin=pMedio-1;
				}
			}
			return found;
	}
	
}
