package functionals;

public class ManualConfigurationFilter {
	
	public static void main(String[] args) {
		
		
		
	}
	
	public int CalculoFalsosPositivos(){
		
		HamSpamReader calculator= new HamSpamReader();
		double[] ham= calculator.WeigthCalculator("ham.log");
		int falsospositivos = 0;
		
		for(int i=0;ham.length<i;i++) {
			if(ham[i]<5)
			falsospositivos++;
			
		}
		
		return falsospositivos;
	}
	
	public int CalculoFalsosNegativos(){
		
		HamSpamReader calculator= new HamSpamReader();
		double[] ham= calculator.WeigthCalculator("spam.log");
		int falsosnegativos = 0;
		
		for(int i=0;ham.length<i;i++) {
			if(ham[i]>5)
			falsosnegativos++;
			
		}
		
		return falsosnegativos;
		
		
	}
	
	public double falsospositivospercent() {
		LineCounter counter= new LineCounter();
		int totallinhas= counter.LineCounterFunction("ham.log");

		double falsospositivos= CalculoFalsosPositivos()/totallinhas;
		return falsospositivos;
		
	}
	public double falsosnegativospercent() {
		LineCounter counter= new LineCounter();
		int totallinhas= counter.LineCounterFunction("spam.log");
		
		double falsosnegativos= CalculoFalsosNegativos()/totallinhas;
		return falsosnegativos;
		
	}
	
}
