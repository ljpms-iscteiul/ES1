package junits;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.operator.MutationOperator;
import org.uma.jmetal.operator.impl.crossover.SBXCrossover;
import org.uma.jmetal.operator.impl.mutation.PolynomialMutation;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.DoubleSolution;

import antiSpamFilter.AntiSpamFilterProblem;

public class AntiSpamFilterProblemTest {

	@Test
	final void testAntiSpamFilterProblem() {
		AntiSpamFilterProblem asfp = new AntiSpamFilterProblem();
		
	}

	@Test
	final void testEvaluate() {
		// COMO TESTO ISTO !?!?!??!?! COMO CONTRUO UM DOUBLESOLUTION!?!?!??
		
		fail();
	}

}
