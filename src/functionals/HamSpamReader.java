package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HamSpamReader {
	
//	public void Main( String [] Args) {
//		HamSpamReader novo= new HamSpamReader();
//		
//	}

	public HamSpamReader(HashMap<String, Double> rules) {
	this.rules=rules;
	}

	//criar uma nova storage para poder obter os valores dos pesos
	private HashMap<String,Double> rules;
	public int FP = 0;
	public int FN = 0;
	public int spam = 0;
	public int ham = 0;
	public ArrayList<Integer> results = new ArrayList<Integer>();
	

	
 	public ArrayList<Integer> WeigthCalculator(String filename){
 		
		File data = new File(filename);
			
		//Este vetorvai ter os pesos de cada linha calculado
		double[] calculatedweigths = new double [1000]  ;
		HashMap<String,Double> rulestmp=this.rules;
		
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
						System.out.println(total);
					}
				}
					
				verificaFPFN(filename, total);

				calculatedweigths[i]=total;
				System.out.println(calculatedweigths[i]);
				i++;
				
				}
				System.out.println("Scanner closed");
				scan.close();
			}catch (FileNotFoundException e) {
			System.out.println("das");
		} 
		results.add(FP);
		results.add(FN);
		results.add(spam);
		results.add(ham);
		results.add(calculoPerc("FP"));
		results.add(calculoPerc("FN"));

		System.out.println(results);
	return results;
		
	}

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
	private int calculoPerc(String a) {
	if(a=="FP") {
		if( FP==0) 
		return 0;
		else return ((FP/(FP+ham))*100);
	}	
	else {
		if(FN==0) 
			return 0;
		else return ((FN/(FN+ham))*100);
	}
	}
	
	public ArrayList<Integer> getResults() {
		return results;
	}
	
}
