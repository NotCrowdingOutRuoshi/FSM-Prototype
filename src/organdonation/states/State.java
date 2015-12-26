package organdonation.states;

import organdonation.entities.sprites.Sprite;

public abstract class State {
	protected Sprite _entity;

	protected State(Sprite sprite) {
		assert sprite != null;

		_entity = sprite;
	}

	public abstract void enter();

	public abstract void execute();

	public abstract void exit();

	public abstract StateType getType();
}
