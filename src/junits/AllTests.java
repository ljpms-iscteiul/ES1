package junits;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junits.functionals.*;
import junits.antiSpamFilter.*;
import junits.graphics.*;





@RunWith(Suite.class)
@SuiteClasses({
	AutomaticWeigthVectorTest.class,
	InfoStorageTest.class,
	WeightUploaderTest.class,
	HamSpamReaderTest.class,
	
	AntiSpamFilterProblemTest.class,
	
	MainInterfaceTest.class
	
	
	
	
	})
public class AllTests {}
