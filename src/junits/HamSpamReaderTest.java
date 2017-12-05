package junits;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import functionals.HamSpamReader;

public class HamSpamReaderTest {

	@Test
	final void testWeigthCalculator() {
		HamSpamReader hsr = new HamSpamReader();
		HashMap<String, Double> rules = new HashMap<String, Double>();
		rules.put("BAYES_00",0.0);
		hsr.weigthCalculator("ham.log", rules);
		hsr.weigthCalculator("nao_existe.log", rules);
	}

	@Test
	final void verificaFPFN() {
		HamSpamReader hsr = new HamSpamReader();
		hsr.verificaFPFN("spam.log", 6);
		hsr.verificaFPFN("spam.log", 0);
		hsr.verificaFPFN("spam.log", -6);
		
		hsr.verificaFPFN("ham.log", 6);
		hsr.verificaFPFN("ham.log", 0);
		hsr.verificaFPFN("ham.log", -6);


	}
	
	@Test
	final void calculoPerc() {
		HamSpamReader hsr = new HamSpamReader();

		hsr.calculoPerc("spam.log"); // FN = 0
		hsr.verificaFPFN("spam.log", 0);
		hsr.calculoPerc("spam.log"); // FN != 0
		
		
		hsr.calculoPerc("ham.log"); // FP = 0
		hsr.verificaFPFN("ham.log", 6);
		hsr.calculoPerc("ham.log"); // FN != 0
	}
	
}
