package organdonation;

import organdonation.entities.Entity;
import organdonation.states.State;

public class FiniteStateMachine {
	private Entity _entity;
	private State _currentState;

	public FiniteStateMachine(Entity owner) {
		assert owner != null;

		_entity = owner;
	}

	public void setState(State state) {
		assert (state != null);

		if (_currentState != null) {
			_currentState.exit();
		}

		_currentState = state;

		_currentState.enter();
	}

	public void executeState() {
		assert _currentState != null;

		_currentState.execute();
	}
}
