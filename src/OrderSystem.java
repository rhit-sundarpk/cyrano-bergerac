import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
public class OrderSystem {
	private HashMap<String, Member> memberMap = new HashMap<String, Member>();
	private static Scanner sc = new Scanner(System.in);
	private ArrayList<String> songList = new ArrayList<String>();
	
	public void makeOrder(String email, String sweetheart, String song, int creditcard) {
		Member singer = memberMap.get(song);
		Order newOrder = new Order(email, sweetheart, song, creditcard);
		singer.assignOrder(newOrder);
		System.out.println("Order has been made");
	}
	
	private boolean songCheck(String song) {
		return (this.memberMap.get(song).isAvailable());
		
	}
	
	public void orderUI() {
		System.out.println("Thanks for using our ordering system! Please enter your email!");
		String email = sc.nextLine();
		
		System.out.println("Who is the recipient?");
		String sweetheart = sc.nextLine();
		
		//TODO List out all song options
		System.out.println("What is the song name?");
		String song = sc.nextLine();
		while(!this.songCheck(song)) {
			System.out.println("This song is not available. Please choose a new one.");
			song = sc.nextLine();
		}
		
		
		System.out.println("Finally, please enter the number of the credit card you want to use for this purchase?");
		int creditcard = sc.nextInt();
		
		
		this.makeOrder(email, sweetheart, song, creditcard);
	}
	
	
	
	
}
