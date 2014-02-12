package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Type")
public class Type extends Model {

	private static final long serialVersionUID = -6969694686845095935L;

	public Type() {
		super();
	}

	public Type(String name) {
		super(name);
	}

}
