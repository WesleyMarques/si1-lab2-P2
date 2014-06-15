package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Meta extends Model {
	
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
	
	public static Finder<Long, Meta> find = new Finder<Long, Meta>(Long.class,
			Meta.class);
	
	/**
	 * @param nWeek
	 * @return List<Meta>
	 */
	public static List<Meta> allDoneByWeek(int nWeek) {
		return find.orderBy("priority").where("isDone = TRUE AND week = "+nWeek).findList();
		
	}
	
	/**
	 * 
	 * @param nWeek
	 * @return
	 */
	public static List<Meta> allUnDoneByWeek(int nWeek) {
		return find.orderBy("priority").where("isDone = FALSE AND week = "+nWeek).findList();
		
	}
	
	public static void create(Meta meta) {
		meta.save();
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