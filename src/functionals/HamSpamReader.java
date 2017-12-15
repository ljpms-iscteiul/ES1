package functionals;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Classe que trata os resultados
 */
public class HamSpamReader {
	//criar uma nova storage para poder obter os valores dos pesos
	public int FP;
	public int FN;
	public int spam;
	public int ham;	
	/**
	 * Calcula o peso de cada mail e chama a função verificaFPFN para verificar se é FP/FN/SPAM/HAM
	 * @param filename Nome do ficheiro
	 * @param rules Hashmap das regras
	 * @return Retorna a percentagem de fp/fn tendo em conta o filename
	 */
	public int weigthCalculator(String filename, HashMap<String, Double> rules){
		FP=0;
		FN=0;
		spam=0;
		ham=0;
		File data = new File(filename);
		//Este vetor vai ter os pesos de cada linha calculado
		double[] calculatedweigths = new double [1000]  ;
		HashMap<String,Double> rulestmp=rules;
		try {
			Scanner scan = new Scanner(data);
			int i=0;
			while(scan.hasNextLine()){

				String line = scan.nextLine();
				String[] splitted = line.split("	");

				double total=0.0;
				// Soma os valores de cada linha 
				for(int i2=0; i2<splitted.length; i2++) {
					if(i2 != 0) {

						if(rulestmp.get(splitted[i2])!=null) {
							total=total +rulestmp.get(splitted[i2]);
						}
					}
				}
				
				verificaFPFN(filename, total);
				calculatedweigths[i]=total;
				i++;
			}
			scan.close();
		}catch (FileNotFoundException e) {
		} 
		return calculoPerc(filename) ;
	}

	/**
	 * Verifica se é FP e PN e conta
	 * @param filename Nome do ficheiro
	 * @param total - Peso do mail
	 */
	public void verificaFPFN(String filename, double total) {
		if(filename=="spam.log" && total<=5) {
			FN+=1;
		}
		if(filename=="spam.log" && total>5) {
			spam+=1;
		}
		if(filename=="ham.log" && total>5) {
			FP+=1;
		}
		if(filename=="ham.log" && total<=5) {
			ham+=1;
		}
	}

	/**
	 * Verifica se é FP e PN e conta
	 * @param filename Nome do ficheiro
	 * @return Retorna a percentagem
	 */
	public int calculoPerc(String filename) {
		if(filename=="spam.log") {
			if( FN==0) 
				return 0;
			else {
				return (int) Math.round((double)FN/(FN+spam)*100);
			}
		}	
		else {
			if(FP==0) 
				return 0;
			else return (int) Math.round((double)FP/(FP+ham)*100);
		}
	}
}
