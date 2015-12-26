package organdonation.states;

import organdonation.entities.sprites.Sprite;

public class IdleState extends State {
	public IdleState(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void enter() {
		_entity.setSpeed(0);
	}

	@Override
	public void execute() {
		_entity.setSpeed(0);
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

	@Override
	public StateType getType() {
		return StateType.IDLE;
	}
}
