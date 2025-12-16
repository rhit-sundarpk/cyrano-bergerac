
//parth class
public class Order {
	private String email;
	private String sweetheart;
	private long creditcard;
	private String song;
	private boolean completed;
	private int key;

	public Order(String email, String sweetheart, String song, long creditcard, int key) {
		this.email = email;
		this.creditcard = (creditcard * 2) + key; // this is like the encryption process to prevent system from leaking
													// card value
		this.sweetheart = sweetheart;
		this.song = song;
		this.completed = false;
		this.key = key;

	}

	//return the song receiver name
	public String getSweetheart() {
		return this.sweetheart;

	}

	//returns email string
	public String getEmail() {
		return this.email;
	}

	//returns decrypted cc number
	public long getCard() {
		return (this.creditcard - this.key) / 2;// decryption, it's a simple way to show it's a part of order
	}

	//returns song name from order
	public String getSong() {
		return this.song;
	}

	//marks order as complete
	public void markCompleted() {
		this.completed = true;
	}

	//sends whether song is completed or not
	public boolean getCompleted() {
		return this.completed;
	}

}
