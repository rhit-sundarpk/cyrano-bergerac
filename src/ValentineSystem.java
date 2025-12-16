
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValentineSystem {
	public static void main(String[] args) {
		OrderSystem system = new OrderSystem();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Serenaders' Club Song System!");

		while (true) {
			System.out.println("Select the action to do:");
			System.out.println("1 - Customers: Order a song for Valentine's Day");
			System.out.println("2 – Club members: Get a report of requests for your song");
			System.out.println("3 – Club members: Report back that your songs are done");
			System.out.println("4 - Admin: Show data for all club members");
			System.out.println("5 - Exit");
			System.out.print("Enter 1, 2, 3, 4, or 5: ");
			try {
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					system.orderUI();
					break;
				case 2:
					system.songReportUI();
					break;
				case 3:
					system.songsDoneUI();
					break;
				case 4:
					system.showAdminData();
					break;
				case 5:
					System.out.println("Thank you for using our system!");
					sc.close();
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			} catch (InputMismatchException error) {
				System.err.println("Number has to be a valid choice from the list!");
				sc.nextLine();
			}
		}
	}
}