package functionals.junits;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AutomaticWeigthVectorTest.class,
	InfoStorageTest.class
	})
public class AllTests {}
