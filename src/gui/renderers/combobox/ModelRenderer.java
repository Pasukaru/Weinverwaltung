package gui.renderers.combobox;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import model.Model;

public abstract class ModelRenderer<T extends Model> extends
	BasicComboBoxRenderer {

	private static final long serialVersionUID = 6745412362568365583L;

	@SuppressWarnings("unchecked")
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

		String text;

		if (value == null) {
			text = "---";
		} else {
			text = this.getValue((T) value);
		}
		setText(text);

		return this;
	}

	public abstract String getValue(T model);
}
