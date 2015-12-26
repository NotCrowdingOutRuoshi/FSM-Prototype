package organdonation.entities.fsm;

import java.util.HashMap;
import java.util.Map;

import organdonation.entities.sprites.Sprite;
import organdonation.states.State;
import organdonation.states.StateType;

public abstract class FiniteStateMachine {
	protected Map<StateType, StateType> _transitionTable;
	protected Map<StateType, State> _stateEntityTranslationTable;
	protected Sprite _entity;
	private State _currentState;

	protected abstract void initTransitionTable();

	protected abstract void initEntityTranslationTable();

	protected FiniteStateMachine(Sprite owner) {
		assert owner != null;

		_entity = owner;
		_transitionTable = new HashMap<StateType, StateType>();
		_stateEntityTranslationTable = new HashMap<StateType, State>();
	}

	public boolean setState(StateType stateType) {
		assert (stateType != null);

		if (!isTransitionValid(stateType)) {
			return false;
		}

		if (_currentState != null) {
			_currentState.exit();
		}

		assert (_stateEntityTranslationTable.containsKey(stateType));

		_currentState = _stateEntityTranslationTable.get(stateType);

		assert (_currentState != null);

		_currentState.enter();

		return true;
	}

	public void executeState() {
		assert (_currentState != null);

		_currentState.execute();
	}

	private boolean isTransitionValid(StateType stateType) {
		StateType oldStateType = _currentState.getType();

		if (_transitionTable.containsKey(oldStateType)) {
			for (StateType type : _transitionTable.values()) {
				if (type == stateType) {
					return true;
				}
			}
		}

		return false;
	}
}
