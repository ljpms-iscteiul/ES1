package functionals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
/**
 * Classe para fazer o uploud rules das regras para um ficheiro
 */
public class WeightUploader {
	/**
	 * Faz upload das regras rules d para o ficheiro na diretoria dir 
	 * @param rules  Hasmap das regras
	 * @param dir Diretoria do ficheiro
	 */
	public void update(HashMap <String,Double> rules, String dir){ 
		String allfile = "";
		for(HashMap.Entry<String,Double> entry: rules.entrySet()) {
			String line = entry.getKey() + "," + entry.getValue();
			allfile += line + "\n";
		}	
		try {
			int i = 1;
			File rulesCF = null;
			boolean done = false;

			while(!done) {
				rulesCF = new File(dir + "/rules_"+i+".cf");
				if(!(rulesCF.exists())) {
					System.out.println("rules saved in rules_"+ i + ".cf");
					rulesCF.createNewFile();
					done = true;
				}
				i++;
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(rulesCF, false));
			writer.write(allfile);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
