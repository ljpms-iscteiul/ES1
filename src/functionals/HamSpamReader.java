package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JTextField;

import graphics.MainInterface;

public class HamSpamReader {
	
	
	
	//criar os dois hasmaps que vão ter os pesos de cada linha dos ficheiros ham e spam
	private HashMap<String,Double> HamRules;
	private HashMap<String,Double> SpamRules;
	
	//criar uma nova storage para poder obter os valores dos pesos
	private InfoStorage info= new InfoStorage();
	private JTextField jtfchosenfilepath= MainInterface.getJtfchosenfilepath();
	private HashMap<String,Double> rules;
	
	//Ir buscar os pesos atuais do ficheiro
	
	public void getRulesWeigth() {
		// aqui leva    jtfchosenfilepath.getText()
		this.info.loadAll("/Users/carlossaraiva/git/ES1-2017-METIA1-45/rules.cf");
		this.rules=info.getRules();
	}
	
	
 	public double[] WeigthCalculator(String filename){
 		
		File data = new File(filename);
		//vai buscar os pesos das regras
		getRulesWeigth();
			
		//Este vetorvai ter os pesos de cada linha calculado
		double[] calculatedweigths = new double [1000]  ;
		HashMap<String,Double> rulestmp=this.rules;
		
		try {
			
		
 			
			Scanner scan = new Scanner(data);
			int i=0;
			int i3=0;
			
			// reading file lines one at a time
			while(scan.hasNextLine()){
				
				System.out.println(i3);
				String line = scan.nextLine();
				System.out.println(line);
				
				String[] splitted = line.split("	");
				
				System.out.println(splitted.length);
				
				double total=0.0;
				
				// este for vai correr as regras da linha do spam opu ham e vai calcular o total dos pesos adicionando-os num hasmap
				
				for(int i2=0; i2<splitted.length; i2++) {
					if(i2 != 0) {
						
						System.out.println(splitted[i2]);
						System.out.println(rulestmp.get(splitted[i2]));
						if(rulestmp.get(splitted[i2])!=null) {
						total=total +rulestmp.get(splitted[i2]);
						}
						System.out.println(total);
						
					}
				}
					
						
				calculatedweigths[i]=total;
				System.out.println(calculatedweigths);
				i++;
				i3++;
				
				}
				System.out.println("Scanner closed");
				scan.close();
			}catch (FileNotFoundException e) {
			System.out.println("Problems initializing scanner");
		} 
		System.out.println("Entrou no final");
		return calculatedweigths;
		
	}
	
}
