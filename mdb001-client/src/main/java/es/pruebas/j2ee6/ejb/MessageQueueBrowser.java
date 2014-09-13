package es.pruebas.j2ee6.ejb;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class MessageQueueBrowser {

	public void browseMessages() {

		try {
			InitialContext cntxt = new InitialContext();
			ConnectionFactory connectionFactory = (QueueConnectionFactory) cntxt.lookup("jms/notificacionesFactory");
			Queue queue = (Queue) cntxt.lookup("jms/notitficacionesQueue");

			Enumeration messageEnumeration;
			TextMessage textMessage;
			Connection connection = connectionFactory.createConnection();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueBrowser browser = session.createBrowser(queue);
			messageEnumeration = browser.getEnumeration();
			if (messageEnumeration != null) {
				if (!messageEnumeration.hasMoreElements()) {
					System.out.println("There are no messages in the  queue.");
				} 
				else {
					System.out.println("The following messages are in the  queue:");
					while (messageEnumeration.hasMoreElements()) {
						textMessage = (TextMessage) messageEnumeration.nextElement();
						System.out.println(textMessage.getText());
					}
				}
			}
			session.close();
			connection.close();
		} 
		catch (JMSException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MessageQueueBrowser().browseMessages();
	}
}