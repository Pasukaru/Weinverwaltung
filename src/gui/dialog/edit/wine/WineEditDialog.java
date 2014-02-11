package gui.dialog.edit.wine;

import events.EventManager;
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

	private List<City> cities;
	private List<model.Type> types;
	private List<Sort> sorts;
	private List<Vine> vines;
	private List<Winery> wineries;

	private WineEditDataPanel dataPanel;
	private EditButtonPanel<Wine> buttonsPanel;

	public WineEditDialog(final Wine wine, EventManager eventManager) {
		super(wine, eventManager);

		setTitle(isCreate() ? "Create Wine" : "Edit Wine");
		
		Repository repo = Repository.getInstance();
		cities = repo.getAllCities();
		types = repo.getAllTypes();
		sorts = repo.getAllSorts();
		vines = repo.getAllVines();
		wineries = repo.getAllWineries();

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
		dispose();
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
