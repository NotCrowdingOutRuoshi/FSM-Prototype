package organdonation.states;

import organdonation.entities.sprites.Sprite;

public class StealState extends State {
	public StealState(Sprite sprite) {
		super(sprite);
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

	@Override
	public StateType getType() {
		return StateType.STEAL;
	}

}
