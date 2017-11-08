package functionals;

import java.util.ArrayList;
import java.util.Random;

public class VectorFactory {
	
	
	/* don't know already if we will need a log, but this will save all the vectors since the start od program
	 * 
	 * So this will be an ArrayList that contains ArrayLists of Doubles
	 * 
	 */
	ArrayList<ArrayList<Double>> vectors = new ArrayList<ArrayList<Double>>();
	
	// adding vector to list	
	public void addVector(ArrayList<Double> v){
		vectors.add(v);
	}
	
	public void createVector(){
		Random r = new Random();
		ArrayList<Double> newVector = new ArrayList<Double>();
		// assuming the 335 rules
		for(int i = 0; i < 335; i++){
			// val from -5 to +5
			Double val = r.nextDouble()*10 -5;
			newVector.add(val);
		}
		vectors.add(newVector);
	}
	
	
	// for testing purposes
//	public static void main(String[] args) {
//		Random r = new Random();
//		for(int i = 0; i < 100; i++){
//			Double val = r.nextDouble()*10 -5;
//			System.out.println(val);
//		}
//	}
}
