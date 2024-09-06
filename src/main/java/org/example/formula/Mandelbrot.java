package org.example.formula;

import org.example.model.ComplexNumber;

import java.util.List;

/**
 * A Mandelbrot egy komplex síkon található fraktál, amelyet iterációs szabályok alapján hoznak létre.
 */
public class Mandelbrot {

  /**
   * Az iterációk maximális száma, amely meghatározza, hogy hányszor hajtódik végre a rekurzív folyamat.
   */
  private final int iteration;

  /**
   * A komplex szám, amely a Mandelbrot generálásához szükséges.
   */
  private final ComplexNumber c;

  /**
   * Létrehoz egy új Mandelbrot példányt a megadott maximális iterációszámmal és komplex számmal.
   * @param iteration Az iterációk maximális száma.
   *                  A negatív értékek pozitívvá konvertálódnak.
   * @param c A komplex szám, amelyet a Mandelbrot generálása során használnak.
   */
  public Mandelbrot(int iteration, ComplexNumber c) {
    this.iteration = Math.abs(iteration);
    this.c = c;
  }

  /**
   * Elindítja a Mandelbrot generálását a (0 + 0i) kezdőértékkel,
   * és a generált komplex számokat hozzáadja a megadott listához.
   * @param list Generált Mandelbrot-számokat tárolja.
   */
  public void mandelbrotSet(List<ComplexNumber> list) {
    mandelbrotSet(list, new ComplexNumber(0.0, 0.0));
  }

  /**
   * Ez a rekurzív metódus generálja a Mandelbrot elemeit a megadott komplex szám (x) alapján.
   * Az iterációk során minden egyes lépésben az aktuális komplex szám négyzetét hozzáadják a korábban megadott c komplex számhoz,
   * majd az eredményt hozzáadják a listához. A folyamat mindaddig folytatódik, amíg el nem érik a maximális iterációszámot.
   * @param list Generált komplex számokat tárolja.
   * @param x A kiinduló komplex szám, amelyet iterációval módosul.
   * @throws StackOverflowError Mivel a metódus rekurzívan hívja önmagát, egy nagyobb iterációszám esetén StackOverflowError fordulhat elő.
   *                            Az iteráció szám lekorlátozódik a lehető legnagyobb értékre.
   */
  private void mandelbrotSet(List<ComplexNumber> list, ComplexNumber x) {
    list.add(x);
    if (list.size() < iteration) {
      try {
        mandelbrotSet(list, x.multiply(x).add(c));
      } catch (StackOverflowError ignore) {}
    }
  }
}
