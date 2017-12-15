package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Classe com metodo para carregar as regras 
 */
public class InfoStorage {
	private  HashMap<String,Double> rules;
	/**
	 * Função que le as rechas do ficheiro rules.cf
	 * @param filename Nome do ficheiro
	 */
	public void loadRules(String filename){
		rules = new HashMap<String,Double>();
		File data = new File(filename);
		try {
			Scanner scan = new Scanner(data);
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String[] splitted = line.split(",");
				if(splitted.length == 1) {
					// initiating all the rules with minimum weights
					rules.put(splitted[0], 0.0);
				}else {
					rules.put(splitted[0], Double.valueOf(splitted[1]));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problems initializing scanner");
		} 

	}
	/**
	 * 
	 * @return Retorna o Hashmap com as regras
	 */
	public HashMap<String, Double> getRules(){
		return rules;
	}
}
