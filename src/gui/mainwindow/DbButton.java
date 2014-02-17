package gui.mainwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityTransaction;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.City;
import model.Country;
import model.Region;
import model.Sort;
import model.Type;
import model.Vine;
import model.Wine;
import model.Winery;
import util.JpaUtil;
import util.Repository;

public class DbButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -4715489416822515615L;

	public DbButton() {
		super("Test-Daten erstellen");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setDbData();
	}

	private void setDbData() {
		Country country1 = new Country("Deutschland");
		Country country2 = new Country("Italien");
		Country country3 = new Country("Frankreich");

		Region region1 = new Region("Oberbayern", country1);
		Region region2 = new Region("Toskana", country2);
		Region region3 = new Region("Normandie", country3);

		City city1 = new City("M�nchen", "88888", region1);
		City city2 = new City("Pisa", "12152", region2);
		City city3 = new City("Lille", "65594", region3);

		Set<Vine> vines1 = new HashSet<Vine>();
		Vine vine1 = new Vine("Merlot");
		vines1.add(vine1);
		Set<Vine> vines2 = new HashSet<Vine>();
		Vine vine2 = new Vine("Burgunder");
		vines2.add(vine2);
		Set<Vine> vines3 = new HashSet<Vine>();
		Vine vine3 = new Vine("Pinot Gris");
		Vine vine4 = new Vine("Gew�rztraminer");
		vines3.add(vine3);
		vines3.add(vine4);

		Winery winery1 = new Winery("H�usl");
		Winery winery2 = new Winery("Keller");
		Winery winery3 = new Winery("Brauer");

		Sort sort1 = new Sort("trocken");
		Sort sort2 = new Sort("halbtrocken");

		Type type1 = new Type("Rotwein");
		Type type2 = new Type("Wei�wein");

		int price1 = 1250;
		int price2 = 3000;
		int price3 = 2222;

		Wine wine1 = new Wine(
			winery1.getName() + " " + vine1.getName(),
			vines1,
			city1,
			sort1,
			type1,
			winery1,
			price1);
		Wine wine2 = new Wine(
			winery2.getName() + " " + vine2.getName(),
			vines2,
			city2,
			sort2,
			type2,
			winery2,
			price2);
		Wine wine3 = new Wine(
			winery3.getName() + " " + vine3.getName(),
			vines3,
			city3,
			sort1,
			type2,
			winery3,
			price3);

		EntityTransaction tx = null;

		try {
			tx = JpaUtil.getTx();
			tx.begin();
			JpaUtil.getEM().persist(wine1);
			JpaUtil.getEM().persist(wine2);
			JpaUtil.getEM().persist(wine3);
			tx.commit();
			Repository.getEventManager().fireAnyModelChanged(wine1);
		} catch(Exception e){
			if(tx != null){ tx.rollback(); }
			JOptionPane.showMessageDialog(null, "Das erstellen der Daten ist fehlgeschlagen", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
	}
}