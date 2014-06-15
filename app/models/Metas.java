package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Metas extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Required
	private int priority;// vai de 0 - 5
	
	@Required
	private String nameMeta;
	
	@Required
	private int week; //0-6
	
	private boolean isDone;
}
