package org.example.formula;

import org.example.model.ComplexNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MandelbrotTest {

  private List<ComplexNumber> list;

  @BeforeEach
  void setUp() {
    list = new ArrayList<>();
  }

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

  @ParameterizedTest
  @ValueSource(doubles = {0.0, 1.0, -1.0, 0.2, -0.2})
  void mandelbrotSingleIterationTest(double value) {
    Mandelbrot mandelbrot = new Mandelbrot(1, new ComplexNumber(value, value));
    mandelbrot.mandelbrotSet(list);

    assertThat(list).hasSize(1);
    assertThat(list.get(0)).isEqualTo(new ComplexNumber(0.0, 0.0));
  }

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