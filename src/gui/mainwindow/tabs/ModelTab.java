package gui.mainwindow.tabs;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import model.Model;
import events.AnyModelChangedListener;
import events.EventManager;
import events.ModelChangedEvent;
import gui.dialog.edit.EditDialog;
import gui.table.ModelTable;
import gui.table.ModelTableModel;
import gui.table.ModelTableScrollPane;

public abstract class ModelTab<T extends Model> extends JPanel implements AnyModelChangedListener {

	private static final long serialVersionUID = 6963316486962402827L;

	protected EventManager eventManager;

	protected ModelTableModel<T> tableModel;
	protected ModelTable<T> table;
	
	public ModelTab(EventManager eventManager) {
		this.eventManager = eventManager;
		eventManager.addAnyModelChangedListener(this);

		this.tableModel = initTableModel();
		this.table = initTable(tableModel);

		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, new ModelTableScrollPane<T>(table));
		add(BorderLayout.SOUTH, new TabButtonPanel<T>(this));
	}
	
	public abstract List<T> fetchData();

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
		return getTableModel().getRow(getTable()
			.getSelectionModel()
			.getMinSelectionIndex());
	}
	
	@Override
	public void modelChanged(ModelChangedEvent event) {
		// TODO Auto-generated method stub
		tableModel.setData(fetchData());
	}
	
	public void dispose(){
		eventManager.removeAnyModelChangedListener(this);
	}

}
