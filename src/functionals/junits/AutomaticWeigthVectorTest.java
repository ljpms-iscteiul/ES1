package functionals.junits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import functionals.AutomaticWeigthVector;

class AutomaticWeigthVectorTest {

	@Test
	final void testLoadResults() {
		AutomaticWeigthVector awv = new AutomaticWeigthVector();
			
		awv.loadResults();
		
		assert(awv.getResults() != null);
		assert(awv.getFNAndFP() != null);
		assert(awv.getBestVector() != null);
		
	}

	@Test
	final void loadBestVector() {
		
		AutomaticWeigthVector awv = new AutomaticWeigthVector();

		assert(awv.getBestVector() != null);
	}
	
}
