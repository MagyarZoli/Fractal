package org.example.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public interface MouseMovedMotionListener extends MouseMotionListener {

  @Override
  default void mouseDragged(MouseEvent e) {}
}
