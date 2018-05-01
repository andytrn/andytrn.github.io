package card.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import card.exception.GeneratorException;

/**
 * A credit card number generator factory.
 * 
 * @author atran
 *
 */
@Component
public class CardGeneratorFactory {
	
	@Autowired
	private VisaGenerator visaGenerator;
	
	@Autowired
	private MasterCardGenerator masterCardGenerator;
	
	@Autowired
	private AmericanExpressGenerator americanExpressGenerator;
	
	/**
	 * Returns the card generator object for the given card type.
	 * 
	 * @param type The card type.
	 * @return The card generator oject.
	 * @throws GeneratorException
	 */
	public ICardGenerator get(CardType type) throws GeneratorException {
		
		switch (type) {
			
			case VI:
				
				return visaGenerator;
				
			case MA:
				
				return masterCardGenerator;
				
			case AM:
				
				return americanExpressGenerator;
			
			default:
				
				throw new GeneratorException("Unknown card type!");
				
		} //switch
		
	}
	
	/**
	 * Supported card types.
	 * 
	 * @author atran
	 *
	 */
	public enum CardType {
		
		VI,
		MA,
		AM;
		
	}
}
