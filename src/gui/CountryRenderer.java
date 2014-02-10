package gui;

import model.Country;

public class CountryRenderer extends ModelRenderer<Country> {

	private static final long serialVersionUID = 6745412362568365583L;

	@Override
	public String getValue(Country country) {
		return country.getName();
	}
}
