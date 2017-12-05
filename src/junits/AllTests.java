package junits;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junits.functionals.*;;

@RunWith(Suite.class)
@SuiteClasses({
	AutomaticWeigthVectorTest.class,
	InfoStorageTest.class,
	WeightUploaderTest.class,
	HamSpamReaderTest.class
	
	
	
	
	
	})
public class AllTests {}
