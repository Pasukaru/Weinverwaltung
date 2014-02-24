package gui.dialog.edit.wine;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;
import java.util.List;

import repository.Repository;
import model.City;
import model.Sort;
import model.Type;
import model.Vine;
import model.Wine;
import model.Winery;

public class WineEditDialog extends EditDialog<Wine> {

	private static final long serialVersionUID = -9141574978152096541L;

	private List<City> cities;
	private List<model.Type> types;
	private List<Sort> sorts;
	private List<Vine> vines;
	private List<Winery> wineries;

	private EditButtonPanel<Wine> buttonsPanel;

	public WineEditDialog(Wine model) {
		super(model);

		setTitle(isCreate() ? "Wein hinzufügen" : "Wein bearbeiten");

		cities = Repository.getInstance(City.class).getAll();
		types = Repository.getInstance(Type.class).getAll();
		sorts = Repository.getInstance(Sort.class).getAll();
		vines = Repository.getInstance(Vine.class).getAll();
		wineries = Repository.getInstance(Winery.class).getAll();

		add(dataPanel = new WineEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<Wine>(this), BorderLayout.SOUTH);
	}

	@Override
	protected List<String> validateModel() {
		List<String> errors = super.validateModel();

		WineEditDataPanel dataPanel = getDataPanel();
		if(dataPanel.getPrice()<1){
			errors.add("Bitte einen Preis angeben");
		}
		if(dataPanel.getType() == null){
			errors.add("Bitte eine Weinart auswählen");
		}
		if(dataPanel.getSort() == null){
			errors.add("Bitte eine Weinsorte auswählen");
		}
		if(dataPanel.getVines().isEmpty()){
			errors.add("Bitte mindestens eine Rebsorte auswählen");
		}
		if(dataPanel.getWinery() == null){
			errors.add("Bitte einen Winzer auswählen");
		}
		if(dataPanel.getCity() == null){
			errors.add("Bitte eine Stadt auswählen");
		}

		return errors;
	}
	
	@Override
	public void save(){
		
		WineEditDataPanel dataPanel = getDataPanel();
		
		model.setName(dataPanel.getName());
		model.setPrice(dataPanel.getPrice());
		model.setCity(dataPanel.getCity());
		model.setType(dataPanel.getType());
		model.setSort(dataPanel.getSort());
		model.setWinery(dataPanel.getWinery());
		model.setVine(dataPanel.getVines());

		Repository.getInstance(Wine.class).update(model);
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
		return (WineEditDataPanel) dataPanel;
	}

	public EditButtonPanel<Wine> getButtonsPanel() {
		return buttonsPanel;
	}
}
