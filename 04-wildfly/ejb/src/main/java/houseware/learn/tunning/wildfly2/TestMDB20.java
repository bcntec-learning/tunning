package houseware.learn.tunning.wildfly2;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
 
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/testQueue2"),
		@ActivationConfigProperty(propertyName = "maxSession", propertyValue = "20"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class TestMDB20 implements MessageListener {

	public void onMessage(Message message) {
		// Do nothing
	}

}
