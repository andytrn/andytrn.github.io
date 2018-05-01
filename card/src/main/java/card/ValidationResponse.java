package card;

/**
 * A model for the validation response.
 * 
 * @author atran
 *
 */
public class ValidationResponse {
	
	private String status;
	private String message;
	
	/**
	 * Constructor.
	 * 
	 * @param message
	 */
	public ValidationResponse(String status, String message) {
		
		this.status = status;
		this.message = message;
		
	}
	
	/**
	 * Returns the status of the request.
	 * 
	 * @return
	 */
	public String getStatus() {
		
		return status;
		
	}
	
	/**
	 * Returns the error message if set, or null.
	 * 
	 * @return
	 */
	public String getMessage() {
		
		return message;
		
	}
	
}
