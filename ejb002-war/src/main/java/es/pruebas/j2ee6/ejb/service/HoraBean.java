package es.pruebas.j2ee6.ejb.service;

import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton
@Remote(Hora.class)
public class HoraBean implements Hora {

	@Override
	public Date queHoraEs() {		
		return new Date();
	}

}
