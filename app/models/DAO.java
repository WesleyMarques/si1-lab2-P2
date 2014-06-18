package models;

import java.util.List;

import javax.persistence.Query;

import play.db.jpa.JPA;

public class DAO {
	
	public void persist(Meta meta){
		JPA.em().persist(meta);		
	}
	
	public void flush(){
		JPA.em().flush();
	}
	
	public void merge(Meta meta){
		JPA.em().merge(meta);
	}
	
	public List<Meta> all() {
		String hql = "FROM Meta ORDER BY priority";
		Query hqlQuery = JPA.em().createQuery(hql);
		return hqlQuery.getResultList();
	}
	
	public void update(Long id){
		Meta metaUp = this.findByEntityId(id);
		metaUp.setDone();
		JPA.em().merge(metaUp);		
	}
	
	public Query createQuery(String query){
		return JPA.em().createQuery(query);
	}
	
	
	public void delete(Long id) {
		JPA.em().remove(findByEntityId(id));
	}
	
	public Meta findByEntityId(Long id) {
		return JPA.em().find(Meta.class, id);
	}

}
