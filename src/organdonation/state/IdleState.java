package organdonation.state;

import organdonation.entity.Entity;

public class IdleState extends State {
	public IdleState(Entity entity) {
		super(entity);
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
}
