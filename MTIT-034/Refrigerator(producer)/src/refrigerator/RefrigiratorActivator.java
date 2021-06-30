/**
 * 
 */
package refrigerator;

/**
 * @author Shashini chethana - IT18001730
 *
 */
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class RefrigiratorActivator implements BundleActivator {

	private ServiceRegistration serviceRegistration;
	private Scanner scanner = new Scanner(System.in);
	private int availableNumberOfCokeBottles = 10; //assume this value is got through a sensor
	private int neededNumberOfCokeBottles = 0;  //this value is used for represent getting CokeBottles  
	private int availableNumberOfEggs = 10; //assume this value is got through a sensor
	private int neededNumberOfEggs = 0; //this value is used for represent getting eggs 
	private int availableNumberOfIceCreams = 10; //assume this value is got through a sensor
	private int neededNumberOfIceCreams = 0; //this value is used for represent getting IceCreams 
	private int availableNumberOfMilkBottles  = 10; //assume this value is got through a sensor
	private int neededNumberOfMilkBottles  = 0; //this value is used for represent getting MilkBottels
	private String status = "";
	
	public void start(BundleContext context) throws Exception {
		//System.out.println("Publisher Start");
		
		RefrigiratorPublish servicePublish = new RefrigiratorPublishImpl(this);
		serviceRegistration = context.registerService(RefrigiratorPublish.class.getName(), servicePublish, null);
		
		
		System.out.print("Adding or Getting ? (Add/Get) : ");
		String answerOne = scanner.next();
		System.out.print("CokeBottle / Eggs / IceCream / MilkBottle : ");
		String answerTwo = scanner.next();
		
		//Add
		if (answerOne.equalsIgnoreCase("Add")) {
			//Coke Bottles
			if (answerTwo.equalsIgnoreCase("CokeBottle") || answerTwo.equalsIgnoreCase("CokeBottles")) {
				System.out.print("Enter number of CokeBottle to add: ");
				int temp = scanner.nextInt();
				availableNumberOfCokeBottles = availableNumberOfCokeBottles + temp;
				status = "\nNotification:- " + temp + " CokeBottles were added to the refrigirator\n"
						+ "Now you have " + availableNumberOfCokeBottles + " CokeBottles.\n";
			}
			//Eggs
			else if (answerTwo.equalsIgnoreCase("Egg") || answerTwo.equalsIgnoreCase("Eggs")) {
				System.out.print("Enter number of eggs to add: ");
				int temp = scanner.nextInt();
				availableNumberOfEggs = availableNumberOfEggs + temp;
				status = "\nNotification:- " + temp + " Eggs were added to the refrigirator\n"
						+ "Now you have " + availableNumberOfEggs + " Eggs.\n";
			}
			
			//IceCreams
			else if (answerTwo.equalsIgnoreCase("IceCream") || answerTwo.equalsIgnoreCase("IceCreams")) {
				System.out.print("Enter number of Ice-Creams to add: ");
				int temp = scanner.nextInt();
				availableNumberOfIceCreams = availableNumberOfIceCreams + temp;
				status = "\nNotification:- " + temp + " Ice-Creams were added to the refrigirator\n"
						+ "Now you have " + availableNumberOfIceCreams + " IceCreams.\n";
			}
			
			//Milk Bottles
			else if (answerTwo.equalsIgnoreCase("MilkBottle") || answerTwo.equalsIgnoreCase("MilkBottles")) {
				System.out.print("Enter number of MilkBottles to add: ");
				int temp = scanner.nextInt();
				availableNumberOfMilkBottles = availableNumberOfMilkBottles + temp;
				status = "\nNotification:- " + temp + " MilkBottles were added to the refrigirator\n"
						+ "Now you have " + availableNumberOfMilkBottles + " MilkBottles.\n";
			}
			
		}
		
		//Get 
		else if (answerOne.equalsIgnoreCase("Get")) {
			
			//Coke Bottles
			if (answerTwo.equalsIgnoreCase("CokeBottle") || answerTwo.equalsIgnoreCase("CokeBottles")) {
				System.out.print("Enter number of CokeBottles you want: ");
				neededNumberOfCokeBottles = scanner.nextInt();
				
				if (availableNumberOfCokeBottles< neededNumberOfCokeBottles) {
					status = "\nNotification:- You have no sufficient number of CokeBottles";
				}
				else {
					availableNumberOfCokeBottles = availableNumberOfCokeBottles - neededNumberOfCokeBottles;
					status = "\nNotification:- You have used " + neededNumberOfCokeBottles + " CokeBottles.\n"
							+ "Now you have " + availableNumberOfCokeBottles + " CokeBottles.";
				}
				
			}
			
			//Eggs
			else if (answerTwo.equalsIgnoreCase("Egg") || answerTwo.equalsIgnoreCase("Eggs")) {
				System.out.print("Enter number of Eggs you want: ");
				neededNumberOfEggs = scanner.nextInt();
				
				if (availableNumberOfEggs < neededNumberOfEggs) {
					status = "\nNotification:- You have no sufficient number of Eggs";
				}
				else {
					availableNumberOfEggs = availableNumberOfEggs - neededNumberOfEggs;
					status = "\nNotification:- You have used " + neededNumberOfEggs + " Eggs.\n"
							+ "Now you have " + availableNumberOfEggs + " Eggs.";
				}
			}
			
			//IceCream
			else if (answerTwo.equalsIgnoreCase("IceCream") || answerTwo.equalsIgnoreCase("IceCreams")) {
				System.out.print("Enter number of Ice-Creams you want: ");
				neededNumberOfIceCreams = scanner.nextInt();
				
				if (availableNumberOfIceCreams < neededNumberOfIceCreams) {
					status = "\nNotification:- You have no sufficient number of IceCreams";
				}
				else {
					availableNumberOfIceCreams = availableNumberOfIceCreams - neededNumberOfIceCreams;
					status = "\nNotification:- You have used " + neededNumberOfIceCreams + " IceCreams.\n"
							+ "Now you have " + availableNumberOfIceCreams + " IceCreams.";
				}
			}
			
			//Milk Bottles 
			else if (answerTwo.equalsIgnoreCase("MilkBottle") || answerTwo.equalsIgnoreCase("MilkBottles")) {
				System.out.print("Enter number of MilkBottles you want: ");
				neededNumberOfMilkBottles = scanner.nextInt();
				
				if (availableNumberOfMilkBottles< neededNumberOfMilkBottles) {
					status = "\nNotification:- You have no sufficient number of Milk Bottles";
				}
				else {
					availableNumberOfMilkBottles = availableNumberOfMilkBottles - neededNumberOfMilkBottles;
					status = "\nNotification:- You have used " + neededNumberOfMilkBottles + " MilkBottles.\n"
							+ "Now you have " + availableNumberOfMilkBottles + " MilkBottles.";
				}
				
			}
			
		}
		
	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Refrigirator Stop");
		serviceRegistration.unregister();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
