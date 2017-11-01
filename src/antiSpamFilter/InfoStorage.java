package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

import javax.print.attribute.standard.PrinterLocation;

public class InfoStorage {
	
	private TreeMap<String,Double> rules;
	
	private void loadAll(){
		
		loadHams();
		loadSpams();
		loadRules();
	}
	
	/* function to get info from ham.log */
	private void loadHams(){
		//TODO
	}
	
	/* function to get info from spam.log */
	private void loadSpams(){
		//TODO
	}
	
	/* function to get info from rules.cf */
	private void loadRules(){
		rules = new TreeMap<String,Double>();
		File data = new File("rules.cf");
		try {
			Scanner scan = new Scanner(data);
			
			// reading file lines one at a time
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				
				// initiating all the rules with minimum weight
				rules.put(line.trim(), 0.0);

				System.out.println("just added " + line.trim());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Problems initializing scanner");
		} 
		
		
		
	}
	
	public TreeMap<String, Double> getRules(){
		return rules;
	}
	


	
	
	
	
	
	
	
	
	// for testing purposes
		public static void main(String[] args) {
			
			InfoStorage info = new InfoStorage();
			info.loadAll();
		}
}
