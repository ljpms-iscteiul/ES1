package antiSpamFilter;

import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {

	
	public int FP;
	public int FN;
	public int spam;
	public int ham;
	public ArrayList<Integer> results;
	
	  public AntiSpamFilterProblem() {
	    // 10 variables (anti-spam filter rules) by default
		// numero de regras
	    this(50);
	  }

	  public AntiSpamFilterProblem(Integer numberOfVariables) {
	    setNumberOfVariables(numberOfVariables);
	    setNumberOfObjectives(2);
	    setName("AntiSpamFilterProblem");

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add(-5.0);
	      upperLimit.add(5.0);
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);
	  }
	  

	  
	  // o vetor solutions é o vetor que tem todos os pesos de todas as regras
	  public void evaluate(DoubleSolution solution){
	    double aux, xi, xj;
	    aux=5.0;
	    
	    int spam=this.spam;
	    int ham=this.ham;
	    int FN=this.FN;
	    int FP= this.FP;
	    
	  
	    System.out.println("Isto é sysout do solution" +  solution );
	    
	    
	    //fx é um vetor só com falsos positivos e negativos
	    double[] fx = new double[getNumberOfObjectives()];
	    
	    //x[] é o vetor com os valores do pesos das regras
	    double[] x = new double[getNumberOfVariables()];
	    
	    // solution.getNumberOfVariables() é o numero de linhas do spam ou ham
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) { // CORRE O VETOR (SOLUTION)
	    		//valor dos pesos das regras
	    		x[i] = solution.getVariableValue(i) ;
	    	
	    		
	    }

	    fx[0] = 0.0;
	    for (int var = 0; var < solution.getNumberOfVariables() - 1; var++) { // FALSOS POSITIVOS
		  //um if que vai somar os outputs do spam e dizer quais são ou não falsos positivo
	    	fx[0] += Math.abs(x[0]); // Example for testing
	    
	    	if(fx[0]<=5)
	    		FP++;
	    	else
	    		spam++;
	    		
	
	    }
	    
	    fx[1] = 0.0;
	    for (int var = 0; var < solution.getNumberOfVariables(); var++) { // FALSOS NEGATIVOS
	    	// //um if que vai somar os outputs do ham e dizer quais são ou não falsos negativos
	    	fx[1] += Math.abs(x[1]); // Example for testing
	    
	    	if(fx[0]>5)
	    		FN++;
	    	else
	    		ham++;
	    		
	
	    }
		System.out.println("Spam "+ spam);
		System.out.println("Ham "+ ham);
		System.out.println("FN "+ FN);
		System.out.println("FP "+ FP);
		
	    solution.setObjective(0, fx[0]);
	    solution.setObjective(1, fx[1]);
	  }
	  
	//Calculo da Percentagem
		private int calculoPerc(String a) {
		if(a=="spam.log") {
			if( FP==0) 
			return 0;
			else {

				return (int) Math.round((double)FP/(FP+spam)*100);
			}
			
		}	
		else {
			if(FN==0) 
				return 0;
			else return (int) Math.round((double)FN/(FN+ham)*100);
		}
		}
		
		public ArrayList<Integer> getResults() {
			results.add(spam);
			results.add(ham);
			results.add(FN);
			results.add(FN);
			
			return results;
			
		}
	  
	}