package com.erwan.nikonikospring.models.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


//cette annotation indique que cette classe n'apparaitra pas directement dans la DTB
//i.e. : pas d'heritage en dtb
@MappedSuperclass
public abstract class DatabaseItem {

	@Transient
	public String table;

	@Transient
	public String[] fields;

	//on decris avec ces deux annotations qu'on a un id en auto_increment
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		if (id>0){
			this.id = id;
		}else {
			this.id = 0;
		}

	}

	public DatabaseItem(String table, String[] fields) {
		this.table = table;
		this.fields = fields;
	}

	public DatabaseItem() {
	}
}
