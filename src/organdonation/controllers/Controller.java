package organdonation.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.HashMap;
import java.util.Map;

import organdonation.entities.Direction;
import organdonation.entities.sprites.Sprite;
import organdonation.states.StateType;

public abstract class Controller implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	protected static Map<Integer, Direction> _keyCodeToDirection = new HashMap<Integer, Direction>() {
		{
			put(KeyEvent.VK_UP, Direction.UP);
			put(KeyEvent.VK_DOWN, Direction.DOWN);
			put(KeyEvent.VK_LEFT, Direction.LEFT);
			put(KeyEvent.VK_RIGHT, Direction.RIGHT);
		}
	};

	protected Sprite _entity;
	protected boolean _isDirectionKeyPressed = false;

	protected Controller(Sprite sprite) {
		_entity = sprite;
		_isDirectionKeyPressed = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (_keyCodeToDirection.containsKey(e.getKeyCode())) {
			_isDirectionKeyPressed = true;

			if (_entity.getFiniteStateMachine().setState(StateType.WALK)) {
				_entity.getFiniteStateMachine().executeState();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE && _entity.getFiniteStateMachine().setState(StateType.ATTACK)) {
			_entity.getFiniteStateMachine().executeState();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (_keyCodeToDirection.containsKey(e.getKeyCode())) {
			_isDirectionKeyPressed = false;
			if (_entity.getFiniteStateMachine().setState(StateType.IDLE)) {
				_entity.getFiniteStateMachine().executeState();
			}
		}
	}
}
