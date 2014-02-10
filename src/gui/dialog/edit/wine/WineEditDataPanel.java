package gui.dialog.edit.wine;

import gui.dialog.edit.EditDataPanel;
import gui.renderers.combobox.CityRenderer;
import gui.renderers.combobox.SortRenderer;
import gui.renderers.combobox.TypeRenderer;
import gui.renderers.combobox.VineRenderer;
import gui.renderers.combobox.WineryRenderer;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

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

	private JTextField name;
	private JComboBox<City> city;
	private JComboBox<Type> type;
	private JComboBox<Sort> sort;
	private JComboBox<Vine> vine;
	private JComboBox<Winery> winery;

	public WineEditDataPanel(WineEditDialog editWindow) {
		super(editWindow.getModel());
		this.editDialog = editWindow;

		addName();
		addCity();
		addType();
		addSort();
		addVine();
		addWinery();
	}
	
	private void addName() {
		name = new JTextField();
		if (model != null) {
			name.setText(model.getName());
		} else {
			name.setText("");
		}
		add(new JLabel("Name"), next(0, ++gridy));
		add(name, next(1, gridy));
	}

	private void addCity() {
		City[] cities = editDialog.getCities().toArray(new City[0]);

		city = new JComboBox<City>(cities);
		city.setRenderer(new CityRenderer());
		city.setSelectedItem(model.getCity());

		add(new JLabel("City"), next(0, ++gridy));
		add(city, next(1, gridy));
	}

	private void addSort() {
		Sort[] sorts = editDialog.getSorts().toArray(new Sort[0]);

		sort = new JComboBox<Sort>(sorts);
		sort.setRenderer(new SortRenderer());
		sort.setSelectedItem(model.getSort());

		add(new JLabel("Sort"), next(0, ++gridy));
		add(sort, next(1, gridy));
	}

	private void addVine() {
		Vine[] vines = editDialog.getVines().toArray(new Vine[0]);

		vine = new JComboBox<Vine>(vines);
		vine.setRenderer(new VineRenderer());
		vine.setSelectedItem(model.getVine());

		add(new JLabel("Vine"), next(0, ++gridy));
		add(vine, next(1, gridy));
	}

	private void addWinery() {
		Winery[] wineries = editDialog.getWineries().toArray(new Winery[0]);

		winery = new JComboBox<Winery>(wineries);
		winery.setRenderer(new WineryRenderer());
		winery.setSelectedItem(model.getWinery());

		add(new JLabel("Winery"), next(0, ++gridy));
		add(winery, next(1, gridy));
	}

	private void addType() {
		Type[] types = editDialog.getTypes().toArray(new Type[0]);

		type = new JComboBox<Type>(types);
		type.setRenderer(new TypeRenderer());
		type.setSelectedItem(model.getType());

		add(new JLabel("Type"), next(0, ++gridy));
		add(type, next(1, gridy));
	}

	public String getName() {
		return name.getText();
	}

	public City getCity() {
		return (City) city.getSelectedItem();
	}

	public Type getType() {
		return (Type) type.getSelectedItem();
	}

}
