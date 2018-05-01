package card;

/**
 * A model for the card response.
 * 
 * @author atran
 *
 */
public class CardResponse {
	
	private String status;
	private String message;
	private String value;
	
	/**
	 * Constructor.
	 * 
	 * @param message
	 */
	public CardResponse(String status, String message, String value) {
		
		this.status = status;
		this.message = message;
		this.value = value;
		
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
	
	/**
	 * Returns the value of the card.
	 * 
	 * @return
	 */
	public String getValue() {
		
		return value;
		
	}
	
}
