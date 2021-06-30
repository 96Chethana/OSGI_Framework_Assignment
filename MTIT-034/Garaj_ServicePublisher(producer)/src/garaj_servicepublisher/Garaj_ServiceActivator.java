package garaj_servicepublisher;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import garaj_servicepublisher.Garaj_ServicePublish;
import garaj_servicepublisher.Garaj_ServicePublishImpl;

public class Garaj_ServiceActivator implements BundleActivator {

	private ServiceRegistration serviceRegistration;
	Scanner scanner = new Scanner(System.in);
	private String status;

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Garaj_ServiceActivator.context = bundleContext;
		
		Garaj_ServicePublishImpl servicePublish = new Garaj_ServicePublishImpl(this);
		serviceRegistration = context.registerService(Garaj_ServicePublishImpl.class.getName(), servicePublish, null);
	
		
		int availableSlot = 4;
		//int parkedVehicle = 0;
		
	
		for (int parkedVehicle = 0; parkedVehicle <= 4;) {
		
			System.out.print("\nPark IN (I) | Park OUT(O) : ");
			String enter_garaj = scanner.next();
			
			if(enter_garaj.equalsIgnoreCase("I") || enter_garaj.equalsIgnoreCase("i")){
				
				if(parkedVehicle == 4) {
					System.out.println("Limit is up"); 
				    // Terminate JVM 
					//System.exit(0);
					break;
				}else
				{
					availableSlot-- ;
					parkedVehicle ++ ;
					
					System.out.println("You can park your Vehicle.");
					System.out.println("More " + availableSlot+ " Vehicle can park.");
					System.out.println(parkedVehicle + " Vehicles are parked.");
				}
			}
			else if(enter_garaj.equalsIgnoreCase("O") || enter_garaj.equalsIgnoreCase("o"))
			{
				if(parkedVehicle > 0) {
					
					availableSlot++ ;
					parkedVehicle -- ;
					
					System.out.println("You got out your Vehicle.");
					System.out.println("More " + availableSlot+ " Vehicle can park.");
					System.out.println(parkedVehicle + " In Garaj.");
								
					
				}else
				{
					//System.out.print("Enter the Car Reg No : ");
					//String regNo = scanner.next();
					
					System.out.println("No more vehicle to out"); 
				    // Terminate JVM 
					//System.exit(0);
					break;
					
				}
				
			}
			else 
			{
					System.out.println("Enter Valid Input"); 
					// Terminate JVM 
		            
			}
			
		}
				
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Garaj Service Stop");
		serviceRegistration.unregister();
		
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
