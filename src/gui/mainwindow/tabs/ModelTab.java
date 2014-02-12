package gui.mainwindow.tabs;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import util.Repository;
import model.Model;
import events.AnyModelChangedListener;
import events.ModelChangedEvent;
import gui.dialog.edit.EditDialog;
import gui.table.ModelTable;
import gui.table.ModelTableModel;
import gui.table.ModelTableScrollPane;

public abstract class ModelTab<T extends Model> extends JPanel implements AnyModelChangedListener {
	
	private final Class<T> clazz;

	private static final long serialVersionUID = 6963316486962402827L;

	protected ModelTableModel<T> tableModel;
	protected ModelTable<T> table;
	
	public ModelTab(Class<T> model) {
		this.clazz = model;
		this.tableModel = initTableModel();
		this.table = initTable(tableModel);

		Repository.getEventManager().addAnyModelChangedListener(this);

		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, new ModelTableScrollPane<T>(table));
		add(BorderLayout.SOUTH, new TabButtonPanel<T>(this));
	}
	
	public List<T> fetchData(){
		return Repository.getInstance(clazz).getAll();
	};

	public abstract ModelTableModel<T> initTableModel();

	public ModelTable<T> initTable(ModelTableModel<T> tableModel){
		return new ModelTable<T>(tableModel);
	}

	public abstract EditDialog<T> getCreateDialog();
	public abstract EditDialog<T> getEditDialog();

	public ModelTable<T> getTable(){
		return table;
	}
	
	public ModelTableModel<T> getTableModel(){
		return tableModel;
	}
	
	public T getSelectedModel() {
		return table.getSelectedModel();
	}
	
	@Override
	public void modelChanged(ModelChangedEvent event) {
		table.setData(fetchData());
	}
	
	public void dispose(){
		Repository.getEventManager().removeAnyModelChangedListener(this);
	}

}
