package organdonation.states;

import organdonation.entities.Direction;
import organdonation.entities.sprites.Sprite;

public class WalkState extends State {
	private Direction _direction;

	public WalkState(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void enter() {
		_entity.setDirection(_direction);
	}

	@Override
	public void execute() {
		Direction direction = _entity.getDirection();

		// Judge the direction and performs walk effect. For example:
		if (direction == Direction.RIGHT) {
			_entity.setX(_entity.getX() + _entity.getSpeed());
		}
	}

	@Override
	public void exit() {
		_entity.setSpeed(0);
	}

	@Override
	public StateType getType() {
		return StateType.WALK;
	}
}
