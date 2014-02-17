package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Wine")
public class Wine extends Model {

	private static final long serialVersionUID = -8755001068472289262L;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		name = "WineVine",
		joinColumns = { @JoinColumn(name = "wine_id") },
		inverseJoinColumns = { @JoinColumn(name = "vine_id") })
	@Column(nullable = false)
	private Set<Vine> vine = new HashSet<Vine>();

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "sort_id", nullable = false)
	private Sort sort;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "type_id", nullable = false)
	private Type type;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "winery_id", nullable = false)
	private Winery winery;

	@Column(nullable=false)
	private int price;

	public Wine() {
		super();
	}

	public Wine(String name, Set<Vine> vine, City city, Sort sort, Type type,
		Winery winery, int price) {
		super(name);
		this.vine = vine;
		this.city = city;
		this.sort = sort;
		this.type = type;
		this.winery = winery;
		this.price = price;
	}

	public Set<Vine> getVine() {
		return vine;
	}

	public void setVine(Set<Vine> vine) {
		this.vine = vine;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Winery getWinery() {
		return winery;
	}

	public void setWinery(Winery winery) {
		this.winery = winery;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
