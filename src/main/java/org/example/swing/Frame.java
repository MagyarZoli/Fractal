package org.example.swing;

import javax.swing.*;

public class Frame extends JFrame {

  public Frame(int iteration, int width, int height, double unitX, double unitY) {
    super("Mandelbrot");
    this.setSize(width, height);
    this.add(new Panel(iteration, unitX, unitY));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
}
