package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Winery")
public class Winery extends Model {

	private static final long serialVersionUID = -2443991986874259370L;

	public Winery() {
		super();
	}

	public Winery(String name) {
		super(name);
	}

}
