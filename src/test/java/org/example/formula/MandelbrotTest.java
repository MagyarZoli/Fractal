package org.example.formula;

import org.example.model.ComplexNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Egységtesztek a Mandelbrot osztályhoz.
 * Ez a tesztosztály ellenőrzi a Mandelbrot halmazszámítás helyes végrehajtását és teljesítményét.
 */
public class MandelbrotTest {

  /**
   * A ComplexNumber példányok listája.
   */
  private List<ComplexNumber> list;

  /**
   * Inicializálja a listát, amely tartalmazza a ComplexNumber példányokat minden egyes teszt előtt.
   */
  @BeforeEach
  void setUp() {
    list = new ArrayList<>();
  }

  /**
   * Ez a paraméterezett teszt a Mandelbrot futtatja különféle rekurziós mélységekkel.
   * <li>A ComplexNumber példányok listája nem lehet nulla.</li>
   * <li>A listában szereplő összes ComplexNumber értéke nem lehet nulla.</li>
   * @param iteration rekurziós mélység a Mandelbrot halmaz kiszámításához.
   */
  @ParameterizedTest
  @ValueSource(ints = {
      0, 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000,
      Integer.MAX_VALUE, Integer.MIN_VALUE,
      -1, -10, -100, -1_000, -10_000, -100_000, -1_000_000,
  })
  void mandelbrotIterationTest(int iteration) {
    Mandelbrot mandelbrot = new Mandelbrot(iteration, new ComplexNumber(0.2, 0.2));
    mandelbrot.mandelbrotSet(list);

    assertThat(list).isNotNull();
    list.forEach(i -> assertThat(i).isNotNull());
  }

  /**
   * Ellenőrzi, hogy a Mandelbrot-halmaz számítása helyesen tölti-e fel
   * a listát egyetlen komplex számmal amikor a rekurziós mélység 1.
   * <li>Egy iteráció esetén csak a kezdeti értéknek kell szerepelnie a listában</li>
   * <li>Az első érték egyeznie kell a kezdeti értékkel</li>
   * @param value komplex szám valós és képzetes része.
   */
  @ParameterizedTest
  @ValueSource(doubles = {0.0, 1.0, -1.0, 0.2, -0.2})
  void mandelbrotSingleIterationTest(double value) {
    Mandelbrot mandelbrot = new Mandelbrot(1, new ComplexNumber(value, value));
    mandelbrot.mandelbrotSet(list);

    assertThat(list).hasSize(1);
    assertThat(list.get(0)).isEqualTo(new ComplexNumber(0.0, 0.0));
  }

  /**
   * Nagyon nagy vagy kicsi értékekkel teszteli a Mandelbrot halmazszámítást.
   * <li>A ComplexNumber példányok listája nem lehet nulla.</li>
   * <li>A listában szereplő összes ComplexNumber értéke nem lehet nulla.</li>
   * @param value komplex szám valós és képzetes része.
   */
  @ParameterizedTest
  @ValueSource(doubles = {
      Double.MAX_VALUE, -Double.MAX_VALUE,
      Double.MIN_VALUE, -Double.MIN_VALUE
  })
  void mandelbrotExtremeValuesTest(double value) {
    Mandelbrot mandelbrot = new Mandelbrot(10, new ComplexNumber(value, value));
    mandelbrot.mandelbrotSet(list);

    assertThat(list).isNotEmpty();
    list.forEach(i -> assertThat(i).isNotNull());
  }
}