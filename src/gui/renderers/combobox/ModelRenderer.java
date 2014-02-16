package gui.renderers.combobox;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import model.Model;

public class ModelRenderer<T extends Model> extends
	BasicComboBoxRenderer {

	private static final long serialVersionUID = 6745412362568365583L;

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public Component getListCellRendererComponent(
		JList list, Object value, int index,
		boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(
			list,
			value,
			index,
			isSelected,
			cellHasFocus);

		setText(value == null ? "---" : ((T) value).getName());

		return this;
	}

	public String getValue(T model){
		return model.getName();
	}
}
