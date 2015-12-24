package organdonation.states;

import organdonation.entities.Direction;
import organdonation.entities.Entity;

public class WalkingState extends State {
	private Direction _direction;

	public WalkingState(Entity entity, Direction direction) {
		super(entity);

		boolean isDirectionExist = false;

		for (Direction dir : Direction.values()) {
			if (dir == direction) {
				isDirectionExist = true;
			}
		}

		assert isDirectionExist;

		_direction = direction;
	}

	@Override
	public void enter() {
		_entity.setDirection(_direction);
	}

	@Override
	public void execute() {
		_entity.setDirection(_direction);
		_entity.setX(_entity.getX() + _entity.getSpeed());
	}

	@Override
	public void exit() {
		_entity.setSpeed(0);
	}
}
