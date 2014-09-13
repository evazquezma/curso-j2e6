package es.pruebas.j2ee6.ejb.persistencia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="logDeUsuario", query="SELECT l FROM LogEntity l WHERE l.idSession = :idSession")
public class LogEntity {
	@Id @GeneratedValue
	private Long id;
	
	private String idSession;
	private Integer numeroAccesos;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimoAcceso;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdSession() {
		return idSession;
	}
	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}
	public Integer getNumeroAccesos() {
		return numeroAccesos;
	}
	public void setNumeroAccesos(Integer numeroAccesos) {
		this.numeroAccesos = numeroAccesos;
	}
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}
	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}
	
	

	@Override
	public String toString() {
		return "LogEntity [id=" + id + ", idSession=" + idSession
				+ ", numeroAccesos=" + numeroAccesos + ", ultimoAcceso="
				+ ultimoAcceso + "]";
	}


}
