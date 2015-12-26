package organdonation.entities.sprites;

import organdonation.entities.Direction;
import organdonation.entities.FiniteStateMachine;

public abstract class Sprite {

	protected int _x;
	protected int _y;
	protected int _speed;
	protected Direction _direction;
	protected FiniteStateMachine _fs;

	protected abstract void initTransitionTable();

	protected abstract void initStateEntityTranslationTable();

	public Sprite() {
		_x = 0;
		_y = 0;
		_speed = 0;
		_direction = Direction.RIGHT;
		_fs = new FiniteStateMachine(this);
		initFiniteStateMachine();
		initTransitionTable();
		initStateEntityTranslationTable();
	}

	public int getX() {
		return _x;
	}

	public void setX(int x) {
		_x = x;
	}

	public int getY() {
		return _y;
	}

	public void setY(int y) {
		_y = y;
	}

	public int getSpeed() {
		return _speed;
	}

	public void setSpeed(int speed) {
		_speed = speed;
	}

	public Direction getDirection() {
		return _direction;
	}

	public void setDirection(Direction direction) {
		boolean isDirectionExist = false;

		for (Direction dir : Direction.values()) {
			if (dir == direction) {
				isDirectionExist = true;
			}
		}

		assert isDirectionExist;

		_direction = direction;
	}

	public FiniteStateMachine getFiniteStateMachine() {
		assert _fs != null;
		return _fs;
	}

	protected abstract void initFiniteStateMachine();
}
