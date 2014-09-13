package es.pruebas.j2ee6.ejb;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;



public class Main {

	public static void main(String[] args) throws Exception {
		
		String msg = "Hola mundo";

		// Indicar la dirección del cliente JMS de glassfish
		Properties props = new Properties();
		props.put(Context.PROVIDER_URL, "mq://localhost:7676");
		InitialContext cntxt = new InitialContext(props);	
		System.out.println("Creado contexto");
		
		
		//Buscar QueueConnectionFactory del JMS Provider y crear una nueva conexión
		QueueConnectionFactory qFactory = (QueueConnectionFactory) cntxt.lookup("jms/notificacionesFactory");			
		Connection connection = qFactory.createConnection();
		System.out.println("Conexión establecida con el proveedor JMS");

	
		// Inicializar sesion
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

		// Crear mensaje
		TextMessage message = session.createTextMessage();
		message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
		message.setText(msg);

				
		// Enviar el mensaje a la cola
		Queue queue = (Queue) cntxt.lookup("jms/notitficacionesQueue");
		MessageProducer mp = session.createProducer(queue);
		mp.send(message);
		System.out.println("Message enviado: " + msg);


		mp.close();
		session.close();
		cntxt.close();
	}

}
