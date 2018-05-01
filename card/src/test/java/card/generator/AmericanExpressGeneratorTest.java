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
public class AmericanExpressGeneratorTest {
	
	@Autowired
	private AmericanExpressGenerator generator;
	
	@Test
	public void testAmericanExpressCardNumberGenerator() throws Exception {
		
		String value = generator.generate();
		Assert.assertTrue(value.matches(AmericanExpressGenerator.REGEX));
		
	}
	
}
