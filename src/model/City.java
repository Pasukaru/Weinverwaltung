package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="City")
public class City extends Model implements Serializable {

	private static final long serialVersionUID = 1702340531760181107L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	private String name;
<<<<<<< HEAD
	private Integer zipCode;
=======
	private String zipCode;
>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="region_id")
	private Region region;

<<<<<<< HEAD
	public City(String name, Integer zipCode, Region region) {
=======
	public City(String name, String zipCode, Region region) {
>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
		super();
		this.name = name;
		this.zipCode = zipCode;
		this.region = region;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

<<<<<<< HEAD
	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
=======
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
		this.zipCode = zipCode;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
