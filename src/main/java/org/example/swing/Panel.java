package org.example.swing;

import org.example.formula.Mandelbrot;
import org.example.model.ComplexNumber;
import org.example.model.PanelCoordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel implements MouseMovedMotionListener {

  private final int iteration;
  private final double unitX;
  private final double unitY;
  private List<ComplexNumber> complexNumbers;
  private Mandelbrot mandelbrot;

  public Panel(int iteration, double unitX, double unitY) {
    this.unitX = unitX;
    this.unitY = unitY;
    this.iteration = iteration;
    complexNumbers = new ArrayList<>();
    addMouseMotionListener(this);
    setBackground(Color.BLACK);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = getWidth();
    int height = getHeight();
    paintCartesianCoordinateSystem(g, width, height);
    paintFractal(g, panelCoordinateList(width, height));
    paintComplexNumber(g);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    PanelCoordinate mousePanelCoordinate = new PanelCoordinate(e.getX(), e.getY());
    ComplexNumber c = ComplexNumber.parseComplexNumber(mousePanelCoordinate, getWidth(), getHeight(), unitX, unitY);
    complexNumbers.clear();
    mandelbrot = new Mandelbrot(iteration, c);
    mandelbrot.mandelbrotSet(complexNumbers);

    repaint();
  }

  private List<PanelCoordinate> panelCoordinateList(int width, int height) {
    List<PanelCoordinate> list = new ArrayList<>();
    for (ComplexNumber c : complexNumbers) {
      list.add(PanelCoordinate.parsePanelCoordinate(c, width, height, unitX, unitY));
    }
    return list;
  }

  private void paintCartesianCoordinateSystem(Graphics g, int width, int height) {
    int centerX = width / 2;
    int centerY = height / 2;
    g.setColor(Color.GRAY);
    g.drawLine(0, centerY, width, centerY);
    g.drawLine(centerX, 0, centerX, height);
  }

  private void paintFractal(Graphics g, List<PanelCoordinate> list) {
    for (int i = 1; i < list.size(); i++) {
      PanelCoordinate coordinate1 = list.get(i - 1);
      PanelCoordinate coordinate2 = list.get(i);
      g.setColor(Color.YELLOW);
      g.fillOval(coordinate2.getX(), coordinate2.getY(), 4, 4);
      g.setColor(Color.WHITE);
      g.drawLine(coordinate1.getX(), coordinate1.getY(), coordinate2.getX(), coordinate2.getY());
    }
  }

  private void paintComplexNumber(Graphics g) {
    if (!complexNumbers.isEmpty()) {
      g.setColor(Color.GREEN);
      g.drawString("C = " + complexNumbers.get(1).toStringFormat(), 10, 20);
    }
  }
}
