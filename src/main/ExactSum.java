package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ExactSum {

	public static void main(String[] args) throws IOException {
		//Entries are added through a file as the problem says
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready()){
			int numBook=Integer.parseInt(br.readLine());
			int price=0;
			
			ArrayList<Integer>pricesBooks= new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<numBook; i++) {
				price=Integer.parseInt(st.nextToken());
				pricesBooks.add(price);	
			}
			
			int totalMoney= Integer.parseInt(br.readLine());
			
			String outp=binsearch(pricesBooks,totalMoney);
			out.append(outp);
			br.readLine();
		}
		out.flush();
	}
	
		public static String binsearch(ArrayList<Integer> arr, int totalMoney ) {

			Collections.sort(arr);
			
				int totalMoneyMid=totalMoney/2;
				int goal=0;
				int difference=Integer.MAX_VALUE;
				int bestPrice1=0;
				int bestPrice2=0;
				
				
				for(int i=0;arr.get(i)<=totalMoneyMid;i++) {
					boolean wasFound=false;
					int inicio=0;
					int fin=arr.size()-1;
					int found=0;
					goal=totalMoney-arr.get(i);
	
					while(inicio<=fin) {
						int pMedio=(inicio+fin)/2;
						int valuePMedio=arr.get(pMedio);
						if (valuePMedio==goal) {
							found= pMedio;
							wasFound=true;
							break;
							
						}else if(valuePMedio>goal){
							fin=pMedio-1;
							
						}else if(valuePMedio<goal) {
							inicio=pMedio+1;	
						}
						
					}
					
					if(arr.get(found)-arr.get(i)<difference &&  wasFound==true) {
						difference=arr.get(found)-arr.get(i);
						bestPrice1=arr.get(found);
						bestPrice2=arr.get(i);
						
					}
				}
				
			String msj=("Peter should buy books whose prices are "+bestPrice2+ " and "+bestPrice1+".\n\n");	
			return msj;
		}
		
}
