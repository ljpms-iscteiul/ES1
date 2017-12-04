package functionals.junits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import functionals.InfoStorage;

class InfoStorageTest {

	@Test
	final void testLoadRules() {
		InfoStorage is = new InfoStorage();
		assert(is.getRules() == null);

		is.loadRules("ad.txt");
// COMO SE APANHA EXCECAO?
		is.loadRules("rules.cf");
		assert(is.getRules() != null);
	}

}
