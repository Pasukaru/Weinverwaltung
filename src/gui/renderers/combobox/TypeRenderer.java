package gui.renderers.combobox;

import model.Type;

public class TypeRenderer extends ModelRenderer<Type> {

	private static final long serialVersionUID = 6745412362568365583L;

	@Override
	public String getValue(Type type) {
		return type.getName();
	}
}
