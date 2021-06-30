/**
 * 
 */
package refrigerator;

/**
 * @author Shashini
 *
 */
public class RefrigiratorPublishImpl implements RefrigiratorPublish {

	/* (non-Javadoc)
	 * @see refrigerator.RefrigiratorPublish#publishRefrigiratorService()
	 */

	RefrigiratorActivator publisherActivator = new RefrigiratorActivator();
	
	public RefrigiratorPublishImpl(RefrigiratorActivator publisherActivator) {
		this.publisherActivator = publisherActivator;
	}

	@Override
	public String publishRefrigiratorService() {
		return publisherActivator.getStatus();
	}
}
