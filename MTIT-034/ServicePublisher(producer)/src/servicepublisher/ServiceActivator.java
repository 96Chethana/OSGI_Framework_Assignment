package servicepublisher;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
	
		
	ServiceRegistration publishServiceRegistration;
	private Scanner scanner = new Scanner(System.in);
	private String a = "a: Vegitables";
	private String b = "b: Dairy and Meats";
	private String c = "c: Dry Foods";
	private String d = "a: is it processed?";
	private String e = "b: is it natural?";
	private String status = "";
	
	public void start(BundleContext context) throws Exception {
		System.out.println("publisher start");
		ServicePublish publisherService = new ServicePublishImpl();
		publishServiceRegistration = context.registerService(
				ServicePublish.class.getName(), publisherService, null);
		
		
		System.out.println(a + "\n" + b + "\n" + c);
		System.out.println("Select the Item you want to add in (Add) : ");
		String answerOne = scanner.next();
		
		System.out.println(d + "\n" + e);
		System.out.println("Let us know the following (Add) : ");
		String answerTwo = scanner.next();
		
		

		
		switch (answerOne) {
			
		case "a":
			System.out.println("please put your item into the Lower compartment");
			break;
		case "b":
			System.out.println("please put your item into the Upper compartment");
			break;
		case "c":
			System.out.println("please put your item into the lower compartment");
			break;
		}
		
		
		if (answerTwo == d && answerOne == b) {
			
			System.out.println("you can keep processed meats in lower compartment as well!");
			
		}else if (answerTwo == e && answerOne == b) {
			
			System.out.println("Please put fresh meats on upper compartment!");
			
		}else if (answerTwo == d && answerOne == a) {
			
			System.out.println("Please put Vegitables into lower compartment!");
			
		}else if (answerTwo == e && answerOne == a) {
			
			System.out.println("Please put fresh vegitables into lower compartment and keep the temperature low!");
			
		}else if (answerTwo == d && answerOne == c) {
			
			System.out.println("Please put Dry food into the lower compartment!");
			
		}else if (answerTwo == e && answerOne == c) {
			
			System.out.println("Please put Homemade ones to the lower compartment!");
			
		}
		
		
	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("publisher stop");
		
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
