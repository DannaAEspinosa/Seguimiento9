package main;

import java.util.ArrayList;
import java.util.Scanner;

public class NewYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> minutesProblems = new ArrayList<Integer>();
		System.out.println("Ingrese el numero de problemas");
		int n = sc.nextInt();
		System.out.println("Ingrese el numero de minutos");
		int k = sc.nextInt();
		minutesProblems.add(5);
		minutesProblems.add(15);
		minutesProblems.add(30);
		minutesProblems.add(50);
		minutesProblems.add(75);
		minutesProblems.add(105);
		minutesProblems.add(140);
		minutesProblems.add(180);
		minutesProblems.add(225);
		minutesProblems.add(275);

		//System.out.println(minutesProblems);
		int minutesForFourHours = 240;

		int rest = minutesForFourHours - k;
		//System.out.println(rest);

		int sum = 0;
		int sum2 = 0;
		int x = 0;
		int totalsum = 0;
		boolean flag = false;
		do {

			sum = +x * 5;

			if (sum > rest) {
				sum = +(x - 1) * 5;
				flag = true;
			}

			x++;
		} while (flag == false);
		//System.out.println(sum);

		if (minutesProblems.get(n) <= rest) {
			System.out.println(n);
			
		} else {

			System.out.println((binSearch(minutesProblems, sum) + 1));
		}
	}

	public static int binSearch(ArrayList<Integer> arr, int goal) {
		// Collections.sort(arr);

		int inicio = 0;
		int fin = arr.size() - 1;

		while (inicio <= fin) {
			int pMedio = (inicio + fin) / 2;
			int valuePMedio = arr.get(pMedio);

			if (valuePMedio == goal) {
				return pMedio;

			} else if (valuePMedio > goal) {
				fin = pMedio - 1;

			} else if (valuePMedio < goal) {
				inicio = pMedio + 1;

			}
		}
		return -1;

	}

}
