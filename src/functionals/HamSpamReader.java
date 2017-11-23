package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HamSpamReader {
	//criar uma nova storage para poder obter os valores dos pesos
	public int FP;
	public int FN;
	public int spam;
	public int ham;	
 	public int WeigthCalculator(String filename, HashMap<String, Double> rules){
 		FP=0;
 		FN=0;
 		spam=0;
 		ham=0;
		File data = new File(filename);
			
		//Este vetorvai ter os pesos de cada linha calculado
		double[] calculatedweigths = new double [1000]  ;
		HashMap<String,Double> rulestmp=rules;
	
		try {
			Scanner scan = new Scanner(data);
			int i=0;
			while(scan.hasNextLine()){
				
				String line = scan.nextLine();
				String[] splitted = line.split("	");
				
				double total=0.0;
				
				for(int i2=0; i2<splitted.length; i2++) {
					if(i2 != 0) {
						
						if(rulestmp.get(splitted[i2])!=null) {
						total=total +rulestmp.get(splitted[i2]);
						}
//						System.out.println(total);
					}
				}
					
				verificaFPFN(filename, total);

				calculatedweigths[i]=total;
//				System.out.println(calculatedweigths[i]);
				i++;
				
				}
				System.out.println("Scanner closed");
				scan.close();
			}catch (FileNotFoundException e) {
			System.out.println("das");
		} 

		System.out.println("ham:" + ham + "   FP:" + FP + "    Percentagem FP:" + calculoPerc("ham.log")  );
		System.out.println("spam:" + spam + "   FN:" + FN + "    Percentagem FN:" + calculoPerc("spam.log")  );
	return calculoPerc(filename) ;
		
	}
//verifica Se é FP e PN e conta
	private void verificaFPFN(String filename, double total) {
		if(filename=="spam.log" && total<=5) {
			System.out.println("FN");
			FN+=1;
		}
		if(filename=="spam.log" && total>5) {
			System.out.println("SPAM");
			spam+=1;
		}
		if(filename=="ham.log" && total>5) {
			System.out.println("FP");
			FP+=1;
		}
		if(filename=="ham.log" && total<=5) {
			System.out.println("HAM");
			ham+=1;
		}
	}
	//Calculo da Percentagem
	private int calculoPerc(String a) {
	if(a=="spam.log") {
		if( FN==0) 
		return 0;
		else {

			return (int) Math.round((double)FN/(FN+spam)*100);
		}
		
	}	
	else {
		if(FP==0) 
			return 0;
		else return (int) Math.round((double)FP/(FP+ham)*100);
	}
	}
}
