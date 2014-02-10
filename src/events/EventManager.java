package events;

import java.util.List;

import model.Model;

public class EventManager {

	private List<ModelChangedListener> modelChangedListeners;

	public void addModelChangedListener(ModelChangedListener l) {
		modelChangedListeners.add(l);
	}

	public void removeModelChangedListener(ModelChangedListener l) {
		modelChangedListeners.remove(l);
	}

	public void fireModelChanged(Model model) {
		ModelChangedEvent event = new ModelChangedEvent(model);
		for (ModelChangedListener l : modelChangedListeners) {
			l.modelChanged(event);
		}
	}
}
