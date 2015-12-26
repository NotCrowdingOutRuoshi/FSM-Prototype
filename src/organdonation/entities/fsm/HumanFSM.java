package organdonation.entities.fsm;

import organdonation.entities.sprites.Human;
import organdonation.states.IdleState;
import organdonation.states.SpecialAttackState;
import organdonation.states.StateType;
import organdonation.states.StealState;
import organdonation.states.WalkState;

public class HumanFSM extends FiniteStateMachine {

	public HumanFSM(Human owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	/*
	 * Every character type has it's own state transition.
	 */
	protected void initTransitionTable() {
		_transitionTable.put(StateType.IDLE, StateType.ATTACK);
		_transitionTable.put(StateType.ATTACK, StateType.IDLE);
		_transitionTable.put(StateType.ATTACK, StateType.STEAL);
		_transitionTable.put(StateType.STEAL, StateType.IDLE);

		_transitionTable.put(StateType.IDLE, StateType.WALK);
		_transitionTable.put(StateType.WALK, StateType.IDLE);
	}

	@Override
	/*
	 * Every character type may has it's own special actions (actions are
	 * determined by State classes). By doing this, if there is a special
	 * character that has a special action, all we need to do is just create a
	 * new State class, and adds this class into the_stateEntityTranslationTable
	 * like the following:
	 */
	protected void initEntityTranslationTable() {
		_stateEntityTranslationTable.put(StateType.IDLE, new IdleState(_entity));
		_stateEntityTranslationTable.put(StateType.WALK, new WalkState(_entity));

		// Here is the special attack state!
		_stateEntityTranslationTable.put(StateType.ATTACK, new SpecialAttackState(_entity));

		_stateEntityTranslationTable.put(StateType.STEAL, new StealState(_entity));
	}

}
