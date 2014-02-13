package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class City extends Model {

	private static final long serialVersionUID = 1702340531760181107L;

	private String zipCode;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "region_id", nullable = false)
	private Region region;

	public City() {
		super();
	}

	public City(String name, String zipCode, Region region) {
		super(name);
		this.zipCode = zipCode;
		this.region = region;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
