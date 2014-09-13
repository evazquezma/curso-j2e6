package es.pruebas.j2ee6.ejb.persistencia.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.pruebas.j2ee6.ejb.persistencia.model.LogEntity;

@Stateless
@Local
public class LogDaoBean implements LogDao{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void saveLog(String idSessionUsuario) {
		Query query = em.createNamedQuery("logDeUsuario");
		query.setParameter("idSession", idSessionUsuario);
		
		@SuppressWarnings("unchecked")
		List<LogEntity> logsEntities = query.getResultList();
		if (! logsEntities.isEmpty()) {
			LogEntity logEntity = logsEntities.get(0);
			logEntity.setNumeroAccesos(logEntity.getNumeroAccesos() + 1);
			logEntity.setUltimoAcceso(new Date());
			em.persist(logEntity);
		}
		else {
			LogEntity logEntity = new LogEntity();
			logEntity.setIdSession(idSessionUsuario);
			logEntity.setNumeroAccesos(1);
			logEntity.setUltimoAcceso(new Date());
			em.persist(logEntity);
		}				
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<LogEntity> getAll() {		
		return em.createQuery("SELECT l FROM LogEntity l").getResultList();
	}

}
