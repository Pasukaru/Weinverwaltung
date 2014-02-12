package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Vine")
public class Vine extends Model {

	private static final long serialVersionUID = -3967082767052216274L;

	public Vine() {
		super();
	}

	public Vine(String name) {
		super(name);
	}

	@ManyToMany(mappedBy = "vine")
	private final Set<Wine> wine = new HashSet<Wine>();

	public Set<Wine> getWine() {
		return wine;
	}

}
