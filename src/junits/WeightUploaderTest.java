package junits;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import functionals.WeightUploader;

class WeightUploaderTest {

	@Test
	final void testUploadAll() {
		WeightUploader wul = new WeightUploader();
		HashMap<String,Double> rules = new HashMap<String,Double>();
		rules.put("a", 0.0);
		wul.update(rules,new File(System.getProperty("user.dir")).getAbsolutePath());
		wul.update(rules, "nao_existe");

	}

}
