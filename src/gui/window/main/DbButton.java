package gui.window.main;

import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

import gui.ActionButton;

public class DbButton extends ActionButton{

	private static final long serialVersionUID = -4715489416822515615L;

	public DbButton(){
		super("Reset DB");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		setDbData();
		JOptionPane.showMessageDialog(null, "Db filled");
	}

	private void setDbData(){

	      JpaUtil.init("WEINVERWALTUNG");

	      EntityTransaction tx = JpaUtil.getTx();

	      Country country1 = new Country("Deutschland");
	      Country country2 = new Country("Italien");
	      Country country3 = new Country("Frankreich");

	      Region region1 = new Region("Oberbayern", country1);
	      Region region2 = new Region("Toskana", country2);
	      Region region3 = new Region("Normandie", country3);

	      City city1 = new City("München" , 88888, region1);
	      City city2 = new City("Pisa" , 12152, region2);
	      City city3 = new City("Lille" , 65594, region3);

	      Set <Vine> vines1 = new HashSet<Vine>();
	      Vine vine1 = new Vine("Merlot");
	      vines1.add(vine1);
	      Set <Vine> vines2 = new HashSet<Vine>();
	      Vine vine2 = new Vine("Burgunder");
	      vines2.add(vine2);
	      Set <Vine> vines3 = new HashSet<Vine>();
	      Vine vine3 = new Vine("Pinot Gris");
	      Vine vine4 = new Vine("Gewürztraminer");
	      vines3.add(vine3);
	      vines3.add(vine4);

	      Winery winery1 = new Winery("Häusl");
	      Winery winery2 = new Winery("Keller");
	      Winery winery3= new Winery("Brauer");

	      Sort sort1 = new Sort("trocken");
	      Sort sort2 = new Sort("halbtrocken");

	      Type type1 = new Type("Rotwein");
	      Type type2 = new Type("Weißwein");

	      Wine wine1 = new Wine(winery1.getName()+ " "+ vine1.getName(), vines1, city1, sort1, type1, winery1);
	      Wine wine2 = new Wine(winery2.getName()+ " "+ vine2.getName(), vines2, city2, sort2, type2, winery2);
	      Wine wine3 = new Wine(winery3.getName()+ " "+ vine3.getName(), vines3, city3, sort1, type2, winery3);

	      tx.begin();
	      JpaUtil.getEM().persist(country1);
	      JpaUtil.getEM().persist(country2);
	      JpaUtil.getEM().persist(country3);
	      JpaUtil.getEM().persist(region1);
	      JpaUtil.getEM().persist(region2);
	      JpaUtil.getEM().persist(region3);
	      JpaUtil.getEM().persist(city1);
	      JpaUtil.getEM().persist(city2);
	      JpaUtil.getEM().persist(city3);
	      JpaUtil.getEM().persist(vine1);
	      JpaUtil.getEM().persist(vine2);
	      JpaUtil.getEM().persist(vine3);
	      JpaUtil.getEM().persist(vine4);
	      JpaUtil.getEM().persist(winery1);
	      JpaUtil.getEM().persist(winery2);
	      JpaUtil.getEM().persist(winery3);
	      JpaUtil.getEM().persist(sort1);
	      JpaUtil.getEM().persist(sort2);
	      JpaUtil.getEM().persist(type1);
	      JpaUtil.getEM().persist(type2);
	      JpaUtil.getEM().persist(wine1);
	      JpaUtil.getEM().persist(wine2);
	      JpaUtil.getEM().persist(wine3);
	      tx.commit();

	}
}
