package gui.renderers.combobox;

import model.City;

public class CityRenderer extends ModelRenderer<City> {

	private static final long serialVersionUID = 6745412362568365583L;

	@Override
	public String getValue(City city) {
		return city.getName();
	}
}
