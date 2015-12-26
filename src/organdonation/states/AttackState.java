package organdonation.states;

import organdonation.entities.sprites.Sprite;
import organdonation.entities.sprites.Wolf;

public class AttackState extends State {
	public AttackState(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute() {
		// Check if there is any player in front of itself and is can be stolen.
		// We assumes that the opponent which can be stolen is a Wolf.
		Sprite opponent = new Wolf();

		if (opponent != null && _entity.getFiniteStateMachine().setState(StateType.STEAL)) {
			_entity.getFiniteStateMachine().executeState();
		}
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

	@Override
	public StateType getType() {
		return StateType.ATTACK;
	}
}
