package model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Vine")
public class Vine extends Model implements Serializable {

	private static final long serialVersionUID = -3967082767052216274L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String name;

	public Vine(String name) {
		super();
		this.name = name;
	}

	@ManyToMany(mappedBy = "vine")
	private final Set<Wine> wine = new HashSet<Wine>();

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Wine> getWine() {
		return wine;
	}


}
