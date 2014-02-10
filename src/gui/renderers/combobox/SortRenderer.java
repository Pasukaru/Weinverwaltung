package gui.renderers.combobox;

import model.Sort;

public class SortRenderer extends ModelRenderer<Sort> {

	private static final long serialVersionUID = 6745412362568365583L;

	@Override
	public String getValue(Sort sort) {
		return sort.getName();
	}
}
