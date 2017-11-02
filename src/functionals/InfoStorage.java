package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.TreeMap;

import javax.print.attribute.standard.PrinterLocation;

import org.apache.commons.io.FileUtils;

public class InfoStorage {
	
	private TreeMap<String,Double> rules;
	
	private void loadAll(){
		loadRules();
		loadLogs();
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
	
	// function to copy de ham.log and spam.log from OriginalLogs to project src
	private void loadLogs(){
		File src = new File("");
		File originalHam = new File("OriginalLogs/ham.log");
		File originalSpam = new File("OriginalLogs/spam.log");
		
		File newHam = new File("ham.log");
		File newSpam = new File("spam.log");

		try {
			FileUtils.copyFile(originalHam, newHam);
			FileUtils.copyFile(originalSpam, newSpam);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
