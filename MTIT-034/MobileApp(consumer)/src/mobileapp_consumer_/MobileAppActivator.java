/**
 * 
 */
package mobileapp_consumer_;

/**
 * @author Salay M.S -  IT18006858
 * @author L.V.I.S Thilakarathne - IT18502466
 * @author Wijethilaka M.G.R - IT18062816
 * @author Shashini chethana - IT18001730
 * 
 *
 */
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import garaj_servicepublisher.Garaj_ServicePublish;
import refrigerator.RefrigiratorPublish;
import roomsensor.roomSensorPublish;
import servicepublisher.ServicePublish;



public class MobileAppActivator implements BundleActivator{
	
	
	ServiceReference serviceReference;
	Scanner scanner = new Scanner(System.in);
	String input = "";
	
	@Override
	public void start(BundleContext context) throws Exception {
	
		//System.out.println("Consumer Start");
		
			System.out.print("ServicePublish(D) / Garaj_ServicePublisher(G) / Refrigirator(R) ?: ");
			input = scanner.next();

		//RoomSensor roomSensor(S) /
			if (input.equalsIgnoreCase("S")) {
				try {
					serviceReference = context.getServiceReference(roomSensorPublish.class.getName());
					roomSensorPublish servicePublish = (roomSensorPublish) context.getService(serviceReference);
					System.out.println(servicePublish.publishroomSensorService());
				} catch (Exception e) {
					System.out.println("No new notifications");
				}
			}
	
			
		//DeepFreezer
			 if (input.equalsIgnoreCase("D")) {
				try {
					serviceReference = context.getServiceReference(ServicePublish.class.getName());
					ServicePublish servicePublish = (ServicePublish) context.getService(serviceReference);
					System.out.println(servicePublish.publishService());
				} catch (Exception e) {
					System.out.println("No new notifications");
				}
			}
			
			//Garaj_ServicePublisher 
			else if (input.equalsIgnoreCase("G")) {
				try {
					serviceReference = context.getServiceReference(Garaj_ServicePublish.class.getName());
					Garaj_ServicePublish servicePublish = (Garaj_ServicePublish) context.getService(serviceReference);
					System.out.println(servicePublish.GarajService());
				} catch (Exception e) {
					System.out.println("No new notifications");
				}
			}
	
			//Smart Refrigerator
			else if (input.equalsIgnoreCase("R")) {
					try {
						serviceReference = context.getServiceReference(RefrigiratorPublish.class.getName());
						RefrigiratorPublish servicePublish = (RefrigiratorPublish) context.getService(serviceReference);
						System.out.println(servicePublish.publishRefrigiratorService());
					} catch (Exception e) {
						System.out.println("No new notifications");
					}
			}

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// close the service tracker
		System.out.println("Mobile App Stop");
		try {
			context.ungetService(serviceReference);
		} catch (Exception e) {
			
		}
		
	}
}
