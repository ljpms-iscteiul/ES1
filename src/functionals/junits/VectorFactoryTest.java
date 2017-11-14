package functionals.junits;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import functionals.VectorFactory;

class VectorFactoryTest { // This is a file created to test creation and implementation of test files

	@Test
	final void testAddVector() {
		VectorFactory vecfact = new VectorFactory();
		ArrayList<Double> vector_335 = new ArrayList<Double>();
		ArrayList<Double> vector_100 = new ArrayList<Double>();

		while(vector_335.size()!=335) {
			vector_335.add(1.0);
		}
		
		while(vector_100.size()!=100) {
			vector_100.add(1.0);
		}
		
		vecfact.addVector(vector_335);
		vecfact.addVector(vector_100);
		
		assert(vecfact.getVectors().size()==1);
		assert(vecfact.getVectors().get(0).equals(vector_335));
	}

	@Test
	final void testCreateVector() {
		VectorFactory vecfact = new VectorFactory();
		vecfact.createVector();
		assertNotNull("", vecfact.getVectors().get(0));
	}


}
