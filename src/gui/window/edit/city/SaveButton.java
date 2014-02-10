package gui.window.edit.city;

import gui.ActionButton;

import java.awt.event.ActionEvent;

import model.City;
import model.Region;
import util.Repository;

public class SaveButton extends ActionButton {

	private static final long serialVersionUID = 5049875329071992746L;

	private final City city;
	private final Region region;
	private final EditCityWindow editCityWindow;

	public SaveButton(EditCityWindow editCityWindow) {
		super();
		this.editCityWindow = editCityWindow;
		this.setText("Update");
		city = new City();
		region = new Region();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DataPanel data = editCityWindow.getDataPanel();
		city.setName(data.getName());
		city.setRegion(data.getRegion());
		region.setCountry(data.getCountry());
		Repository.getInstance().updateCity(city);
		editCityWindow.dispose();
		editCityWindow.getMainWindow().getTableModel().fireTableDataChanged();
	}
}
