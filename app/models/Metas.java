package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Metas extends Model {
	
	@Id
	private long id;

	@Required
	private int priority;// vai de 0 - 5
}
