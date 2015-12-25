package organdonation.entities;

import organdonation.states.StateType;

public class Human extends Entity {
	public Human() {

	}

	@Override
	protected void initTransitionTable() {
		transitionTable.put(StateType.IDLE, StateType.ATTACK);
		transitionTable.put(StateType.ATTACK, StateType.IDLE);
		transitionTable.put(StateType.ATTACK, StateType.STEAL);
		transitionTable.put(StateType.STEAL, StateType.IDLE);

		transitionTable.put(StateType.IDLE, StateType.WALK);
		transitionTable.put(StateType.WALK, StateType.IDLE);
	}
}
