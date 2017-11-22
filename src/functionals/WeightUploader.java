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
	
	public void update(HashMap <String,Double> rules){
		
		String allfile = "";
		for(HashMap.Entry<String,Double> entry: rules.entrySet()) {
			String line = entry.getKey() + "," + entry.getValue();
			allfile += line + "\n";
		}
			
		System.out.println(allfile);	
		
		try {
			
			File rulesCF = new File("rules.cf");
			rulesCF.delete();
			
			File newRulesCF = new File("rules.cf");
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(newRulesCF, true));
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
