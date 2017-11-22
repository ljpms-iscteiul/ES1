package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import javax.sound.sampled.Line;

import org.apache.commons.io.FileUtils;

public class HamSpamReader {
	
	// testing purposes
	public static void main(String[] args) {
		HashMap<String,Double> rules = new HashMap<String,Double>();
		
	}
	//
	
	private HashMap<String,Double> rulesSaved;
	
	public HamSpamReader(HashMap<String,Double> rulesSaved) {
		this.rulesSaved = rulesSaved;
	}
	
	public void read(String filename){
		File file = new File("OriginalLogs/"+filename);
		int a = 0;
		try {
			Scanner scanner = new Scanner(file);
			String allfile = "";
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				allfile += line + "\n";
			}
			
			String allContent = allfile;
			
//			for(HashMap.Entry<String,Double> entry: rulesSaved.entrySet()) {
//			}
			
			System.out.println(allContent);		
			
			// writing new files
			
//			FileUtils.writeStringToFile(new File("test.txt"), "Hello File");			
	
		
		
		} catch (FileNotFoundException e) {
			System.out.println("problems reading " + filename);
			e.printStackTrace();
		}
	}
	
}
