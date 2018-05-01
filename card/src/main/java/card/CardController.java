package card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import card.exception.GeneratorException;
import card.exception.ValidationException;
import card.generator.CardGeneratorFactory;
import card.generator.CardGeneratorFactory.CardType;

/**
 * A controller to generate card number for a given card type.
 * 
 * @author atran
 *
 */
@RestController
public class CardController {
	
	@Autowired
	private CardGeneratorFactory factory;
	
	/**
	 * Generates the card number for the given card type.
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping("/generate/{type}")
	public CardResponse generate(@PathVariable String type) {
		
		CardResponse response = null;
		
		try {
			
			String value = factory.get(CardType.valueOf(type)).generate();
			
			response = new CardResponse("success", null, value);
			
		} catch (GeneratorException | IllegalArgumentException e) {
			
			response = new CardResponse("failure", "Cannot generate card number. Unknown card type!", null);
			
		} catch (ValidationException e) {
			
			response = new CardResponse("failure", "Cannot generate card number!", null);
			
		} //try
		
		return response;
		
	} //validate
	
}
