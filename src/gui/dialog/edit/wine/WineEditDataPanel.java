package gui.dialog.edit.wine;

import java.util.HashSet;
import java.util.Set;

import gui.dialog.edit.EditDataPanel;
import gui.elements.ModelRenderer;
import gui.elements.VineSelector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import model.City;
import model.Sort;
import model.Type;
import model.Vine;
import model.Wine;
import model.Winery;

@SuppressWarnings("unchecked")
public class WineEditDataPanel extends EditDataPanel<Wine> {

	private static final long serialVersionUID = 646403762781205389L;

	private final WineEditDialog editDialog;

	private JSpinner price;
	private JComboBox<City> city;
	private JComboBox<Type> type;
	private JComboBox<Sort> sort;
	private JList<Vine> vine;
	private JComboBox<Winery> winery;
	
	public WineEditDataPanel(WineEditDialog editWindow) {
		super(editWindow.getModel());
		this.editDialog = editWindow;

		addName();
		addPrice();
		addType();
		addSort();
		addVine();
		addWinery();
		addCity();
	}

	private void addName() {
		add(new JLabel("Name"), next(0, ++gridy));
		add(name, next(1, gridy));
	}
	
	private void addPrice(){
		price = new JSpinner(new SpinnerNumberModel(model.getPrice()/100d, 0, 1000, 1));
		
		add(new JLabel("Preis (in €)"), next(0, ++gridy));
		add(price, next(1, gridy));
	}

	private void addCity() {
		City[] cities = editDialog.getCities().toArray(new City[0]);

		city = new JComboBox<City>(cities);
		city.setRenderer(new ModelRenderer<City>());
		city.setSelectedItem(model.getCity());

		add(new JLabel("Stadt"), next(0, ++gridy));
		add(city, next(1, gridy));
	}

	private void addSort() {
		Sort[] sorts = editDialog.getSorts().toArray(new Sort[0]);

		sort = new JComboBox<Sort>(sorts);
		sort.setRenderer(new ModelRenderer<Vine>());
		sort.setSelectedItem(model.getSort());

		add(new JLabel("Weinsorte"), next(0, ++gridy));
		add(sort, next(1, gridy));
	}

	private void addVine() {
		VineSelector vine = new VineSelector(editDialog.getVines());
		vine.setSelectedItems(model.getVine());
		
		this.vine = vine;

		JScrollPane scrollPane = new JScrollPane(vine);

		add(new JLabel("Rebsorten"), next(0, ++gridy));
		add(scrollPane, next(1, gridy));
	}

	private void addWinery() {
		Winery[] wineries = editDialog.getWineries().toArray(new Winery[0]);

		winery = new JComboBox<Winery>(wineries);
		winery.setRenderer(new ModelRenderer<Winery>());
		winery.setSelectedItem(model.getWinery());

		add(new JLabel("Winzer"), next(0, ++gridy));
		add(winery, next(1, gridy));
	}

	private void addType() {
		Type[] types = editDialog.getTypes().toArray(new Type[0]);

		type = new JComboBox<Type>(types);
		type.setRenderer(new ModelRenderer<Type>());
		type.setSelectedItem(model.getType());

		add(new JLabel("Weinart"), next(0, ++gridy));
		add(type, next(1, gridy));
	}

	public String getName() {
		return name.getText();
	}
	
	public int getPrice(){
		double d = (Double) price.getValue();
		d*= 100;
		return (int) d;
	}

	public City getCity() {
		return (City) city.getSelectedItem();
	}

	public Type getType() {
		return (Type) type.getSelectedItem();
	}

	public Sort getSort() {
		return (Sort) sort.getSelectedItem();
	}

	public Winery getWinery() {
		return (Winery) winery.getSelectedItem();
	}

	public Set<Vine> getVines() {
		Set<Vine> vines = new HashSet<Vine>(vine.getSelectedValuesList());
		return vines;
	}

}
