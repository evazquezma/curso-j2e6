package es.pruebas.j2ee6.ejb.persistencia.dao;

import java.util.List;

import es.pruebas.j2ee6.ejb.persistencia.model.LogEntity;

public interface LogDao {
	public void saveLog(String idSessionUsuario);
	
	public List<LogEntity> getAll();
}
