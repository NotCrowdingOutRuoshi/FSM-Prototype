package organdonation.states;

import organdonation.entities.Entity;

public class StealState extends State {
	private Entity _opponent;

	protected StealState(Entity entity, Entity opponent) {
		super(entity);
		
		assert opponent != null;
		
		_opponent = opponent;
	}

	@Override
	public void enter() {

	}

	@Override
	public void execute() {
		// Steal the _opponent's organ!
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}
