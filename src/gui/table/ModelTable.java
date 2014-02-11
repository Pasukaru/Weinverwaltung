package gui.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.Model;

public class ModelTable<T extends Model> extends JTable {

	private static final long serialVersionUID = 4883419999473209610L;
	
	private ModelTableModel<T> tableModel;

	public ModelTable(ModelTableModel<T> tableModel){
		super(tableModel);
		this.tableModel = tableModel;
		this.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public T getSelectedModel(){
		return tableModel.getRow(
				getSelectionModel()
				.getMinSelectionIndex());
	}
	
	public void selectRow(T model){
		T tmp;
		for(int i = 0, n = tableModel.getRowCount(); i < n;  i++){
			tmp = tableModel.getRow(i);
			if(tmp == model){
				setRowSelectionInterval(i, i);
				break;
			}
		}
	}
	
	public void setData(List<T> data){
		T selectedModel = getSelectedModel();
		tableModel.setData(data);
		if(selectedModel != null){
			selectRow(selectedModel);
		}
	}
}
