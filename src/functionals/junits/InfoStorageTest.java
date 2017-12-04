package functionals.junits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import functionals.InfoStorage;

class InfoStorageTest {

	@Test
	final void testLoadRules() {
		InfoStorage is = new InfoStorage();

		is.loadRules("nao_existe.cf");
		
		is.loadRules("rules.cf");
		
		assertNotNull(is.getRules());
	}

}
