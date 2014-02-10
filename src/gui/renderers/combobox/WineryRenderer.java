package gui.renderers.combobox;

import model.Winery;

public class WineryRenderer extends ModelRenderer<Winery> {

	private static final long serialVersionUID = 6745412362568365583L;

	@Override
	public String getValue(Winery winery) {
		return winery.getName();
	}
}
