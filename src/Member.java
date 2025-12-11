import java.util.ArrayList;
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
	
	public String getSong() {
		return this.song;
	}
	public int getOrderCount() {
		return this.orders.size();
	}
	public ArrayList<Order> getOrders(){
		return this.orders;
	}
	public boolean assignOrder(Order order) {
		orders.add(order);
		return true;
	}
	
    public boolean isAvailable() {
    	return this.isAvailable;
    }
    public boolean isDone() {
    	return this.isDone;
    }
    public void startSinging() {
    	this.isAvailable = false;
    	for (Order order : orders) {
    		System.out.println(order.getSweetheart());
    	}
    }
    public void completeSinging() {
        this.isDone = true;
        
        for (Order order : orders) {
            // Charge credit card
            System.out.println("\n[CHARGING CREDIT CARD]");
            System.out.println("Card Number: " + order.getCard());
            System.out.println("Amount: $50.00");
            System.out.println("Status: SUCCESS");
            
            // Send email to customer
            System.out.println("\n[SENDING EMAIL]");
            System.out.println("To: " + order.getEmail());
            System.out.println("Subject: Your Valentine's Day Song Has Been Delivered!");
            System.out.println("Body: Dear Customer,");
            System.out.println("      Your song \"" + order.getSong() + "\" has been sung to " + 
                             order.getSweetheart() + ".");
            System.out.println("      Thank you for using our service!");
            System.out.println("      - Serenaders' Music Club");
            
            order.markCompleted();
        }
        
        System.out.println("\n================================");
        System.out.println("All customers charged and notified!");
    }
	
	
	
}
