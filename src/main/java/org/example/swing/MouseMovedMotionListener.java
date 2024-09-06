package org.example.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Az egér mozgatási eseményeit kezeli anélkül,
 * hogy az egér húzási eseményeket is kezelni kellene.
 */
public interface MouseMovedMotionListener extends MouseMotionListener {

  /**
   * Ignorált függvény.
   * @param e the event to be processed
   */
  @Override
  default void mouseDragged(MouseEvent e) {}
}
