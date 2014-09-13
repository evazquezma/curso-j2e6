package es.pruebas.j2ee6.mdb;

import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven(mappedName="jms/notitficacionesQueue", 
	activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode",  propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType",  propertyValue = "javax.jms.Queue"),        
    })
public class NotificacionesQueueMDB implements MessageListener {

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {

		try {
			message.acknowledge();
		} catch (Exception e) {
			e.printStackTrace();
		}

		TextMessage txtMessage = (TextMessage) message;

		try {
			System.out.println(txtMessage.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}