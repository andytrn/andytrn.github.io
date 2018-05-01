package card.generator;

import card.exception.ValidationException;

/**
 * An interface to represent a card number generator.
 * 
 * @author atran
 *
 */
public interface ICardGenerator {
	
	/**
	 * Generate the credit card number as a String.
	 * 
	 * @return The credit card number as a String.
	 */
	public String generate() throws ValidationException;
	
}
