package organdonation.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.HashMap;
import java.util.Map;

import organdonation.entities.Direction;
import organdonation.entities.Human;
import organdonation.states.WalkingState;

public class HumanController extends Controller {
	private static Map<Integer, Direction> _keyCodeToDirection = new HashMap<Integer, Direction>() {
		{
			put(KeyEvent.VK_UP, Direction.UP);
			put(KeyEvent.VK_DOWN, Direction.DOWN);
			put(KeyEvent.VK_LEFT, Direction.LEFT);
			put(KeyEvent.VK_RIGHT, Direction.RIGHT);
		}
	};

	public HumanController(Human entity) {
		super(entity);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (_keyCodeToDirection.containsKey(e.getKeyChar())) {
			Direction direction = _keyCodeToDirection.get(e.getKeyCode());
			_entity.getFiniteStateMachine().setState(new WalkingState(_entity, direction));
			_entity.getFiniteStateMachine().executeState();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

	}

}
