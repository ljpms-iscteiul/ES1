package junits.functionals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import functionals.AutomaticWeigthVector;

public class AutomaticWeigthVectorTest {

	@Test
	final void testLoadResults() {
		AutomaticWeigthVector awv = new AutomaticWeigthVector();
		awv.loadResults("nao_Existe.cf");

		awv.loadResults("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rf");
		
		assertNotNull(awv.getResults() != null);
		assertNotNull(awv.getFNAndFP() != null);
		assertNotNull(awv.getBestVector() != null);
		
	}

	@Test
	final void loadBestVector() {
		
		AutomaticWeigthVector awv = new AutomaticWeigthVector();
		awv.loadBestVector(100, "experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rs");
		awv.loadBestVector(0, "nao_existe.cf");
		awv.loadBestVector(0, "experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rs");
	}
	
}
