package organdonation.entity;

import organdonation.FiniteStateMachine;

public abstract class Entity {
	protected int _x;
	protected int _y;
	protected int _speed;
	protected Direction _direction;
	protected FiniteStateMachine _fs;
	
	public Entity() {
		_x = 0;
		_y = 0;
		_speed = 0;
		_direction = Direction.RIGHT;
		_fs = new FiniteStateMachine(this);
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
		return _fs;
	}
}
