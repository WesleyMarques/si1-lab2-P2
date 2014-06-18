package models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import play.data.validation.Constraints.Required;

@Entity
public class Meta{
	
	public static final int ALTA = 1;
	public static final int MEDIA = 2;
	public static final int BAIXA = 3;	
	/**
	 * 
	 */

	@Id
	@SequenceGenerator(name = "META_SEQUENCE", sequenceName = "META_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	@Required
	private int priority;// vai de 1 - 3
	
	@Required
	private String nameMeta;
	
	@Required
	private int week; //0-6
	
	private boolean isDone = false;
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
	public void setDone() {
		this.isDone = true;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	
}
