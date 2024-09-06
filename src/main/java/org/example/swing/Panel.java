package org.example.swing;

import org.example.formula.Mandelbrot;
import org.example.model.ComplexNumber;
import org.example.model.PanelCoordinate;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Mandelbrot-halmaz grafikus megjelenítésére szolgál.
 * Az osztály interaktív, figyeli az egér mozgását, és ennek megfelelően frissíti a megjelenített halmazt.
 * Az egér pozíciója alapján újrateremti a Mandelbrot-halmazt, amelyet a panelen megjelenít.
 */
public class Panel extends JPanel implements MouseMovedMotionListener {

  /**
   * Az iterációk maximális száma, amely meghatározza, hogy hányszor hajtódik végre a rekurzív folyamat.
   */
  private final int iteration;

  /**
   * Az x tengely méretarányának mértékegysége.
   */
  private final double unitX;

  /**
   * Az y tengely méretarányának mértékegysége.
   */
  private final double unitY;

  /**
   * A panelen megjelenő fraktál a ComplexNumber objektumok listájából épül fel, amelyet a Mandelbrot osztály generál.
   */
  private List<ComplexNumber> complexNumbers;

  /**
   * A fraktál alakzat kiszámítása.
   */
  private Mandelbrot mandelbrot;

  /**
   * Létrehoz egy panelt a Mandelbrot-halmaz megjelenítésére a megadott iterációszámmal
   * és alapértelmezett méretarányokkal 2.0 az x és y tengelyek mentén.
   * @param iteration Az iterációk száma, amely meghatározza a Mandelbrot-halmaz generálásának részletességét.
   */
  public Panel(int iteration) {
    this(iteration, 2.0, 2.0);
  }

  /**
   * Létrehoz egy panelt a Mandelbrot-halmaz megjelenítésére a megadott iterációszámma
   * és méretarányokkal az x és y tengelyek mentén.
   * @param iteration Az iterációk száma, amely meghatározza a Mandelbrot-halmaz generálásának részletességét.
   * @param unitX Az x tengely mentén alkalmazott méretarány.
   * @param unitY Az y tengely mentén alkalmazott méretarány.
   */
  public Panel(int iteration, double unitX, double unitY) {
    this.unitX = unitX;
    this.unitY = unitY;
    this.iteration = iteration;
    complexNumbers = new ArrayList<>();
    addMouseMotionListener(this);
    setBackground(Color.BLACK);
  }

  /**
   * Felülírja a JPanel paintComponent metódusát,
   * hogy kirajzolja a Mandelbrot-halmazt és a derékszögű koordináta rendszert a panelen.
   * Ezt a metódust a Swing keretrendszer automatikusan meghívja, amikor a panel újrarajzolódik.
   * @param g A <code>Graphics</code> objektumot védeni, amely a rajzolásért felelős.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = getWidth();
    int height = getHeight();
    paintCartesianCoordinateSystem(g, width, height);
    paintFractal(g, panelCoordinateList(width, height));
    paintComplexNumber(g);
  }

  /**
   * Kezeli az egér mozgását a panelen.
   * A metódus újra kiszámítja a Mandelbrot-halmazt az aktuális egérpozíció alapján,
   * és újrarajzoltatja a panelt.
   * @param e a feldolgozandó esemény, amely az egér mozgási eseményt írja le.
   */
  @Override
  public void mouseMoved(MouseEvent e) {
    PanelCoordinate mousePanelCoordinate = new PanelCoordinate(e.getX(), e.getY());
    ComplexNumber c = ComplexNumber.parseComplexNumber(mousePanelCoordinate, getWidth(), getHeight(), unitX, unitY);
    complexNumbers.clear();
    mandelbrot = new Mandelbrot(iteration, c);
    mandelbrot.mandelbrotSet(complexNumbers);

    repaint();
  }

  /**
   * A ComplexNumber objektumok listáját PanelCoordinate objektumok listájává alakítja,
   * amelyek a panel koordinátáit képviselik.
   * @param width A panel szélessége.
   * @param height A panel magassága.
   * @return A PanelCoordinate objektumok listája.
   */
  private List<PanelCoordinate> panelCoordinateList(int width, int height) {
    List<PanelCoordinate> list = new ArrayList<>();
    for (ComplexNumber c : complexNumbers) {
      list.add(PanelCoordinate.parsePanelCoordinate(c, width, height, unitX, unitY));
    }
    return list;
  }

  /**
   * Kirajzolja a derékszögű koordináta rendszert x és y tengelyeket a panel közepén.
   * @param g Objektum, amely a rajzolásért felelős.
   * @param width A panel szélessége.
   * @param height A panel magassága.
   */
  private void paintCartesianCoordinateSystem(Graphics g, int width, int height) {
    int centerX = width / 2;
    int centerY = height / 2;
    g.setColor(Color.GRAY);
    g.drawLine(0, centerY, width, centerY);
    g.drawLine(centerX, 0, centerX, height);
  }

  /**
   * Kirajzolja a Mandelbrot-halmazt a panelre, összekötve a PanelCoordinate listában található pontokat.
   * @param g Objektum, amely a rajzolásért felelős.
   * @param list A lista, amelyek a Mandelbrot-halmaz pontjait képviselik.
   */
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

  /**
   * Megjeleníti a jelenlegi komplex számot a panel bal felső sarkában.
   * @param g Objektum, amely a rajzolásért felelős.
   */
  private void paintComplexNumber(Graphics g) {
    if (!complexNumbers.isEmpty()) {
      g.setColor(Color.GREEN);
      g.drawString("C = " + complexNumbers.get(1).toStringFormat(), 10, 20);
    }
  }
}
