package events;

import java.util.ArrayList;
import java.util.List;

import model.Model;

public class EventManager {

	private List<AnyModelChangedListener> anyModelChangedListeners;
	
	public EventManager(){
		anyModelChangedListeners = new ArrayList<AnyModelChangedListener>();
	}

	public void addAnyModelChangedListener(AnyModelChangedListener l) {
		anyModelChangedListeners.add(l);
	}

	public void removeAnyModelChangedListener(AnyModelChangedListener l) {
		anyModelChangedListeners.remove(l);
	}

	public void fireAnyModelChanged(Model model) {
		ModelChangedEvent event = new ModelChangedEvent(model);
		for (AnyModelChangedListener l : anyModelChangedListeners) {
			l.modelChanged(event);
		}
	}
}
