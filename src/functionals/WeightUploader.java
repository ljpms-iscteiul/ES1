package functionals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class WeightUploader {
	
	public void update(HashMap <String,Double> rules, String dir){ 
		
		String allfile = "";
		for(HashMap.Entry<String,Double> entry: rules.entrySet()) {
			String line = entry.getKey() + "," + entry.getValue();
			allfile += line + "\n";
		}	
		 
		
		try {
			
			int i = 1;
			File rulesCF;
			while(true) {
				
				rulesCF = new File(dir + "/rules_"+i+".cf");
				if(!(rulesCF.exists() && rulesCF.isFile())) {
					System.out.println("rules saved in rules_"+ i + ".cf");
					rulesCF.createNewFile();
					break;
				}
				i++;
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(rulesCF, false));
			writer.write(allfile);
			writer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("problems reading rules.cf [WeightUploader]");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// for testing purposes
//	public static void main(String[] args) {
//		new WeightUploader().uploadAll(null);;
//	}
}
