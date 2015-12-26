package organdonation.entities.sprites;

import organdonation.entities.fsm.HumanFSM;

public class Human extends Sprite {
	public Human() {

	}

	@Override
	protected void initFiniteStateMachine() {
		_fs = new HumanFSM(this);
	}
}
