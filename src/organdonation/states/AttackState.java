package organdonation.states;

import organdonation.entities.Entity;
import organdonation.entities.Wolf;

public class AttackState extends State {
	public AttackState(Entity entity) {
		super(entity);
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute() {
		// Check if there is any player in front of itself and is can be stolen.
		// We assumes that the opponent which can be stolen is a Wolf.
		Entity opponent = new Wolf();

		if (opponent != null) {
			_entity.getFiniteStateMachine().setState(new StealState(_entity, opponent));
			_entity.getFiniteStateMachine().executeState();
		}
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}
}
