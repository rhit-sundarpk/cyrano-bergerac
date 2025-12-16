import java.util.ArrayList;

//isaac class

public class Member {
	private int id;
	private ArrayList<Order> orders = new ArrayList<Order>();
	private String song;
	private boolean isAvailable;
	private boolean isDone;

	public Member(int id, String song) {
		this.id = id;
		this.song = song;
		this.isAvailable = true;
		this.isDone = false;

	}

	// returns song name
	public String getSong() {
		return this.song;
	}

	// return amount of orders for specific song by member
	public int getOrderCount() {
		return this.orders.size();
	}

	// returns list of orders for member's song
	public ArrayList<Order> getOrders() {
		return this.orders;
	}

	// just orders the songs and puts in the member's list
	public boolean assignOrder(Order order) {
		orders.add(order);
		return true;
	}

	// shows if the member is available
	public boolean isAvailable() {
		return this.isAvailable;
	}

	// shows if member is done
	public boolean isDone() {
		return this.isDone;
	}

	// shows that singer is starting and marks on each order
	public void startSinging() {
		this.isAvailable = false;
		for (Order order : orders) {
			System.out.println(order.getSweetheart());
		}
	}

	// finishes singing and prints the email and cc changes for each order
	public void completeSinging() {
		this.isDone = true;

		for (Order order : orders) {
			System.out.println("\n[CHARGING CREDIT CARD]");
			System.out.println("Card Number: " + order.getCard());
			System.out.println("Amount: $50.00");
			System.out.println("Status: SUCCESS");

			System.out.println("\n[SENDING EMAIL]");
			System.out.println("To: " + order.getEmail());
			System.out.println("Subject: Your Valentine's Day Song Has Been Delivered!");
			System.out.println("Body: Dear Customer,");
			System.out.println(
					"      Your song \"" + order.getSong() + "\" has been sung to " + order.getSweetheart() + ".");
			System.out.println("      Thank you for using our service!");
			System.out.println("      - Serenaders' Music Club");

			order.markCompleted();
		}

		System.out.println("All customers charged and notified!");
	}

}
