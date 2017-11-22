package functionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineCounter {

	

	
 	public int LineCounterFunction(String filename){
 		
		File data = new File(filename);
			
		//Este vetorvai ter os pesos de cada linha calculado
		int linhas = 0;
		
		try {
 			
			Scanner scan = new Scanner(data);
			// reading file lines one at a time
			
			while(scan.hasNextLine()){
				
				
				String line = scan.nextLine();
				linhas++;
				}
				System.out.println("Scanner closed");
				scan.close();
			}catch (FileNotFoundException e) {
			System.out.println("Problems initializing scanner");
		} 
		System.out.println("Entrou no final");
		return linhas;
		
	}
	
}
