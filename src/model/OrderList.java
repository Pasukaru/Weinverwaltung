package model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "OrderList")
public class OrderList extends Model implements Serializable {

	private static final long serialVersionUID = 6912651429570245793L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

}
