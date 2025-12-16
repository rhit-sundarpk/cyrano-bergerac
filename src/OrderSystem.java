import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class OrderSystem {
	private HashMap<String, Member> memberSongMap = new HashMap<String, Member>();
	private HashMap<Integer, Member> idMap = new HashMap<Integer, Member>();
	private static Scanner sc = new Scanner(System.in);
	private ArrayList<String> songList = new ArrayList<String>();
	
	 public OrderSystem() {
	        initializeData();
	    }
	
	private void initializeData() {
        Member m1 = new Member(1, "Can't Help Falling in Love");
        Member m2 = new Member(2, "At Last");
        Member m3 = new Member(3, "Unchained Melody");
        Member m4 = new Member(4, "Perfect");
        Member m5 = new Member(5, "All of Me");
        Member m6 = new Member(6, "A Thousand Years");
        Member m7 = new Member(7, "Make You Feel My Love");
        
        memberSongMap.put(m1.getSong(), m1);
        memberSongMap.put(m2.getSong(), m2);
        memberSongMap.put(m3.getSong(), m3);
        memberSongMap.put(m4.getSong(), m4);
        memberSongMap.put(m5.getSong(), m5);
        memberSongMap.put(m6.getSong(), m6);
        memberSongMap.put(m7.getSong(), m7);
        
        idMap.put(1, m1);
        idMap.put(2, m2);
        idMap.put(3, m3);
        idMap.put(4, m4);
        idMap.put(5, m5);
        idMap.put(6, m6);
        idMap.put(7, m7);
        
        songList.add("Can't Help Falling in Love");
        songList.add("At Last");
        songList.add("Unchained Melody");
        songList.add("Perfect");
        songList.add("All of Me");
        songList.add("A Thousand Years");
        songList.add("Make You Feel My Love");
    }
	
	public void makeOrder(String email, String sweetheart, String song, long creditcard) {
		Member singer = memberSongMap.get(song);
		Order newOrder = new Order(email, sweetheart, song, creditcard);
		singer.assignOrder(newOrder);
		System.out.println("Order has been made!"+"\n");
	}
	
	
	public void songReportUI() {
		System.out.println("Get a report of requests for your song.");
		System.out.println("Enter your member ID number:");
		int memberID = sc.nextInt();
		Member member = idMap.get(memberID);
		member.startSinging();
		songList.remove(member.getSong());
		
	}
	public void orderUI() {
		System.out.println("Thanks for using our ordering system! Please enter your email!");
		String email = sc.nextLine();
		while(!email.contains("@")) {
			System.out.println("Please enter a valid email with an @!");
			email = sc.nextLine();
		}
		System.out.println("Who is the recipient?");
		String sweetheart = sc.nextLine();
		
		for (int i = 0; i < songList.size(); i++) {
            String song = songList.get(i);
            System.out.println((i + 1) + " - \"" + song + "\"" );
        }
		
		 int choice =0;
		 while(choice < 1 || choice > 7) {
		 try {
			 System.out.println("Your choice (Just the number): ");
			 choice = sc.nextInt();
		     sc.nextLine();
		     if(choice < 1 || choice > 7) {
		    	 System.out.println("Number has to be a valid choice from the list!");
		     }
		 }
		 catch (InputMismatchException error) {
			 choice =0;
			 sc.nextLine();
			 System.out.println("Invalid input!");
			 
			 
		 }
		 
		 }
	     
	      
	     
	        
	     String selectedSong = songList.get(choice - 1);
	        
		
	     System.out.println("Finally, please enter a 16 digit number of the credit card you want to use for this purchase");
	     long creditcard = 0;
		
		 while((Long.toString(creditcard)).length()!=16) {
			 try {
				 System.out.println("Your credit card number: ");
				 creditcard = sc.nextLong();
			     sc.nextLine();
			     
			     if((Long.toString(creditcard)).length()!=16) {
			    	 System.out.println("Card number has to be 16 digits long");
			     }
			 }
			 catch (InputMismatchException error) {
				 System.out.println("Please enter a valid 16 digit credit card number!");
				 sc.nextLine();
				 
			 }
			 }
		
		this.makeOrder(email, sweetheart, selectedSong, creditcard);
	}
	
	public void songsDoneUI() {
        System.out.println("Report back that your songs are done!");
        System.out.print("Enter your member ID number: ");
        int memberID = sc.nextInt();
        sc.nextLine();
        
        Member member = idMap.get(memberID);
        if (member == null) {
            System.out.println("Invalid member ID!");
            return;
        }
        
        if (member.isAvailable()) {
            System.out.println("You haven't started singing yet!");
            return;
        }
        
        if (member.isDone()) {
            System.out.println("You have already completed and reported your songs!");
            return;
        }
        
        System.out.println("Your customers will be charged and notified!");
        member.completeSinging();
    }
	
	public void showAdminData() {
        for (int i = 1; i <= 7; i++) {
            Member member = idMap.get(i);
            System.out.println("\nMember ID: " + i);
            System.out.println("Song: " + member.getSong());
            System.out.println("Available: " + member.isAvailable());
            System.out.println("Number of Orders: " + member.getOrderCount());
            
            ArrayList<Order> orders = member.getOrders();
            if (!orders.isEmpty()) {
                System.out.println("Orders:");
                for (int j = 0; j < orders.size(); j++) {
                    Order o = orders.get(j);
                    System.out.println("  " + (j + 1) + ". Sweetheart: " + o.getSweetheart() + ", Customer: " + o.getEmail() + ", Card: " + o.getCard() +", Completed: " + o.getCompleted());
                }
            }
        }
    }
		
}
	
	
