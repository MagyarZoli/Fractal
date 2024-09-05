package org.example.model;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ComplexNumberArguments {

  private static Stream<Arguments> addExample() {
    return Stream.of(
        Arguments.of(
            new ComplexNumber(2.0, 7.0),
            new ComplexNumber(3.0, -4.0),
            new ComplexNumber(5.0, 3.0)
        ),
        Arguments.of(
            new ComplexNumber(0.0, 0.0),
            new ComplexNumber(0.0, 0.0),
            new ComplexNumber(0.0, 0.0)
        ),
        Arguments.of(
            new ComplexNumber(-1.0, -1.0),
            new ComplexNumber(1.0, 1.0),
            new ComplexNumber(0.0, 0.0)
        ),
        Arguments.of(
            new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE),
            new ComplexNumber(Double.MIN_VALUE, Double.MIN_VALUE),
            new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE)
        )
    );
  }

  private static Stream<Arguments> subtractExample() {
    return Stream.of(
        Arguments.of(
            new ComplexNumber(9.0, 5.0),
            new ComplexNumber(4.0, 7.0),
            new ComplexNumber(5.0, -2.0)
        ),
        Arguments.of(
            new ComplexNumber(0.0, 0.0),
            new ComplexNumber(0.0, 0.0),
            new ComplexNumber(0.0, 0.0)
        ),
        Arguments.of(
            new ComplexNumber(-10.0, -5.0),
            new ComplexNumber(-10.0, -5.0),
            new ComplexNumber(0.0, 0.0)
        ),
        Arguments.of(
            new ComplexNumber(Double.MIN_VALUE, Double.MIN_VALUE),
            new ComplexNumber(Double.MIN_VALUE, Double.MIN_VALUE),
            new ComplexNumber(0.0, 0.0)
        )
    );
  }

  private static Stream<Arguments> multiplyExample() {
    return Stream.of(
        Arguments.of(
            new ComplexNumber(3.0, 2.0),
            new ComplexNumber(5.0, 6.0),
            new ComplexNumber(3.0, 28.0)
        ),
        Arguments.of(
            new ComplexNumber(0.0, 0.0),
            new ComplexNumber(5.0, 6.0),
            new ComplexNumber(0.0, 0.0)
        ),
        Arguments.of(
            new ComplexNumber(1.0, 0.0),
            new ComplexNumber(5.0, 6.0),
            new ComplexNumber(5.0, 6.0)
        ),
        Arguments.of(
            new ComplexNumber(-3.0, 4.0),
            new ComplexNumber(4.0, 3.0),
            new ComplexNumber(-24.0, 7.0)
        )
    );
  }

  private static Stream<Arguments> divideExample() {
    return Stream.of(
        Arguments.of(
            new ComplexNumber(3.0, 2.0),
            new ComplexNumber(4.0, -5.0),
            new ComplexNumber((2 / 41.0), (23 / 41.0))
        ),
        Arguments.of(
            new ComplexNumber(0.0, 0.0),
            new ComplexNumber(1.0, 1.0),
            new ComplexNumber(0.0, 0.0)
        ),
        Arguments.of(
            new ComplexNumber(1.0, 1.0),
            new ComplexNumber(1.0, -1.0),
            new ComplexNumber(0.0, 1.0)
        ),
        Arguments.of(
            new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE),
            new ComplexNumber(1.0, 0.0),
            new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE)
        )
    );
  }

  private static Stream<Arguments> coordinateExample() {
    return Stream.of(
        Arguments.of(
            new Coordinate(3.0, 2.0),
            new ComplexNumber(3.0, 2.0)
        ),
        Arguments.of(
            new Coordinate(0.0, 0.0),
            new ComplexNumber(0.0, 0.0)
        ),
        Arguments.of(
            new Coordinate(-1.0, -1.0),
            new ComplexNumber(-1.0, -1.0)
        )
    );
  }

  private static Stream<Arguments> panelCoordinateExample() {
    return Stream.of(
        Arguments.of(
            new PanelCoordinate(640, 240),
            800, 800, 2.0, 2.0,
            new ComplexNumber((3 / 5.0), (2 / 5.0))
        ),
        Arguments.of(
            new PanelCoordinate(400, 400),
            800, 800, 2.0, 2.0,
            new ComplexNumber(0.0, 0.0)
        ),
        Arguments.of(
            new PanelCoordinate(0, 0),
            800, 800, 2.0, 2.0,
            new ComplexNumber(-1.0, 1.0)
        ),
        Arguments.of(
            new PanelCoordinate(800, 800),
            800, 800, 2.0, 2.0,
            new ComplexNumber(1.0, -1.0)
        )
    );
  }
}
