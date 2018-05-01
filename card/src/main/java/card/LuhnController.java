package card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import card.exception.ValidationException;

@RestController
public class LuhnController {
	
	@Autowired
	private LuhnValidator validator;
	
	@RequestMapping("/validate/{value}")
	public ValidationResponse validate(@PathVariable String value) {
		
		ValidationResponse response = null;
		
		try {
			
			boolean success = validator.validate(value);
			
			if (!success) {
				
				response = new ValidationResponse("failure", "Value does not match Luhn algorithm check!");
				
			} else {
				
				response = new ValidationResponse("success", null);
				
			} //if
			
		} catch (ValidationException e) {
			
			response = new ValidationResponse("failure", "Can not validate empty input!");
			
		} //try
		
		return response;
		
	} //validate
	
}
