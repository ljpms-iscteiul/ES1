package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AutomaticWeigthVector {
	public HashMap<Double, Double> results =  new HashMap<Double, Double>();
	public Double[] fn_fp = new Double[2];
	public static void main(String[] args) {
		new AutomaticWeigthVector().loadResults();
	}
	public void loadResults(){
		File data = new File("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rf");

		try {
			Scanner scan = new Scanner(data);
			int bestLine = 0;
			double best = 500;
			int i= 0;

			// reading file lines one at a time
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String[] splitted = line.split(" ");
				results.put(	Double.valueOf(splitted[0]), Double.valueOf(splitted[1]));
				double sum = Double.valueOf(splitted[0]) +  Double.valueOf(splitted[1]);
				if( best > sum) {
					best = sum;
					bestLine = i;
					fn_fp[0] = Double.valueOf(splitted[0]);
					fn_fp[1] = Double.valueOf(splitted[1]);
				}
				i++;
			}

			loadBestVector(bestLine);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Problems initializing scanner loadResults");
		} 
	}
	
	ArrayList<Double> pesos;
	
	private void loadBestVector(int bestLine) {
		File data = new File("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rs");

		try {
			Scanner scan = new Scanner(data);
			pesos = new ArrayList<Double>();

			// reading file lines one at a time
			int e = 0;
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				if(e == bestLine) {
					String[] splitted = line.split(" ");
					for(int i = 0; i< splitted.length-1; i++) {
						pesos.add(Double.valueOf(splitted[i]));
						
					}
					break;
				}
				e++;
			}
//			System.out.println(bestLine + " " + pesos);
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Problems initializing scanner loadBestVector");
		} 

	}
	public HashMap<Double, Double> getResults() {
		return results;
	}
	public Double[] getFNAndFP() {
		return fn_fp;
	}
	public ArrayList<Double> getBestVector() {
		System.out.println(pesos.size());
		return pesos;
	}

	
	

}
