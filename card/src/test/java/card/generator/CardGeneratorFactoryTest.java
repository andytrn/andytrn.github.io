package card.generator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import card.Application;
import card.generator.CardGeneratorFactory.CardType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CardGeneratorFactoryTest {
	
	@Autowired
	private CardGeneratorFactory factory;
	
	@Test
	public void testGenerateCardNumberByType() throws Exception {
		
		CardType type = CardType.VI;
		String value = factory.get(type).generate();
		Assert.assertTrue(value.matches(VisaGenerator.REGEX));
		
		type = CardType.MA;
		value = factory.get(type).generate();
		Assert.assertTrue(value.matches(MasterCardGenerator.REGEX));
		
		type = CardType.AM;
		value = factory.get(type).generate();
		Assert.assertTrue(value.matches(AmericanExpressGenerator.REGEX));
		
	}
	
}
