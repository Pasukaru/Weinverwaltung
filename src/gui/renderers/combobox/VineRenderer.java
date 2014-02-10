package gui.renderers.combobox;

import model.Vine;

public class VineRenderer extends ModelRenderer<Vine> {

	private static final long serialVersionUID = 6745412362568365583L;

	@Override
	public String getValue(Vine vine) {
		return vine.getName();
	}
}
