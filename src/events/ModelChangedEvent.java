package events;

import model.Model;

public class ModelChangedEvent {

	private final Model model;

	public ModelChangedEvent(Model model) {
		this.model = model;
	}

	public Model getModel() {
		return model;
	}
}
