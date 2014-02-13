package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Region")
public class Region extends Model {

	private static final long serialVersionUID = 8631375902987124009L;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;

	public Region() {
		super();
	}

	public Region(String name, Country country) {
		super(name);
		this.country = country;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
