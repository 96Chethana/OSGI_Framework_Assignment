package garaj_servicepublisher;

import garaj_servicepublisher.Garaj_ServiceActivator;
import garaj_servicepublisher.Garaj_ServicePublish;

public class Garaj_ServicePublishImpl implements Garaj_ServicePublish {
	
	Garaj_ServiceActivator publisherActivator = new Garaj_ServiceActivator();
		
		public Garaj_ServicePublishImpl(Garaj_ServiceActivator publisherActivator){
			
			this.publisherActivator = publisherActivator;
		}
		
		@Override
		public String GarajService() {
			return publisherActivator.getStatus();
		}

}
