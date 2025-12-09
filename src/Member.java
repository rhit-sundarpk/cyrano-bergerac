import java.util.ArrayList;
public class Member {
	private int id;
	private ArrayList<Order> orders = new ArrayList<Order>();
	private String song;
	private boolean isAvailable;
	
	public Member(int id, String song) {
		this.id = id;
		this.song = song;
		this.isAvailable = true;
		
	}
	
	private void viewOrders() {}
	
	public boolean assignOrder(Order order) {
		orders.add(order);
		return true;
	}
	
    public boolean isAvailable() {
    	return this.isAvailable;
    }
    
    public void startSinging() {
    	this.isAvailable = false;
    }
	
	
	
}
