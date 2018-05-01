package card.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mifmif.common.regex.Generex;

import card.LuhnValidator;
import card.exception.ValidationException;

/**
 * An American Express card number generator.
 * 
 * @author atran
 *
 */
@Component
public class AmericanExpressGenerator implements ICardGenerator {
	
	public static final String REGEX = "3[47][0-9]{14}";
	
	@Autowired
	private LuhnValidator validator;
	
	/**
	 * @see card.generator.ICardGenerator#generate()
	 */
	public String generate() throws ValidationException {
		
		while (true) {
			
			String value = new Generex(REGEX).random();
			
			if (validator.validate(value)) {
				
				return value;
				
			} //if
			
		} //while
		
	} //generate
	
}
