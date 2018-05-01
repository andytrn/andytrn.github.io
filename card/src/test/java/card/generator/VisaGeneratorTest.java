package card.generator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import card.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class VisaGeneratorTest {
	
	@Autowired
	private VisaGenerator generator;
	
	@Test
	public void testVisaCardNumberGenerator() throws Exception {
		
		String value = generator.generate();
		Assert.assertTrue(value.matches(VisaGenerator.REGEX));
		
	}
	
}
