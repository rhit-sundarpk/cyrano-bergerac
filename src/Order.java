
public class Order {
	private String email;
	private String sweetheart;
	private long creditcard;
	private String song;
	private boolean completed;
	
	
	public Order(String email, String sweetheart, String song, long creditcard) {
		this.email= email;
		this.creditcard = creditcard;
		this.sweetheart = sweetheart;
		this.song = song;
		this.completed = false;
		
	}
	
	public String getSweetheart() {
		return this.sweetheart;
		
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public long getCard() {
		return this.creditcard;
	}
	
	public String getSong() {
		return this.song;
	}
	public void markCompleted() {
		this.completed = true;
	}
	
	public boolean getCompleted() {
		return this.completed;
	}
	
}
