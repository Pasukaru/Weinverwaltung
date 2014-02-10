package gui.dialog.edit.wine;

import gui.CityRenderer;
import gui.SortRenderer;
import gui.TypeRenderer;
import gui.VineRenderer;
import gui.WineryRenderer;
import gui.dialog.edit.EditDataPanel;

import java.awt.GridBagLayout;

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
public class EditWineDataPanel extends EditDataPanel<Wine> {

	private static final long serialVersionUID = 646403762781205389L;

	private final EditWineDialog editWindow;

	private JTextField name;
	private JComboBox<City> city;
	private JComboBox<Type> type;
	private JComboBox<Sort> sort;
	private JComboBox<Vine> vine;
	private JComboBox<Winery> winery;

	public EditWineDataPanel(final EditWineDialog editWindow) {
		super(editWindow.getModel());
		this.setLayout(new GridBagLayout());
		this.editWindow = editWindow;

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
		City[] cities = editWindow.getCities().toArray(new City[0]);

		city = new JComboBox<City>(cities);
		city.setRenderer(new CityRenderer());
		city.setSelectedItem(model.getCity());

		add(new JLabel("City"), next(0, ++gridy));
		add(city, next(1, gridy));
	}

	private void addSort() {
		Sort[] sorts = editWindow.getSorts().toArray(new Sort[0]);

		sort = new JComboBox<Sort>(sorts);
		sort.setRenderer(new SortRenderer());
		sort.setSelectedItem(model.getSort());

		add(new JLabel("Sort"), next(0, ++gridy));
		add(sort, next(1, gridy));
	}

	private void addVine() {
		Vine[] vines = editWindow.getVines().toArray(new Vine[0]);

		vine = new JComboBox<Vine>(vines);
		vine.setRenderer(new VineRenderer());
		vine.setSelectedItem(model.getVine());

		add(new JLabel("Vine"), next(0, ++gridy));
		add(vine, next(1, gridy));
	}

	private void addWinery() {
		Winery[] wineries = editWindow.getWineries().toArray(new Winery[0]);

		winery = new JComboBox<Winery>(wineries);
		winery.setRenderer(new WineryRenderer());
		winery.setSelectedItem(model.getWinery());

		add(new JLabel("Winery"), next(0, ++gridy));
		add(winery, next(1, gridy));
	}

	private void addType() {
		Type[] types = editWindow.getTypes().toArray(new Type[0]);

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
