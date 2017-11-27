package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import javax.print.attribute.standard.PrinterLocation;

import org.apache.commons.io.FileUtils;

public class InfoStorage {
	
	public HashMap<String,Double> rules;
	
	public void loadAll(String filename){
		loadRules(filename);
		loadLogs();
	}


	/* function to get info from rules.cf */
	private void loadRules(String filename){
		rules = new HashMap<String,Double>();
		File data = new File(filename);
		try {
			Scanner scan = new Scanner(data);
			
			// reading file lines one at a time
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String[] splitted = line.split(",");
				System.out.println(splitted.length);
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
		
//		System.out.println(rules.keySet().size() + "-> keys");
//
//		System.out.println(rules.values().size() + "-> values");
		
		
	}
	
	// function to copy de ham.log and spam.log from OriginalLogs to project src
	private void loadLogs(){
//		File src = new File("");
//		File originalHam = new File("OriginalLogs/ham.log");
//		File originalSpam = new File("OriginalLogs/spam.log");
//		
//		File newHam = new File("ham.log");
//		File newSpam = new File("spam.log");
//
//		try {
//			FileUtils.copyFile(originalHam, newHam);
//			FileUtils.copyFile(originalSpam, newSpam);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	

	
	public HashMap<String, Double> getRules(){
		return rules;
	}
	


	
	
	
	
	
	
	
	
	// for testing purposes
//		public static void main(String[] args) {
//			
//			InfoStorage info = new InfoStorage();
//			info.loadAll();
//		}
}
