package card;

import org.springframework.stereotype.Component;

import card.exception.ValidationException;

/**
 * A Luhn (Mod10) algorithm validator.
 * 
 * @author atran
 *
 */
@Component
public class LuhnValidator {
	
	/**
	 * Validate the value against Luhn algorithm.
	 * 
	 * @param value The value to be validated.
	 * @return True if the value is valid, false otherwise.
	 */
	public boolean validate(String value) throws ValidationException {
		
		//Nothing to validate?
		if (value == null || value.isEmpty()) {
			
			throw new ValidationException("Invalid input value!");
			
		} //if
		
		//Split string to array with no empty value
		String[] numbers = value.split("(?!^)");
		int sum = 0;
		
		for (int i = numbers.length; i > 0; i--) {
			
			int digit = Integer.valueOf(numbers[i-1]);
			
			//Not an alternate digit, just add to sum
			if ((i % 2) != 0) {
				
				sum += digit;
				
			} else {
				
				//Alternate digit, double then, if value is 10 or more
				//add digits together ( ~ -9 ) then add to sum
				int twice = digit * 2;
				sum += (twice > 9) ? (twice - 9) : twice;
				
			} //if
			
		} //for
		
		//Mod10 check
		if ((sum % 10) != 0) {
			
			return false;
			
		} //if
		
		return true;
		
	} //validate
	
}
