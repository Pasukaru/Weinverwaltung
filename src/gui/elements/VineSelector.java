package gui.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import model.Vine;

public class VineSelector extends JList<Vine> {

	private static final long serialVersionUID = -3221085435965101786L;

	@SuppressWarnings("unchecked")
	public VineSelector(List<Vine> vines){
		super(vines.toArray(new Vine[vines.size()]));
		setCellRenderer(new ModelRenderer<Vine>());
		setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		setVisibleRowCount(5);
	}
	
	public void setSelectedItems(Set<Vine> vines){
		List<Integer> indicesList = new ArrayList<Integer>();
		ListModel<Vine> lm = getModel();
		int vinesCount = lm.getSize();
		for(Vine s : vines){
			for(int i=0; i<vinesCount; i++){
				if(s == lm.getElementAt(i)){
					indicesList.add(i);
					break;
				}
			}
		}
		int[] indices = new int[indicesList.size()];
		for(int i=0,n=indices.length; i<n; i++){
			indices[i] = indicesList.get(i);
		}
		setSelectedIndices(indices);
	}
}
