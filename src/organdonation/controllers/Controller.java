package organdonation.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.HashMap;
import java.util.Map;

import organdonation.entities.Direction;
import organdonation.entities.Entity;
import organdonation.states.AttackState;
import organdonation.states.IdleState;
import organdonation.states.WalkingState;

public abstract class Controller implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	protected static Map<Integer, Direction> _keyCodeToDirection = new HashMap<Integer, Direction>() {
		{
			put(KeyEvent.VK_UP, Direction.UP);
			put(KeyEvent.VK_DOWN, Direction.DOWN);
			put(KeyEvent.VK_LEFT, Direction.LEFT);
			put(KeyEvent.VK_RIGHT, Direction.RIGHT);
		}
	};

	protected Entity _entity;
	protected boolean _isDirectionKeyPressed = false;

	protected Controller(Entity entity) {
		_entity = entity;
		_isDirectionKeyPressed = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (_keyCodeToDirection.containsKey(e.getKeyCode())) {
			_isDirectionKeyPressed = true;
			Direction direction = _keyCodeToDirection.get(e.getKeyCode());
			_entity.getFiniteStateMachine().setState(new WalkingState(_entity, direction));
			_entity.getFiniteStateMachine().executeState();
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			_entity.getFiniteStateMachine().setState(new AttackState(_entity));
			_entity.getFiniteStateMachine().executeState();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (_keyCodeToDirection.containsKey(e.getKeyCode())) {
			_isDirectionKeyPressed = false;
			_entity.getFiniteStateMachine().setState(new IdleState(_entity));
		}
	}
}
