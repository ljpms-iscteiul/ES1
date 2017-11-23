//package functionals;
//
//public class ManualConfigurationFilter {
//	
//	public static void main(String[] args) {
//		
//		ManualConfigurationFilter novo= new ManualConfigurationFilter();
//		double fp= novo.falsospositivospercent();
////		System.out.println("Este é o fp"+ fp);
//		//double fn = novo.falsosnegativospercent();
//		//System.out.println("Este é o fn"+fn);
//		
//	}
//	
//	//falsos positivos é quando no ficheiro 
//	
//	public int CalculoFalsosPositivos(){
//		
//		HamSpamReader calculator= new HamSpamReader();
//		double[] spam= calculator.WeigthCalculator("ham.log");
//		int falsospositivos = 0;
//		
//		for(int i=0;spam.length<i;i++) {
//			if(spam[i]<5)
////			System.out.println(falsospositivos);	
//			falsospositivos++;
//			
//		}
////		System.out.println("Este é o numero de falsos positivos "+ falsospositivos);
//		return falsospositivos;
//	}
//	
//	public double falsospositivospercent() {
//		LineCounter counter= new LineCounter();
//		int totallinhas= counter.LineCounterFunction("ham.log");
////		System.out.println(totallinhas);
//		double falsospositivos= CalculoFalsosPositivos()/totallinhas;
//		return falsospositivos;
//		
//	}
//	
//	public int CalculoFalsosNegativos(){
//		
//		HamSpamReader calculator= new HamSpamReader();
//		double[] ham= calculator.WeigthCalculator("spam.log");
//		int falsosnegativos = 0;
//		
//		for(int i=0;ham.length<i;i++) {
//			if(ham[i]>5)
//			falsosnegativos++;
//			
//		}
////		System.out.println("Este é o numero de falsos negativos "+ falsosnegativos);
//		return falsosnegativos;
//		
//		
//	}
//	
//	public double falsosnegativospercent() {
//		LineCounter counter= new LineCounter();
//		int totallinhas= counter.LineCounterFunction("spam.log");
//		System.out.println(totallinhas);
//		double falsosnegativos= CalculoFalsosNegativos()/totallinhas;
//		return falsosnegativos;
//		
//	}
//	
//}
