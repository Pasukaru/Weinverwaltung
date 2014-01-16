package gui;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import model.Type;

public class TypeRenderer extends BasicComboBoxRenderer {

	private static final long serialVersionUID = 6745412362568365583L;

	@Override
	public Component getListCellRendererComponent(
		@SuppressWarnings("rawtypes") JList list, Object value, int index,
		boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(
			list,
			value,
			index,
			isSelected,
			cellHasFocus);

		if (value != null) {
			Type type = (Type) value;
			setText(type.getName());
		}

		return this;
	}
}
