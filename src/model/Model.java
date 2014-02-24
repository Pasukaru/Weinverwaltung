package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Model implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;	
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	public Model(){}
	
	public Model(String name){
		setName(name);
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString() {
		Integer id = getId();
		String name = getName();

		StringBuffer sb = new StringBuffer(getClass().getSimpleName());
		sb.append(" [id: ");
		sb.append(id == null ? "null" : id);
		sb.append(", name: ");
		sb.append(name == null ? "null" : name);
		sb.append("]");

		return sb.toString();
	}
}
