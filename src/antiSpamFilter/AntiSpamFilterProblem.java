package antiSpamFilter;

import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {

	  public AntiSpamFilterProblem() {
	    // 10 variables (anti-spam filter rules) by default 
	    this(10);
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
	    //fx é um vetor só com falsos positivos e negativos
	    double[] fx = new double[getNumberOfObjectives()];
	    
	    //x[] é o vetor com os valores do pesos das regras
	    double[] x = new double[getNumberOfVariables()];
	    
	    // solution.getNumberOfVariables() é o numero de linhas do spam ou ham
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) { // CORRE O VETOR (SOLUTION)
	      x[i] = solution.getVariableValue(i) ;
	      System.out.println("Este e o peso x[" + i + "] = " + x[i]);
	    }

	    fx[0] = 0.0;
	    for (int var = 0; var < solution.getNumberOfVariables() - 1; var++) { // FALSOS POSITIVOS
		  //um if que vai somar os outputs do spam e dizer quais são ou não falsos positivos
	    	fx[0] += Math.abs(x[0]); // Example for testing
		  System.out.println("Este e o fx0 "+ fx[0]);
	    }
	    
	    fx[1] = 0.0;
	    for (int var = 0; var < solution.getNumberOfVariables(); var++) { // FALSOS NEGATIVOS
	    	// //um if que vai somar os outputs do ham e dizer quais são ou não falsos negativos
	    	fx[1] += Math.abs(x[1]); // Example for testing
	    	System.out.println("Este e o fx1 "+ fx[1]);
	    }

	    solution.setObjective(0, fx[0]);
	    solution.setObjective(1, fx[1]);
	  }
	}
