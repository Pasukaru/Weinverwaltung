package gui.renderers.combobox;

import model.Region;

public class RegionRenderer extends ModelRenderer<Region> {

	private static final long serialVersionUID = 6745412362568365583L;

	@Override
	public String getValue(Region region){
		return region.getName();
	}
}
