package main;

import java.util.Arrays;
import java.util.Scanner;
//Diana Balanta
//Danna Espinosa
public class Gamer_Hermose {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] weapons = null;
		int health = 0;
		int numWeapon = 0;

		for (int i = 0; i < n; i++) {

			String gunsAndHealth = sc.nextLine();

			String[] separetedInformation = gunsAndHealth.split(" ");

			numWeapon = Integer.valueOf(separetedInformation[0]);

			health = Integer.valueOf(separetedInformation[1]);

		}

		String weaponsPoints = sc.nextLine();

		String[] separetedWeapons = weaponsPoints.split(" ");

		for (int x = 0; x < separetedWeapons.length; x++) {
			weapons = new int[numWeapon];
			weapons[x] = Integer.parseInt(separetedWeapons[x]);
			System.out.println(weapons[x]);
		}
		Arrays.sort(weapons);
		for (int x=0;x<weapons.length;x++) {
			System.out.println(weapons[x]);
		}
		int j = 0;
		int aux=binSearch(weapons, weapons[weapons.length-1]);
		int resta = health - (aux);
		System.out.println(resta);
		health=health-resta;
		if (resta>=0) {
			j=1;
		}

		for(int i=weapons.length-2;i>0;i--) {
			aux=binSearch(weapons, (weapons[i]));
			System.out.println("We  "+aux);
			if(aux!=-1) {
				j++;
				System.out.println(resta);
				System.out.println("Nv: "+j);
				resta=health-(resta+weapons[aux]);
				System.out.println("Resta: "+resta);
			}
			if(aux==weapons[weapons.length-1]) {
					
			}
			
		}
			
		
		
		
		
				
			
	}
	public static int binSearch(int[] arr, int goal) {


		int inicio = 0;
		int fin = arr.length - 1;

		while (inicio <= fin) {
			int pMedio = (inicio + fin) / 2;
			int valuePMedio = arr[pMedio];

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
