package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Sort")
public class Sort extends Model {

	private static final long serialVersionUID = -6769741967390673414L;

	public Sort() {
		super();
	}

	public Sort(String name) {
		super(name);
	}

}
