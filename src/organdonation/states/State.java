package organdonation.states;

import organdonation.entities.Entity;

public abstract class State {
	protected Entity _entity;

	protected State(Entity entity) {
		assert entity != null;

		_entity = entity;
	}

	public abstract void enter();

	public abstract void execute();

	public abstract void exit();
}
