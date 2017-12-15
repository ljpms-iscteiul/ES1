package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//classe com ferramentas de carregamento do melhor vetor
public class AutomaticWeigthVector {
	public Double[] fn_fp = new Double[2];
	public ArrayList<Double> pesos;
	/**
	 * Carrega os resultados fp e fn
	 * @param filename Nome do ficheiro
	 */
	public void loadResults(String filename){
		File data = new File(filename); // filename -> "experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rf"

		try {
			Scanner scan = new Scanner(data);
			int bestLine = 0;
			double best = 500;
			int i= 0;
			// reading file lines one at a time
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String[] splitted = line.split(" ");
				//soma os valores para comparar 
				double sum = Double.valueOf(splitted[0]) +  Double.valueOf(splitted[1]);
				if( best > sum) {
					best = sum;
					bestLine = i;
					fn_fp[0] = Double.valueOf(splitted[0]);
					fn_fp[1] = Double.valueOf(splitted[1]);
				}
				i++;
			}

			loadBestVector(bestLine,"experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rs");

		} catch (FileNotFoundException e) {
			System.out.println("Problems initializing scanner loadResults");
		} 
	}
	/**
	 * Carrega o melhor vetor de resultados	
	 * @param bestLine A linha do melhor resultado
	 * @param filename Nome do ficheiro
	 */
	public void loadBestVector(int bestLine, String filename) {
		File data = new File(filename); // filename -> "experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rs"
		try {
			Scanner scan = new Scanner(data);
			pesos = new ArrayList<Double>();
			int e = 0;
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				if(e == bestLine) {
					String[] splitted = line.split(" ");
					//carrega os pesos do ficheiro filename para a Arraylist pesos
					for(int i = 0; i< splitted.length-1; i++) {
						pesos.add(Double.valueOf(splitted[i]));
					}
					break;
				}
				e++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problems initializing scanner loadBestVector");
		} 
	}
	/**
	 * Retorna o numero de FN e FP
	 * @return Vetor Double com fp e fn
	 */
	public Double[] getFNAndFP() {
		return fn_fp;
	}

	/**
	 * Retorna o melhor vetor de pesos
	 * @return Arraylist com o vetor de pesos
	 */
	public ArrayList<Double> getBestVector() {
		return pesos;
	}

}
