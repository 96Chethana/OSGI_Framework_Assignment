package roomsensor;

public class roomServiceImpl implements roomSensorPublish {
	
    Activator publisherActivator = new Activator();
	
	public roomServiceImpl(Activator publisherActivator){
		
		this.publisherActivator = publisherActivator;
	}
	
	@Override
	public String publishroomSensorService() {
		return publisherActivator.getStatus();
	}
}
