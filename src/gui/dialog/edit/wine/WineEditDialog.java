package gui.dialog.edit.wine;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;
import java.util.List;

import model.City;
import model.Sort;
import model.Vine;
import model.Wine;
import model.Winery;
import util.Repository;

public class WineEditDialog extends EditDialog<Wine> {

	private static final long serialVersionUID = -9141574978152096541L;

	private final List<City> cities;
	private final List<model.Type> types;
	private final List<Sort> sorts;
	private final List<Vine> vines;
	private final List<Winery> wineries;

	private final WineEditDataPanel dataPanel;
	private final EditButtonPanel<Wine> buttonsPanel;

	public WineEditDialog(final Wine wine) {
		super(wine);

		setTitle(isCreate() ? "Create Wine" : "Edit Wine");
		
		cities = Repository.getInstance().getAllCities();
		types = Repository.getInstance().getAllTypes();
		sorts = Repository.getInstance().getAllSorts();
		vines = Repository.getInstance().getAllVines();
		wineries = Repository.getInstance().getAllWineries();

		add(dataPanel = new WineEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<Wine>(this), BorderLayout.SOUTH);
	}
	
	@Override
	public void save(){
		model.setName(dataPanel.getName());
		model.setCity(dataPanel.getCity());
		model.setType(dataPanel.getType());
		//TODO update these properties in the model
		//model.setSort(dataP);
		//model.setVine(dataPanel.getvin);
		//model.getWinery(dataPanel.getw);
		Repository.getInstance().updateModel(model);
		close();
	}

	public List<City> getCities() {
		return cities;
	}

	public List<model.Type> getTypes() {
		return types;
	}

	public List<Sort> getSorts() {
		return sorts;
	}

	public List<Vine> getVines() {
		return vines;
	}

	public List<Winery> getWineries() {
		return wineries;
	}

	public WineEditDataPanel getDataPanel() {
		return dataPanel;
	}

	public EditButtonPanel<Wine> getButtonsPanel() {
		return buttonsPanel;
	}
}
