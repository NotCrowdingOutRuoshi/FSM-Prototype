package organdonation.entities.sprites;

import organdonation.entities.FiniteStateMachine;
import organdonation.states.IdleState;
import organdonation.states.SpecialAttackState;
import organdonation.states.StateType;
import organdonation.states.StealState;
import organdonation.states.WalkState;

public class Wolf extends Sprite {
	public Wolf() {

	}

	@Override
	protected void initFiniteStateMachine() {
		_fs = new FiniteStateMachine(this);
	}

	@Override
	protected void initTransitionTable() {
		_fs.addTransition(StateType.IDLE, StateType.ATTACK);
		_fs.addTransition(StateType.ATTACK, StateType.IDLE);

		// Compares to Human, a Wolf cannot steal items from others.
		// _fs.addTransition(StateType.ATTACK, StateType.STEAL);
		// _fs.addTransition(StateType.STEAL, StateType.IDLE);

		_fs.addTransition(StateType.IDLE, StateType.WALK);
		_fs.addTransition(StateType.WALK, StateType.IDLE);
	}

	@Override
	protected void initStateEntityTranslationTable() {
		_fs.addStateTranslation(StateType.IDLE, new IdleState(this));
		_fs.addStateTranslation(StateType.WALK, new WalkState(this));

		// Customized special attack here!
		_fs.addStateTranslation(StateType.ATTACK, new SpecialAttackState(this));

		_fs.addStateTranslation(StateType.STEAL, new StealState(this));
	}

}
