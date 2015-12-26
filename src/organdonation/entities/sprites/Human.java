package organdonation.entities.sprites;

import organdonation.entities.FiniteStateMachine;
import organdonation.states.AttackState;
import organdonation.states.IdleState;
import organdonation.states.StateType;
import organdonation.states.StealState;
import organdonation.states.WalkState;

public class Human extends Sprite {
	public Human() {

	}

	@Override
	protected void initFiniteStateMachine() {
		_fs = new FiniteStateMachine(this);
	}

	@Override
	protected void initTransitionTable() {
		_fs.addTransition(StateType.IDLE, StateType.ATTACK);
		_fs.addTransition(StateType.ATTACK, StateType.IDLE);
		_fs.addTransition(StateType.ATTACK, StateType.STEAL);
		_fs.addTransition(StateType.STEAL, StateType.IDLE);

		_fs.addTransition(StateType.IDLE, StateType.WALK);
		_fs.addTransition(StateType.WALK, StateType.IDLE);
	}

	@Override
	protected void initStateEntityTranslationTable() {
		_fs.addStateTranslation(StateType.IDLE, new IdleState(this));
		_fs.addStateTranslation(StateType.WALK, new WalkState(this));
		_fs.addStateTranslation(StateType.ATTACK, new AttackState(this));
		_fs.addStateTranslation(StateType.STEAL, new StealState(this));
	}
}
