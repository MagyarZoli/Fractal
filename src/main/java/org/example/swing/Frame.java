package org.example.swing;

import javax.swing.JFrame;

/**
 * Egy ablakot hoz létre a Mandelbrot megjelenítéséhez.
 */
public class Frame extends JFrame {

  /**
   * Létrehoz egy 400x400 méretű ablakot,
   * amelyben a Mandelbrot megjelenik a megadott iterációszámmal
   * és alapértelmezett méretarányokkal 2.0 az x és y tengelyek mentén.
   * @param iteration Az iterációk száma, amely meghatározza a Mandelbrot generálásának részletességét.
   */
  public Frame(int iteration) {
    this(iteration, 400, 400);
  }

  /**
   * Létrehoz egy megadott méretű ablakot,
   * amelyben a Mandelbrot-halmaz megjelenik a megadott iterációszámmal
   * és alapértelmezett méretarányokkal 2.0 az x és y tengelyek mentén.
   * @param iteration Az iterációk száma, amely meghatározza a Mandelbrot generálásának részletességét.
   * @param width Az ablak szélessége.
   * @param height Az ablak magassága.
   */
  public Frame(int iteration, int width, int height) {
    this(iteration, width, height, 2.0, 2.0);
  }

  /**
   * Létrehoz egy megadott méretű ablakot,
   * amelyben a Mandelbrot megjelenik a megadott iterációszámmal
   * és méretarányokkal az x és y tengelyek mentén.
   * @param iteration Az iterációk száma, amely meghatározza a Mandelbrot generálásának részletességét.
   * @param width Az ablak szélessége.
   * @param height Az ablak magassága.
   * @param unitX Az x tengely mentén alkalmazott méretarány.
   * @param unitY Az y tengely mentén alkalmazott méretarány.
   */
  public Frame(int iteration, int width, int height, double unitX, double unitY) {
    super("Mandelbrot");
    this.setSize(width, height);
    this.add(new Panel(iteration, unitX, unitY));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
}
