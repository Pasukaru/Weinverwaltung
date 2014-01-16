package gui;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import model.City;

public class CityRenderer extends BasicComboBoxRenderer {

	private static final long serialVersionUID = 6745412362568365583L;

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
		int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(
			list,
			value,
			index,
			isSelected,
			cellHasFocus);

		if (value != null) {
			City city = (City) value;
			setText(city.getName());
		}

		return this;
	}
}
