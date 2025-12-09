
public class Order {
	private String email;
	private String sweetheart;
	private int creditcard;
	
	
	public Order(String email, String sweetheart, String song, int creditcard) {
		this.email= email;
		this.creditcard = creditcard;
		this.sweetheart = sweetheart;
		
	}
	
	public void markCompleted() {
		//Print out a list saying order complete - charge credit cards and send customers emails
	}
	
}
