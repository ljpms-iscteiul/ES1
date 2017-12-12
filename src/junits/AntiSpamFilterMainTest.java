package junits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import antiSpamFilter.main.AntiSpamFilterMain;

class AntiSpamFilterMainTest {

	@Test
	final void test() {
		new AntiSpamFilterMain().main(null);;
	}

}
