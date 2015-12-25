package organdonation;

import organdonation.entities.Entity;
import organdonation.states.State;
import organdonation.states.StateType;

public class FiniteStateMachine {
	private Entity _entity;
	private State _currentState;

	public FiniteStateMachine(Entity owner) {
		assert owner != null;

		_entity = owner;
	}

	public boolean setState(State state) {
		assert (state != null);

		if (!isTransitionValid(state)) {
			return false;
		}

		if (_currentState != null) {
			_currentState.exit();
		}
		_currentState = state;
		_currentState.enter();
		
		return true;
	}

	public void executeState() {
		assert _currentState != null;

		_currentState.execute();
	}

	private boolean isTransitionValid(State newState) {
		StateType oldStateType = _currentState.getType();
		StateType newStateType = newState.getType();

		if (_entity.transitionTable.containsKey(oldStateType)) {
			for (StateType type : _entity.transitionTable.values()) {
				if (type == newStateType) {
					return true;
				}
			}
		}

		return false;
	}
}
