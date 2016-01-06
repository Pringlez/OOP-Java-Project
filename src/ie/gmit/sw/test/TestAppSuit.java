package ie.gmit.sw.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestParse.class,
	TestImageGenerator.class,
	TestPositionGenerator.class,
	TestColourFactory.class,
	TestConfigurable.class
})

public class TestAppSuit {

	public TestAppSuit() {
	}

}