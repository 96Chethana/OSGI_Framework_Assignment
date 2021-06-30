package roomsensor;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import roomsensor.roomSensorPublish;
import roomsensor.roomServiceImpl;

import java.util.Scanner;

public class Activator implements BundleActivator {
	
	private ServiceRegistration serviceRegistration;
	private Scanner scanner = new Scanner(System.in);
	private String status;

	private static BundleContext context;
	

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		roomSensorPublish servicePublish = new roomServiceImpl(this);
		serviceRegistration = context.registerService(roomSensorPublish.class.getName(), servicePublish, null);
		
		System.out.print("Enter room (Enter Y/y if yes) ? (Y) : ");
		String enter_room = scanner.next();
		
		if(enter_room.equalsIgnoreCase("Y") || enter_room.equalsIgnoreCase("y")){
			
			int code;
		  do{
			  
			System.out.print("Please enter security code? : \n");
			code = scanner.nextInt();
			
			status = "You are not authorized";
			  
		  }while(code!=2020);{
			  
			  status= "You are authorized";  
		  }
		  
		   }
		else {
			System.out.println("exit..."); 
			    // Terminate JVM 
            System.exit(0);
		}
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Room sensor Stop");
		serviceRegistration.unregister();
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
