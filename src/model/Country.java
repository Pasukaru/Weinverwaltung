package model;

import javax.persistence.Entity; 
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country extends Model {

	private static final long serialVersionUID = 1180968555831389691L;

	public Country() {
		super();
	}

	public Country(String name) {
		super(name);
	}

}
