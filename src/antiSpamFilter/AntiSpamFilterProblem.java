package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import functionals.HamSpamReader;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {

	
	public HashMap<String, Double> rules;
	
	  public AntiSpamFilterProblem() {
	    this(335);
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
	  

	  
	  public void evaluate(DoubleSolution solution){
	    double aux, xi, xj;
	    aux=5.0;
	    
	    double[] fx = new double[getNumberOfObjectives()];
	    
	    double[] x = new double[getNumberOfVariables()];
	    
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) { // CORRE O VETOR (SOLUTION)
	    		x[i] = solution.getVariableValue(i) ;
	    }
	    
	    loadRules(x);
	    HamSpamReader h = new HamSpamReader();
	    fx[0] = h.weigthCalculator("ham.log", rules);
	    fx[1] = h.weigthCalculator("spam.log", rules);
		
	    solution.setObjective(0, fx[0]);
	    solution.setObjective(1, fx[1]);
	
	  }
	  private void loadRules(double[] x){
			rules = new HashMap<String,Double>();
			File data = new File("rules.cf");
			try {
				Scanner scan = new Scanner(data);
				// reading file lines one at a time
				int i = 0;
				while(scan.hasNextLine()){
					String line = scan.nextLine();
					String[] splitted = line.split(",");
//					System.out.println(splitted.length);
					rules.put(splitted[0], Double.valueOf(x[i]));
					i++;
				}
			} catch (FileNotFoundException e) {
				System.out.println("Problems initializing scanner");
			} 
			
	  }
}