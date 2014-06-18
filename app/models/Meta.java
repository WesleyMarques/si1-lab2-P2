package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Meta extends Model {
	
	public static final int ALTA = 1;
	public static final int MEDIA = 2;
	public static final int BAIXA = 3;	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Required
	private int priority;// vai de 1 - 3
	
	@Required
	private String nameMeta;
	
	@Required
	private int week; //0-6
	
	private boolean isDone;
	
	public static Finder<Long, Meta> find = new Finder<Long, Meta>(Long.class,
			Meta.class);
	
	public static List<Meta> all(){
		return find.orderBy("priority").findList();
	}
	
	public static void create(Meta meta) {
		meta.save();
	}

	
	public static void markAsDone(Long id) {
		Meta meta = find.byId(id);
		meta.setDone(true);
		meta.update();
	}

	
	public static void delete(Long id) {
		find.ref(id).delete();
	}
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the nameMeta
	 */
	public String getNameMeta() {
		return nameMeta;
	}

	/**
	 * @param nameMeta the nameMeta to set
	 */
	public void setNameMeta(String nameMeta) {
		this.nameMeta = nameMeta;
	}

	/**
	 * @return the week
	 */
	public int getWeek() {
		return week;
	}

	/**
	 * @param week the week to set
	 */
	public void setWeek(int week) {
		this.week = week;
	}

	/**
	 * @return the isDone
	 */
	public boolean isDone() {
		return isDone;
	}

	/**
	 * @param isDone the isDone to set
	 */
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	
}
