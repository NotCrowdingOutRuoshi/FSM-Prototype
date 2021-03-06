package organdonation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import organdonation.controllers.HumanController;
import organdonation.entities.sprites.Human;
import organdonation.states.StateType;

public class UserInterface implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	private HumanController _controller;

	public UserInterface() {
		/*
		 * The character type of this client will be given by server. This
		 * example assumes that the character type given by server is a human,
		 * so we new a Human instance as our entity.
		 */
		Human human = new Human();
		human.getFiniteStateMachine().setState(StateType.IDLE);
		human.getFiniteStateMachine().executeState();

		_controller = new HumanController(human);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		_controller.mouseWheelMoved(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		_controller.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		_controller.mouseMoved(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		_controller.mouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		_controller.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		_controller.mouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		_controller.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		_controller.mouseReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		_controller.keyPressed(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		_controller.keyReleased(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		_controller.keyTyped(arg0);
	}
}
