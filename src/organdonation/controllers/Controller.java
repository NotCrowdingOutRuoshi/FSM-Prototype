package organdonation.controllers;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import organdonation.entities.Entity;

public abstract class Controller implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	protected Entity _entity;

	protected Controller(Entity entity) {
		_entity = entity;
	}
}
