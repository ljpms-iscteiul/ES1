package functionals;

import java.util.HashMap;

import graphics.MainInterface;


public class ManualConfigurationFilter {
	
	public static void main(String[] args) {
		HamSpamReader calculator= new HamSpamReader();
		double[] ham= calculator.WeigthCalculator("ham.log");
		System.out.println("vai o spam");
		double[] sam= calculator.WeigthCalculator("spam.log");
		System.out.println("acabou spam");
		
	}
	
	
	
	
}
