package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class WeightUploader {

	public void uploadAll(TreeMap<String,Double> rules){
		//uploadHam(rules);
		uploadSpam(rules);
	}
	
	private void uploadSpam(TreeMap<String,Double> rules){
		File spam = new File("spam.log");
		try {
			spam.createNewFile();
		} catch (IOException e) {
			System.out.println("ERROR: CREATING HAM DATA FILE");
		}
		try {
			Scanner scan = new Scanner(spam);
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Problems initializing scanner");
		} 
	}
	
	// for testing purposes
//	public static void main(String[] args) {
//		new WeightUploader().uploadAll(null);;
//	}
}
